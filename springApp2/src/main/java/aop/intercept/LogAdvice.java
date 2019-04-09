package aop.intercept;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// MethodInterceptor : �޼ҵ� ���� ��, �� �Ǵ� ���ܹ߻� �� ���� ������ ������ �� �ִ�.
public class LogAdvice implements MethodInterceptor {
	private Log log = LogFactory.getLog(LogAdvice.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// ��� ��ü �޼ҵ� ȣ�� ��
		String s;
		s = invocation.getMethod().getName() + " �޼ҵ� ȣ�� ��";
		
		log.trace(s);
		System.out.println(s);
		
		// ��� ��ü �޼ҵ� ȣ��
		Object returnValue = invocation.proceed();
		
		// ��� ��ü �޼ҵ� ȣ�� ��
		s = invocation.getMethod().getName() + " �޼ҵ� ȣ�� ��, ���ϰ� : " + returnValue;
		
		log.trace(s);
		System.out.println(s);
		
		return returnValue;
	}

}
