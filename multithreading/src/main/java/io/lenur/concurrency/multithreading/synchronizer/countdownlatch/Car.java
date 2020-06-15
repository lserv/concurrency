package io.lenur.concurrency.multithreading.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;

class Car implements Runnable {
    private static final int TRACK_LENGTH = 500000;

    private final int carNumber;
    private final int carSpeed;
    private final CountDownLatch downLatch;

    public Car(int carNumber, int carSpeed, CountDownLatch downLatch) {
        this.carNumber = carNumber;
        this.carSpeed = carSpeed;
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        try {
            System.out.printf("The car №%d is ready for start.\n", carNumber);
            downLatch.countDown();//increase the counter
            downLatch.await();//block a thread until the counter will be zeroed
            Thread.sleep(TRACK_LENGTH / carSpeed);
            System.out.printf("The car №%d is finished!\n", carNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}