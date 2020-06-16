package io.lenur.concurrency.multithreading.executor.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(new int[]{50, 22, 31, 42, 59});
        forkJoinPool.execute(customRecursiveTask);

        int result = customRecursiveTask.join();
        System.out.println(result);
    }
}
