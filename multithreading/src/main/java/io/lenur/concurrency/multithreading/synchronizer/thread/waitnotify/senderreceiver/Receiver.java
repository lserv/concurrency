package io.lenur.concurrency.multithreading.synchronizer.thread.waitnotify.senderreceiver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Receiver implements Runnable {
    private final Data load;

    private static final Logger LOGGER = Logger
            .getLogger(Receiver.class.getName());

    public Receiver(Data load) {
        this.load = load;
    }

    public void run() {
        for (String receivedMessage = load.receive();
          !"End".equals(receivedMessage);
          receivedMessage = load.receive()) {

            String msg = String
                    .format("Received a message %s", receivedMessage);
            System.out.println(msg);
 
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.warning("Thread interrupted");
            }
        }
    }
}