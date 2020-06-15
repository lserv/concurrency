package io.lenur.concurrency.multithreading.executor.executorservice;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceScheduledDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable command = () -> System.out.println(LocalTime.now() + ": Hello!");
        int initDelay = 1000;
        int period = 1000;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        executor.scheduleAtFixedRate(command, initDelay, period, unit);
        //08:39:49.221961: Hello!
        //08:39:50.123106: Hello!
        //08:39:51.122829: Hello!
        //08:39:52.122822: Hello!
        //...
    }
}
