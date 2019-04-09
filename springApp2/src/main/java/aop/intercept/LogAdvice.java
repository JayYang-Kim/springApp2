package aop.intercept;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// MethodInterceptor : 메소드 실행 전, 후 또는 예외발생 시 공통 사항을 실행할 수 있다.
public class LogAdvice implements MethodInterceptor {
	private Log log = LogFactory.getLog(LogAdvice.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 대상 객체 메소드 호출 전
		String s;
		s = invocation.getMethod().getName() + " 메소드 호출 전";
		
		log.trace(s);
		System.out.println(s);
		
		// 대상 객체 메소드 호출
		Object returnValue = invocation.proceed();
		
		// 대상 객체 메소드 호출 후
		s = invocation.getMethod().getName() + " 메소드 호출 후, 리턴값 : " + returnValue;
		
		log.trace(s);
		System.out.println(s);
		
		return returnValue;
	}

}
