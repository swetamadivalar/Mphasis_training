package com.test.spring.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAfterAspect {

	@After("args(name)")
	public void logStringArguments(String name) {
		System.out.println("Running After Advice String arguments passed");
	}
	
	@AfterThrowing("within(com.test.model.Employee)")
	public void logException(Joinpoint joinpoint) {
		System.out.println("Exception throw in employee mathod:"+joinpoint.toString());
	}
	@AfterReturning(pointcut="execution(* getName())",returning="returnstring")
	public void getNameReturningAdvice(String returnstring) {
		System.out.println("getNameReturning advice:"+returnstring);
	}
}
