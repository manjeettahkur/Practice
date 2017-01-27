package com.intuit;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by laxminarayanvarma on 29/11/16.
 */
public class Question1 {
    public static void main(String args[]) {
        ArrayList<Integer> queue = new ArrayList<>();
        int size = 3;
        Thread producer = new Thread(new ProducerThread(queue, size), "ProducerThread");
        Thread consumer = new Thread(new ConsumerThread(queue, size), "ConsumerThread");
        producer.start();
        consumer.start();
    }

}
