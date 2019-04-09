package aop.xml;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

// AfterReturningAdvice : 대상 객체의 메소드 실행 후 공통 기능을 실행 할 경우(예외없이 실행되는 경우에만 실행)
public class AfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		String s = method.toString() + "메소드 실행 후, 리턴 값 : " + returnValue;
		
		System.out.println(s);
	}

}
