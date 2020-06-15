package io.lenur.concurrency.multithreading.futureandcallable;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllDemo {
    private static final int POOL_SIZE = 4;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        List<Callable<Integer>> callableList = List.of(() -> 5, () -> 4, () -> 3);
        List<Future<Integer>> futureList = executor.invokeAll(callableList);

        int sum = 0;
        for (Future<Integer> future : futureList) {
            sum += future.get();
        }

        executor.shutdown();
        System.out.println(sum);
    }
}
