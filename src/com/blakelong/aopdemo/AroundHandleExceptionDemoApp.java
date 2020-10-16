package com.blakelong.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blakelong.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("Calling getFortune");
		
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
		
		// close the context
		context.close();
		
	}
}
