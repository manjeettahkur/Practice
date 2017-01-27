package com.snapdeal.twitterClient;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.snapdeal.twitterClient.DataInjector.TwitterStreamConsumer;;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class TwitterClient {

    public static void main(String[] args) {
    	List<String> trackerLisT = new LinkedList<String>();
		trackerLisT.add("Snapdeal");
		trackerLisT.add("Flipkart");
		//trackerLisT.add("amazon.in");
		for (String tracker : trackerLisT) {

			TwitterStreamConsumer streamConsumer = new TwitterStreamConsumer(
					tracker);
			streamConsumer.start();
		}
        SpringApplication.run(TwitterClient.class, args);
    }
}
