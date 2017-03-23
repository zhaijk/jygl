package com.derun.aopTEST;

//import org.aspectj.lang.annotation.After;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class unitTEST {
	
	@Pointcut("execution(* com.derun.aopTEST.haha.add(..))")
	public void pc(){
		
	}
//	@Before("pc()")
//	public void before(){
//		System.out.println("前面");
//	}
//	@After("pc()")
//	public void after(){
//		System.out.println("后面");
//	}
	//public void around(ProceedingJoinPoint jp) throws Throwable{
	//@Before("pc()")
	@Around("pc()")
	public void around(ProceedingJoinPoint jp) throws Throwable{
		
		System.out.println("1");		
		jp.proceed();
		System.out.println("2");
		
	}
//	public void nativeMethod(ProceedingJoinPoint jp) {
//		System.out.println("a");
//		try {
//			jp.proceed();
//		} catch (Throwable e) {
//			//System.out.println("error1");
//			//System.out.println(e);
//			//System.out.println("error2");
//			//e.printStackTrace();
//		}
//		System.out.println("r");
//	}
//	@Before("execution(* com.derun.aopTEST.calc.add(..))")
//	public void nativeMethod() throws Throwable{
//		System.out.println("Before");		
//		
//	}
//	@After("execution(* com.derun.aopTEST.calc.add(..))")
//	public void nativeMethoda() throws Throwable{
//		System.out.println("After");		
//		
//	}
//	@Around("execution(* com.yiibai.customer.bo.CustomerBo.addCustomerAround(..))")
//	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//
//		System.out.println("logAround() is running!");
//		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
//		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
//		
//		System.out.println("Around before is running!");
//		joinPoint.proceed();
//		System.out.println("Around after is running!");
//		
//		System.out.println("******");
//
//	}
}
