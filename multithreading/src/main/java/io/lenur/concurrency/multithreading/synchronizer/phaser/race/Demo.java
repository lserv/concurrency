package io.lenur.concurrency.multithreading.synchronizer.phaser.race;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser = new Phaser(7);
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new Car(i, (int) (Math.random() * 100 + 50), phaser));
            thread.start();
            TimeUnit.SECONDS.sleep(1);
        }

        while (phaser.getRegisteredParties() > 3) {
            TimeUnit.SECONDS.sleep(1);
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Ready?");
        phaser.arriveAndDeregister();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("GO!");
        phaser.arriveAndDeregister();
    }
}
