package com.blakelong.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {
	
	AOPDeclarations aopDeclarations = new AOPDeclarations();
	
	@Before("com.blakelong.aopdemo.aspect.AOPDeclarations.forDaoPackageNoGetterAndSetters()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n===> Executing @Before advice on method");
	}
	
}
