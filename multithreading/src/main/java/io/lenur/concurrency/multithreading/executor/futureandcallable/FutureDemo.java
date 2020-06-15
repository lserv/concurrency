package io.lenur.concurrency.multithreading.executor.futureandcallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureDemo {
    private static final int POOL_SIZE = 2;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        Future<Integer> future1 = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 5;
        });

        Future<Integer> future2 = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 4;
        });

        int result = future1.get() + future2.get();
        System.out.println(result);//9
        executor.shutdown();
    }
}
