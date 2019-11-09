package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import entity.User;
import service.prototy.IUserService;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestUserServiceImpl {
	@Autowired
	private IUserService userService;
	
	@Test
	public void testListFind() {
		Pager<User> pager = (Pager<User>) userService.Userlistfind(1, 2);
		for (User user : pager.getData()) {
			System.out.println(user);
		}
	}
	@Test
	public void testFind() {
		System.out.println(userService.find(1));
	}
	
}
