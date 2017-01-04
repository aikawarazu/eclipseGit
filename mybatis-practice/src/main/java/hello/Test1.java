package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sf.dao.UserMapper;
import com.sf.model.User;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ac = new  ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User user = new User();
		userMapper.insert(user);
	}
}
