package dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototy.ISelectAllDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class}) 
public class TestSelect {
	@Autowired
	private ISelectAllDao selectDao;
	@Test
	public void testSelect() {
		System.out.println(selectDao.findFight());
	}
	@Test
	public void testfindid() {
		System.out.println(selectDao.findforNumber(747));
	}
}
