package com.blakelong.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyAccount() {
		
		System.out.println(getClass() + ": Doing my db work: adding a membership account");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": goToSleep()");
	}

}