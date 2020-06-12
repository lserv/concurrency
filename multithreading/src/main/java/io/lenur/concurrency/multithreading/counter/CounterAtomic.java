package io.lenur.concurrency.multithreading.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtomic implements Countable {
    private final AtomicInteger atomic = new AtomicInteger(0);

    @Override
    public void increment() {
        atomic.incrementAndGet();
    }

    @Override
    public int getValue() {
        return atomic.get();
    }
}
