package dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototy.IAdminDao;
import dao.prototy.IAirportDao;
import entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAdminDao {
	@Autowired
	private IAdminDao adminDao;
	@Test
	public void testFind() {
		System.out.println(adminDao.find("001","123"));
	}
	@Test
	public void testUpdate() {
		adminDao.update(new Admin(1,"001","ss","111","2"));
	}
	@Test
	public void testupdatePwd() {
		adminDao.updatePwd("123", 1);
	}
	@Test
	public void testFindByAid() {
		System.out.println(adminDao.findByAid(1));
	}
}
