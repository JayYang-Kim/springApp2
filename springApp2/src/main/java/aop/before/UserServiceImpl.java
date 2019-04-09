package aop.before;

public class UserServiceImpl implements UserService {
	
	private String value;
	
	public UserServiceImpl() {
		value = "AOP 예제";
	}
	
	@Override
	public void save(String value) {
		System.out.println("save");
		this.value = value;
	}

	@Override
	public void write() {
		System.out.println("결과 : " + value);
	}

}
