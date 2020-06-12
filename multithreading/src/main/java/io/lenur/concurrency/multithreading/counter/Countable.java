package io.lenur.concurrency.multithreading.counter;

public interface Countable {
    int MAX_ITERATION = 50;

    void increment();

    int getValue();
}
