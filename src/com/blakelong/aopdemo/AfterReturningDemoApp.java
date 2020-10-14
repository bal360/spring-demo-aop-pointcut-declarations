package com.blakelong.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blakelong.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {
	
	public static void main(String[] args) {
		
		// read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call findAccounts()
		List<Account> accounts = accountDAO.findAccounts();

		// display account
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("-----------------------");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();
		
	}
}
