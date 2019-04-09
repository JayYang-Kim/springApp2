package aop.xml;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	private Log log = LogFactory.getLog(LogAdvice.class);
	
	public String beforeLogging(JoinPoint join) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " 메소드 호출 전";
		log.trace(s);
		
		System.out.println(s);
		
		return methodName;
	}
	
	public void returningLogging(JoinPoint join, Object ret) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " 메소드가 예외 없이 실행된 후 호출";
		log.trace(s);
		
		System.out.println(s);
	}
	
	public void throwingLogging(JoinPoint join, Throwable ex) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " 메소드에서 예외발생, 예외 클래스 : " + ex.getClass().getName();
		log.trace(s);
		
		System.out.println(s);
	}
	
	public void afterLogging(JoinPoint join) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " 메소드가 실행된 후 호출(예외가 발생하거나 하지 않아도 호출)";
		log.trace(s);
		
		System.out.println(s);
	}
}
