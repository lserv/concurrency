package io.lenur.concurrency.multithreading.lock.readwrite;

import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeArrayList<String> list = new ThreadSafeArrayList<>();
        for (int i=1; i < 5; i++) {
            new Thread(new AddThread(list, String.valueOf(i))).start();
        }

        TimeUnit.SECONDS.sleep(1);
        for (int i=0; i < 4; i++) {
            System.out.println(list.get(i));
        }
    }
}
