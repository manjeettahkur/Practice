package com.intuit;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by laxminarayanvarma on 29/11/16.
 */
public class ConsumerThread implements Runnable{
    private final ArrayList queue;
    private final int SIZE;

    public ConsumerThread(ArrayList sharedQueue, int size) {
        this.queue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println(ex.fillInStackTrace());
            }
        }
    }

    private int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            synchronized (queue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + queue.size());

                queue.wait();
            }
        }
        synchronized (queue) {
            queue.notifyAll();
            return (Integer) queue.remove(0);
        }
    }
}
