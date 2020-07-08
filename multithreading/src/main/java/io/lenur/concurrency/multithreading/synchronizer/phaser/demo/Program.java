package io.lenur.concurrency.multithreading.synchronizer.phaser.demo;

import java.util.concurrent.Phaser;

public class Program {
    public static void main(String[] args) {
        final Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // waiting for finishing a 0 phase
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("The phase " + phase + " was finished");
        // waiting for finishing a 1 phase
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("The phase " + phase + " was finished");

        // waiting for finishing a 2 phase
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("The phase " + phase + " was finished");

        phaser.arriveAndDeregister();
    }
}