package io.lenur.concurrency.multithreading.synchronizer.phaser.race;

import java.util.concurrent.Phaser;

class Car implements Runnable {
    private static final int TRACK_LENGTH = 500000;

    private final int carNumber;
    private final int carSpeed;
    private final Phaser phaser;

    public Car(int carNumber, int carSpeed, Phaser phaser) {
        this.carNumber = carNumber;
        this.carSpeed = carSpeed;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            System.out.printf("The car №%d is coming into start line.\n", carNumber);
            phaser.arriveAndDeregister();
            phaser.awaitAdvance(0);
            Thread.sleep(TRACK_LENGTH / carSpeed);
            System.out.printf("The car №%d has finished!\n", carNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}