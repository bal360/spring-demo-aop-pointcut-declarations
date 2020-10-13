package com.blakelong.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blakelong.aopdemo.dao.AccountDAO;
import com.blakelong.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	
	public static void main(String[] args) {
		
		// read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account account = new Account();
		account.setName("blake");
		account.setLevel("Platinum");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
		// call getter and setter to test individual and combo advice(s)
		accountDAO.setName("stuff");
		accountDAO.setServiceCode("gold");
		
		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();
		
		// call the membership business method
		membershipDAO.addSillyAccount();
		membershipDAO.goToSleep();

		// close the context
		context.close();
		
	}
}
