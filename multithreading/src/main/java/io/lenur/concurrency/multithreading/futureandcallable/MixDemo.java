package io.lenur.concurrency.multithreading.futureandcallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MixDemo {
    private static final int POOL_SIZE = 2;

    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 5;
        };

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        Future<Integer> future1 = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 4;
        });

        Future<Integer> future2 = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 3;
        });

        int result = callable.call() + future1.get() + future2.get();
        System.out.println(result);//12

        executor.shutdown();
    }
}
