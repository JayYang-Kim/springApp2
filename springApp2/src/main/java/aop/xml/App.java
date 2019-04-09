package aop.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:aop/xml/config.xml");
		
		try {
			// getBean : 해당되는 객체를 가져오기
			UserService service = (UserService)context.getBean("userService");
			service.save("AOP 예제입니다.");
			service.write();
		} finally {
			context.close();
		}

	}

}
