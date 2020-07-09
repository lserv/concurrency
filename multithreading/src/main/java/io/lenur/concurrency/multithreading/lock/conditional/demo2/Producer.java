package io.lenur.concurrency.multithreading.lock.conditional.demo2;

import java.util.List;

public class Producer extends Thread {
    private final SharedFiFoQueue queue;
    private final List<String> words = List.of("Tear", "Car", "Wheel");
    public Producer(SharedFiFoQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (String word : words) {
                queue.add(word);
            }
            //Terminate the execution.
            queue.add(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}