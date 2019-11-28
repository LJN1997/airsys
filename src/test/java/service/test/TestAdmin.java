package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import service.prototy.IAdminService;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAdmin {
	@Autowired
	private IAdminService adminService;
	
	@Test
	public void testFind() {
		System.out.println(adminService.find("001","123"));
	}
	@Test
	public void testlistFind() {
		System.out.println(adminService.find("001"));
	}
	@Test
	public void testupdatePwd() {
		adminService.updatePwd("111", 1);
	}
	@Test
	public void test() {
		System.out.println(adminService.findByAid(1));
	}
}
