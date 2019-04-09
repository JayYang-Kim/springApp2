package aop.anno;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:aop/anno/config.xml");
		
		try {
			// getBean : �ش�Ǵ� ��ü�� ��������
			UserService service = (UserService)context.getBean("userService");
			service.save("AOP �����Դϴ�...");
			service.write();
		} finally {
			context.close();
		}

	}

}
