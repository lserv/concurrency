package io.lenur.concurrency.multithreading.executor.futureandcallable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 5;
        };
        int result = callable.call();

        System.out.println(result);
    }
}
