package io.lenur.concurrency.multithreading.lock.reentrant;

public class CommonResource {
    private int x = 0;

    public int getX() {
        return x;
    }

    public void increment() {
        x++;
    }

    public void init() {
        x = 1;
    }
}