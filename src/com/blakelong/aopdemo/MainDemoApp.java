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
		
		Account account = new Account();
		// call the business method
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
		// call the membership business method
		membershipDAO.addSillyAccount();
		membershipDAO.goToSleep();

		// close the context
		context.close();
		
	}
}
