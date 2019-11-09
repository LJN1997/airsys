package dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototy.IUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestUserDaoImpl {
	@Autowired
	private IUserDao userDao;
	@Test
	public void testListFind() {
		System.out.println(userDao.Userlistfind(0,5));
	}
	@Test
	public void testFind() {
		System.out.println(userDao.find(1));
	}

}
