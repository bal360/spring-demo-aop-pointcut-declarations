package com.blakelong.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyCloudLogAsyncAspect {
	
	AOPDeclarations aopDeclarations = new AOPDeclarations();
	
	@Before("com.blakelong.aopdemo.aspect.AOPDeclarations.forDaoPackageNoGetterAndSetters()")
	public void updateToCloud() {
		System.out.println("\n===> Logging to Cloud in async fashion");
	}
}
