package io.lenur.concurrency.multithreading.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class CountThread implements Runnable {
    private final CommonResource resource;
    private final ReentrantLock locker;

    public CountThread(CommonResource resource, ReentrantLock locker) {
        this.resource = resource;
        this.locker = locker;
    }

    public void run() {
        locker.lock();
        try {
            resource.init();
            for (int i = 1; i < 3; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), resource.getX());
                resource.increment();
                TimeUnit.MILLISECONDS.sleep(300);
            }
            System.out.println("=======FINISHED=======");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}