package com.blakelong.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPDeclarations {

	@Pointcut("execution(* com.blakelong.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	@Pointcut("execution(* com.blakelong.aopdemo.dao.*.get*(..))")
	public void getter() {};
	
	@Pointcut("execution(* com.blakelong.aopdemo.dao.*.set*(..))")
	public void setter() {};
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterAndSetters() {};
}
