package dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototy.IPlanDao;
import entity.Fplan;
import entity.Plan;
import entity.PlanNew;

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
		PlanNew p = new PlanNew();
		p.setFnumber("746");
		p.setStartDate("2019-11-06");
		p.setEndDate("2019-11-06");
		p.setFromCity("南京");
		p.setToCity("上海");
		p.setTprice(5000);
		p.setType("MH");
		p.setPlanId(2);
		planDao.UpdateOrSave(p);
		//planDao.UpdateOrSave(new PlanNew(1,"747","北京","上海","2019-10-12","20119-11-12","MH",3000));
	}
	@Test
	public void testdelete() {
		planDao.delete("745");
	}
	
	
	
}
