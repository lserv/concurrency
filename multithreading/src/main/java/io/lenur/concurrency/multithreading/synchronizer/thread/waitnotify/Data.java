package io.lenur.concurrency.multithreading.synchronizer.thread.waitnotify;

import java.util.logging.Logger;

public class Data {
    private static final Logger LOGGER = Logger
            .getLogger(Data.class.getName());

    private String packet;
    private boolean transfer = true;
  
    public synchronized void send(String packet) {
        while (!transfer) {
            try { 
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                LOGGER.warning("Thread interrupted");
            }
        }
        transfer = false;
         
        this.packet = packet;
        notifyAll();
    }
  
    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                LOGGER.warning("Thread interrupted");
            }
        }
        transfer = true;
 
        notifyAll();
        return packet;
    }
}