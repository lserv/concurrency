package io.lenur.concurrency.multithreading.counter;

public class ThreadCounter implements Runnable {
    private final Countable counter;
    private final String name;

    public ThreadCounter(Countable counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (counter.getValue() >= Countable.MAX_ITERATION) {
                break;
            }
            counter.increment();
            String msg = String.format("%s handled, current counter is %d",
                    name,
                    counter.getValue());
            System.out.println(msg);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
