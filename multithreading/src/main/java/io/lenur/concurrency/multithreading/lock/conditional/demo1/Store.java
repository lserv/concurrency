package io.lenur.concurrency.multithreading.lock.conditional.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Store {
    private int countProducts = 0;
    private final ReentrantLock locker;
    private final Condition condition;

    Store() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void get() {
        locker.lock();
        try {
            // until we don't have available products in the store we should wait
            while (countProducts < 1) {
                condition.await();
            }

            countProducts--;
            System.out.println("A buyer has bought 1 product");
            System.out.println("Amount of products in the store: " + countProducts);

            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public void put() {
        locker.lock();
        try {
            // we should wait until we have less than 3 products
            while (countProducts >= 2) {
                condition.await();
            }

            countProducts++;
            System.out.println("The producer added 1 product");
            System.out.println("Amount of products in the store: " + countProducts);

            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}