package aop.anno;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * @Aspect 어노테이션
 * 설정파일에서 Advice 및 Pointcut등의 설정을 하지 않고 자동으로 Advice를 적용
 */

@Aspect
public class LogAdvice2 {
	private Log log = LogFactory.getLog(LogAdvice2.class);
	
	@Before("execution(public * aop.anno.*.*(..))")
	public String beforeLogging(JoinPoint join) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " 메소드 호출 전";
		log.trace(s);
		
		System.out.println(s);
		
		return methodName;
	}
	
	@AfterReturning(pointcut="execution(public * aop.anno.*.*(..))", returning="ret")
	public void returningLogging(JoinPoint join, Object ret) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " 메소드가 예외 없이 실행된 후 호출";
		log.trace(s);
		
		System.out.println(s);
	}
	
	@AfterThrowing(pointcut="execution(public * aop.anno.*.*(..))", throwing="ex")
	public void throwingLogging(JoinPoint join, Throwable ex) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " 메소드에서 예외발생, 예외 클래스 : " + ex.getClass().getName();
		log.trace(s);
		
		System.out.println(s);
	}
	
	@After("execution(public * aop.anno.*.*(..))")
	public void afterLogging(JoinPoint join) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " 메소드가 실행된 후 호출(예외가 발생하거나 하지 않아도 호출)";
		log.trace(s);
		
		System.out.println(s);
	}
}
