package io.lenur.concurrency.multithreading.synchronizer.thread.waitnotify;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Sender implements Runnable {
    private static final Logger LOGGER = Logger
            .getLogger(Sender.class.getName());

    private final Data data;

    public Sender(Data data) {
        this.data = data;
    }

    public void run() {
        String[] packets = {
          "First packet",
          "Second packet",
          "Third packet",
          "Fourth packet",
          "End"
        };
  
        for (String packet : packets) {
            data.send(packet);

            String msg = String
                    .format("Sent a message %s", packet);
            System.out.println(msg);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                LOGGER.warning("Thread interrupted");
            }
        }
    }
}