package com.coikontroly.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.MongoClient;

public class CoiDbApp {

	/**
	 * Test of successful connection to MongoDB. If connection fails the application context is not loaded.
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-context.xml");
		System.out.println("creating MongoDB connection...");
		MongoClient client = (MongoClient) ctx.getBean("mongoClient");
		System.out.println("closing MongoDB connection...");
		client.close();
		((ConfigurableApplicationContext) ctx).close();
	}
}
