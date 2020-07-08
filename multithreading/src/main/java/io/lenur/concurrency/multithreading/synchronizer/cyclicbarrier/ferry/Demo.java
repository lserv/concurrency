package io.lenur.concurrency.multithreading.synchronizer.cyclicbarrier.ferry;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        final CyclicBarrier barrier =
                new CyclicBarrier(3, new FerryBoat());

        for (int i = 0; i < 9; i++) {
            new Thread(new Car(i, barrier)).start();
            TimeUnit.MILLISECONDS.sleep(400);
        }
    }
}
