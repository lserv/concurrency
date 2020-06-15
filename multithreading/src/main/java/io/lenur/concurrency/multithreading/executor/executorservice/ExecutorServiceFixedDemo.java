package io.lenur.concurrency.multithreading.executor.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceFixedDemo {
    private final static int POLL_SIZE = 4;
    private final static int TASKS_SIZE = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(POLL_SIZE);

        for (int i = 0; i < TASKS_SIZE; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                String taskName = "task-" + taskNumber;
                String threadName = Thread.currentThread().getName();
                System.out.printf("%s executes %s\n", threadName, taskName);
            });
        }

        executor.shutdown();//if we don't handle this method, the main thread invoke infinitely
        //executor.shutdownNow() finished right now
    }
}
