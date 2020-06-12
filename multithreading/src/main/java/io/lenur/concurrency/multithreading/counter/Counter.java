package io.lenur.concurrency.multithreading.counter;

public class Counter implements Countable {
    private int iteration = 0;

    @Override
    public int getValue() {
        return iteration;
    }

    @Override
    public synchronized void increment() {
        iteration++;
    }
}
