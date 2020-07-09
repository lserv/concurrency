package io.lenur.concurrency.multithreading.lock.conditional.demo1;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private final Store store;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 3; i++) {
            store.put();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}