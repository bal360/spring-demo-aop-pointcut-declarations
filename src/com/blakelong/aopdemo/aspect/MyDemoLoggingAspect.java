package com.blakelong.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.blakelong.aopdemo.Account;

@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {
	
	AOPDeclarations aopDeclarations = new AOPDeclarations();
	
	@Before("com.blakelong.aopdemo.aspect.AOPDeclarations.forDaoPackageNoGetterAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n===> Executing @Before advice on method");
		
		// display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method Signature: " + methodSignature);
		
		// display method arguments
			// get args
		Object[] args = joinPoint.getArgs();
		
			// print out args
		for (Object arg : args) {
			System.out.println(arg);
			
			if (arg instanceof Account) {
				// downcast and print Account specific info
				Account account = (Account) arg;
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
	}
	
	@AfterReturning(
			pointcut="execution(* com.blakelong.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		// print which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n====> result is: " + result);
		
		// post-process the data ... modify it
		// convert the account names to uppercase
		convertAccountNamesToUppercase(result);
		System.out.println("\n====> result is: " + result);
	}
	
	@After("execution(* com.blakelong.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.blakelong.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n====> The exception is: " + exception);
	}

	private void convertAccountNamesToUppercase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}
}
