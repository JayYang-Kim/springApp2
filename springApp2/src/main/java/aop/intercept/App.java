package aop.intercept;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:aop/intercept/config.xml");
		
		try {
			// getBean : �ش�Ǵ� ��ü�� ��������
			UserService service = (UserService)context.getBean("userService");
			service.save("interceptAdvice AOP �����Դϴ�.");
			service.write();
		} finally {
			context.close();
		}

	}

}
