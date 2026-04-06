package com.test.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointCut {

	@Before("getNamePointCut()")
	public void loggingAdvice() {
		System.out.println("execution logging advice on getName()");
	}
	
	@Before("getNamePointCut()")
	public void secondAdvice() {
		System.out.println("executing second advice on getName()");
	}
	
	@Before("execution(public String getName())")
	public void getNamePointCut() {
		
	}
	
	@Before("allMethodsPointCut()")
	public void allMethodsAdvice() {
		System.out.println("before executinh service method");
	}
	
	@Pointcut("within(com.test.service.*)")
	public void allMehtodsPointCut() {
		
	}
}
