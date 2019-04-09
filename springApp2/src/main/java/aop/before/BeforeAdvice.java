package aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// MethodBeforeAdvice : ��� ��ü�� �޼ҵ� ���� ���� ���� ����� �����Ҷ� ����ϴ� Advice
public class BeforeAdvice implements MethodBeforeAdvice {
	
	// before(Object[] args) : �޼ҵ��� �Ķ���� ���ڰ�
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String s = method.toString() + " �޼ҵ� : " + target + " ���� ȣ�� ��";
		
		if(args != null && args.length > 0) {
			s += "\n �Ű����� : ";
			
			for(int i = 0; i < args.length; i++) {
				s += args[i] + " ";
			}
		}
		
		System.out.println(s);
	}

}
