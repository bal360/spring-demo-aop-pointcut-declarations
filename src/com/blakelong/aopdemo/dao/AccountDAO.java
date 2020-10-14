package com.blakelong.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.blakelong.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass() + ": Doing my db work: adding an account");
	}
	
	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		
		// create sample accounts
		Account acc1 = new Account("Blake", "Silver");
		Account acc2 = new Account("Wes", "Gold");
		Account acc3 = new Account("John", "Platinum");
		
		// add them to our accounts list
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);
		
		return accounts;
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
	
	public String getName() {
		System.out.println(getClass() + ": getName() called");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName() called");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode() called");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ ": setServiceCode() called");
		this.serviceCode = serviceCode;
	}
	
}
