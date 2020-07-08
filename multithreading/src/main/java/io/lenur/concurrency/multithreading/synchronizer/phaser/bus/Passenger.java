package io.lenur.concurrency.multithreading.synchronizer.phaser.bus;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Passenger extends Thread {
    private final int departure;
    private final int destination;
    private final Phaser phaser;

    public Passenger(int departure, int destination, Phaser phaser) {
        this.departure = departure;
        this.destination = destination;
        this.phaser = phaser;
        System.out.println(this + " is waiting at the bus station № " + this.departure);
    }

    @Override
    public void run() {
        try {
            System.out.println(this + " took in into a bus.");

            while (phaser.getPhase() < destination) {
                phaser.arriveAndAwaitAdvance();
            }

            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + " take out a bus.");
            phaser.arriveAndDeregister();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "A passenger{" + departure + " -> " + destination + '}';
    }

    public int getDeparture() {
        return departure;
    }
}