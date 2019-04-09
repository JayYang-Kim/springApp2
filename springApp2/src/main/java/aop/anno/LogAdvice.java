package aop.anno;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * @Aspect ������̼�
 * �������Ͽ��� Advice �� Pointcut���� ������ ���� �ʰ� �ڵ����� Advice�� ����
 */

@Aspect
public class LogAdvice {
	private Log log = LogFactory.getLog(LogAdvice.class);
	
	/*
	 * ���� �޼ҵ�
	 * private void �̾�� �ϸ� body�� ������Ѵ�.
	 * �޼ҵ���� target�̶�� ������ �� ����. 
	 */
	@Pointcut("execution(public * aop.anno.*.*(..))")
	private void profileTarget() {
		
	}
	
	@Before("profileTarget()")
	public String beforeLogging(JoinPoint join) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " �޼ҵ� ȣ�� ��";
		log.trace(s);
		
		System.out.println(s);
		
		return methodName;
	}
	
	@AfterReturning(value="profileTarget()", returning="ret")
	public void returningLogging(JoinPoint join, Object ret) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " �޼ҵ尡 ���� ���� ����� �� ȣ��";
		log.trace(s);
		
		System.out.println(s);
	}
	
	@AfterThrowing(value="profileTarget()", throwing="ex")
	public void throwingLogging(JoinPoint join, Throwable ex) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " �޼ҵ忡�� ���ܹ߻�, ���� Ŭ���� : " + ex.getClass().getName();
		log.trace(s);
		
		System.out.println(s);
	}
	
	@After("profileTarget()")
	public void afterLogging(JoinPoint join) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " �޼ҵ尡 ����� �� ȣ��(���ܰ� �߻��ϰų� ���� �ʾƵ� ȣ��)";
		log.trace(s);
		
		System.out.println(s);
	}
}
