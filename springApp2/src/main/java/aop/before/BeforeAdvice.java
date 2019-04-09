package aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// MethodBeforeAdvice : 대상 객체의 메소드 실행 전에 공통 기능을 실행할때 사용하는 Advice
public class BeforeAdvice implements MethodBeforeAdvice {
	
	// before(Object[] args) : 메소드의 파라미터 인자값
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String s = method.toString() + " 메소드 : " + target + " 에서 호출 전";
		
		if(args != null && args.length > 0) {
			s += "\n 매개변수 : ";
			
			for(int i = 0; i < args.length; i++) {
				s += args[i] + " ";
			}
		}
		
		System.out.println(s);
	}

}
