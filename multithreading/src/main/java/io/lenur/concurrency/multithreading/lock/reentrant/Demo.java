package io.lenur.concurrency.multithreading.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        final CommonResource commonResource = new CommonResource();
        commonResource.init();
        final ReentrantLock locker = new ReentrantLock();

        for (int i = 1; i < 4; i++) {
            Thread t = new Thread(new CountThread(commonResource, locker));
            t.setName("Thread " + i);
            t.start();
        }
    }
}
