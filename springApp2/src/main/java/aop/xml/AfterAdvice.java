package aop.xml;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

// AfterReturningAdvice : ��� ��ü�� �޼ҵ� ���� �� ���� ����� ���� �� ���(���ܾ��� ����Ǵ� ��쿡�� ����)
public class AfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		String s = method.toString() + "�޼ҵ� ���� ��, ���� �� : " + returnValue;
		
		System.out.println(s);
	}

}
