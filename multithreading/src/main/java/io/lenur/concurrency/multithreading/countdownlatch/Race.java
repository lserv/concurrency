package io.lenur.concurrency.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Race {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(7);

        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50), countDownLatch)).start();
            Thread.sleep(1000);
        }

        while (countDownLatch.getCount() > 3) {
            Thread.sleep(100);
        }

        Thread.sleep(1000);
        System.out.println("Attention!");
        countDownLatch.countDown();//increase the counter
        Thread.sleep(1000);
        System.out.println("Start!");
        countDownLatch.countDown();
        //the counter is zeroed
        //all threads are unlocked
    }
}
