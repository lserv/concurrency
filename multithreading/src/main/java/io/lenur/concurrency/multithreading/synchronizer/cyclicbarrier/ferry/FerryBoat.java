package io.lenur.concurrency.multithreading.synchronizer.cyclicbarrier.ferry;

import java.util.concurrent.TimeUnit;

//The task that will be performed when the parties reach the barrier
class FerryBoat implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("The ferry has ferried cars");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
