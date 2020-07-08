package io.lenur.concurrency.multithreading.synchronizer.phaser.bus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class Demo {
    public static void main(String[] args) {
        final Phaser phaser = new Phaser(1);
        List<Passenger> passengers = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            if ((int) (Math.random() * 2) > 0) {
                passengers.add(new Passenger(i, i + 1, phaser));
            }

            if ((int) (Math.random() * 2) > 0) {
                passengers.add(new Passenger(i, 5, phaser));
            }
        }

        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    System.out.println("A bus left from a park.");
                    phaser.arrive();
                    break;
                case 6:
                    System.out.println("A bus went to a park.");
                    phaser.arriveAndDeregister();
                    break;
                default:
                    int currentBusStop = phaser.getPhase();
                    System.out.println("A bus station № " + currentBusStop);

                    for (Passenger p : passengers) {
                        if (p.getDeparture() == currentBusStop) {
                            phaser.register();
                            p.start();
                        }
                    }

                    phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
