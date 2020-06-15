package io.lenur.concurrency.multithreading.executorservice;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSingleThreadDemo {
    public static void main(String[] args) {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number > 1) {
                executor.submit(new PrimeNumberPrinter(number));
            }
        }
        executor.shutdown();
    }

    private static class PrimeNumberPrinter implements Runnable {
        private final int number;

        public PrimeNumberPrinter(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            String msg = NumberUtil.isPrime(number)
                    ? String.format("The number %d is prime", number)
                    : String.format("The number %d is not prime", number);
            System.out.println(msg);
        }
    }

    private static class NumberUtil {
        public static boolean isPrime(int number) {
            for (int i = 2; i<=number/2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
