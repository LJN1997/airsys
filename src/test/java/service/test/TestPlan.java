package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import service.prototy.IPlanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class}) 
public class TestPlan {
	@Autowired
	private IPlanService planService;
	
	@Test
	public void testfindFight() {
		System.out.println(planService.findFplan());
	}
	@Test
	public void testfindFnumber(){
		System.out.println(planService.findByNumber("747"));
	}
	@Test
	public void testdelete() {
		planService.delete("747");
	}
	@Test
	public void testUpdateSave() {
		//planService.UpdateOrSave(new fplan());
	}
}
