package io.lenur.concurrency.multithreading.synchronizer.cyclicbarrier.ferry;

import java.util.concurrent.CyclicBarrier;

//The sides, which will reach the barrier
class Car implements Runnable {
    private final int carNumber;
    private final CyclicBarrier barrier;

    public Car(int carNumber, CyclicBarrier barrier) {
        this.carNumber = carNumber;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.printf("The car №%d has come to the ferry.\n", carNumber);
            // To tell the thread that it has reached the barrier, you need to call the await () method
            // After this, this thread blocks and waits until the other parties reach the barrier
            barrier.await();
            System.out.printf("The car №%d has continued moving.\n", carNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}