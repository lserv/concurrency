package io.lenur.concurrency.multithreading.lock.conditional.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedFiFoQueue {
    private final Object[] elements;
    private int current = 0;
    private int placeIndex = 0;
    private int removeIndex = 0;

    private final Lock locker = new ReentrantLock();
    private final Condition isEmpty = locker.newCondition();
    private final Condition isFull = locker.newCondition();

    public SharedFiFoQueue(int capacity) {
        this.elements = new Object[capacity];
    }

    public void add(Object elem) throws InterruptedException {
        locker.lock();
        while (current >= elements.length) {
            //The current thread suspends its execution until it is signalled or interrupted.
            isFull.await();
        }

        elements[placeIndex] = elem;

        //We need the modulo, in order to avoid going out of bounds.
        placeIndex = (placeIndex + 1) % elements.length;

        ++current;

        //Notify the consumer that there is data available.
        isEmpty.signal();

        locker.unlock();
    }

    public Object remove() throws InterruptedException {
        locker.lock();
        while (current <= 0) {
            isEmpty.await();
        }

        Object elem = elements[removeIndex];

        //We need the modulo, in order to avoid going out of bounds.
        removeIndex = (removeIndex + 1) % elements.length;

        --current;

        //Notify the producer that there is space available.
        isFull.signal();

        locker.unlock();

        return elem;
    }
}