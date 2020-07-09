package io.lenur.concurrency.multithreading.lock.conditional.demo1;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private final Store store;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 3; i++) {
            store.get();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}