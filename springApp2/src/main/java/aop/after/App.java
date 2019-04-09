package aop.after;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:aop/after/config.xml");
		
		try {
			// getBean : �ش�Ǵ� ��ü�� ��������
			UserService service = (UserService)context.getBean("userService");
			service.save("AfterReturningAdvice AOP �����Դϴ�.");
			service.write();
		} finally {
			context.close();
		}

	}

}
