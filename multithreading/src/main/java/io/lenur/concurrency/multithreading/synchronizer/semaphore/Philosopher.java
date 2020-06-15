package io.lenur.concurrency.multithreading.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    private final Semaphore semaphore;
    private final String name;
    private boolean ate = false;

   Philosopher(Semaphore semaphore, String name) {
       this.semaphore = semaphore;
       this.name=name;
   }

   @Override
   public void run() {
       try {
           if (!ate) {
               semaphore.acquire();
               System.out.println (name + " sit down to the table");

               sleep(300);
               ate = true;

               System.out.println (name + " ate! He is getting up from the table");
               semaphore.release();

               sleep(300);
           }
       } catch(InterruptedException e) {
           e.printStackTrace();
       }
   }
}