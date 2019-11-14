package dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototy.IPlanDao;
import entity.Plan;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class}) 
public class TestPlan {
	@Autowired
	private IPlanDao planDao;
	@Test
	public void testSelect() {
		System.out.println(planDao.findFight());
	}
	@Test
	public void testfindid() {
		System.out.println(planDao.findforNumber("747"));
	}
	@Test
	public void testUpdate() {
		//planDao.UpdateOrSave(new Plan("747","2019-07-10","2019-08-10","南京","上海","MH",3000));
	}
	@Test
	public void testdelete() {
		planDao.delete(2);
	}
}
