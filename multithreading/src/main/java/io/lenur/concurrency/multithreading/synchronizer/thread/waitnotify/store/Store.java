package io.lenur.concurrency.multithreading.synchronizer.thread.waitnotify.store;

import java.util.logging.Logger;

public class Store {
    private static final Logger LOGGER = Logger
            .getLogger(Store.class.getName());

    private int product = 0;

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                LOGGER.warning("Thread interrupted");
            }
        }

        product--;
        System.out.println("A buyer bought 1 product");
        System.out.println("The amount of products: " + product);
        notify();
    }

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                LOGGER.warning("Thread interrupted");
            }
        }
        product++;

        System.out.println("A producer added 1 product");
        System.out.println("The amount of products: " + product);
        notify();
    }
}