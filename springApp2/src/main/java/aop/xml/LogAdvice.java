package aop.xml;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	private Log log = LogFactory.getLog(LogAdvice.class);
	
	public String beforeLogging(JoinPoint join) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " �޼ҵ� ȣ�� ��";
		log.trace(s);
		
		System.out.println(s);
		
		return methodName;
	}
	
	public void returningLogging(JoinPoint join, Object ret) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " �޼ҵ尡 ���� ���� ����� �� ȣ��";
		log.trace(s);
		
		System.out.println(s);
	}
	
	public void throwingLogging(JoinPoint join, Throwable ex) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " �޼ҵ忡�� ���ܹ߻�, ���� Ŭ���� : " + ex.getClass().getName();
		log.trace(s);
		
		System.out.println(s);
	}
	
	public void afterLogging(JoinPoint join) {
		String methodName = join.getSignature().getName();
		
		String s = methodName + " �޼ҵ尡 ����� �� ȣ��(���ܰ� �߻��ϰų� ���� �ʾƵ� ȣ��)";
		log.trace(s);
		
		System.out.println(s);
	}
}
