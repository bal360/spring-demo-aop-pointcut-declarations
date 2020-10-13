package com.blakelong.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// really just a java class where we have all of our related advices
	// this is where we add all of our related advices
	
	// start with an @Before
	
	@Before("execution(* com.blakelong.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n===> Executing @Before advice on method");
	}
	
}
