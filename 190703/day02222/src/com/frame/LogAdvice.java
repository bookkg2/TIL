package com.frame;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class LogAdvice {
	Date d = new Date();
	public void printLog() {
		Date d = new Date();
		System.out.println(d+ "[공통 로그 ] 비즈니스 로직 수행  ....");
	}
	
	/*
	 * @Before("execution(* com.user..*Biz.*(..))") public void beforeLog(JoinPoint
	 * jp) { String method = jp.getSignature().getName();// 함수 이름 찍기 Object [] args
	 * = jp.getArgs();//argument 찍기 System.out.println(method + ": " + args[0]);
	 * System.out.println("[before] 비즈니스 로직 수행  ...."); }
	 */
	
	/*
	 * @AfterReturning(pointcut="execution(* com.user..*Biz.*(..))",returning=
	 * "returnObj") public void afterLog(JoinPoint jp,Object returnObj) {
	 * 
	 * System.out.println("[after] 비즈니스 로직 수행  ....");
	 * System.out.println("Log Result : " + returnObj); }
	 */
	@AfterThrowing(pointcut="execution(* com.user..*Biz.*(..))",throwing ="ex")
	public void exLog(JoinPoint jp,Exception ex) {
		Date d = new Date();
		System.out.println(d+ "[EX 로그 ] Exception ..");
		System.out.println(ex.getMessage());
	}
	
	@Around("execution(* com.user..*Biz.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		System.out.println("Before Action ...");
		Object obj = pjp.proceed();
		System.out.println("After Action");
		stopwatch.stop();
		
		System.out.println("Processing Time" + stopwatch.getTotalTimeSeconds());
		return obj;
	}
}
