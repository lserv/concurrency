package io.lenur.concurrency.multithreading.synchronizer.phaser.demo;

import java.util.concurrent.Phaser;

class PhaseThread implements Runnable{
    private final Phaser phaser;
    private final  String name;

    public PhaseThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    public void run(){
        System.out.println(name + " takes a part in a phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // the first phase was reached
         
        System.out.println(name + " takes a part in a phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // the second phase was reached
 
        System.out.println(name + " takes a part in a phase " + phaser.getPhase());
        phaser.arriveAndDeregister(); // the phases were finished and delete all object from registration
    }
}