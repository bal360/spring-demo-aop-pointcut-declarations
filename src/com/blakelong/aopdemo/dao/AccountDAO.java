package com.blakelong.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.blakelong.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass() + ": Doing my db work: adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
