package com.intuit;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by laxminarayanvarma on 29/11/16.
 */
public class ProducerThread implements Runnable {
    private final ArrayList queue;
    private final int SIZE;

    public ProducerThread(ArrayList queue, int size) {
        this.queue = queue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Produced: " + i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
                System.out.println(ex.fillInStackTrace());
            }
        }
    }

    private void produce(int i) throws InterruptedException {

        while (queue.size() == SIZE) {
            synchronized (queue) {
                System.out.println("Queue full " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());

                queue.wait();
            }
        }
        synchronized (queue) {
            queue.add(i);
            queue.notifyAll();
        }
    }
}
