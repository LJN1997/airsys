package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Flight;
import service.prototy.IFlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestFlight {
	@Autowired
	private IFlightService flightService;
	
	@Test
	public void testFindAll() {
		System.out.println(flightService.findAll());
	}
	@Test
	public void testDelete() {
		flightService.delete("747");
	}
	@Test
	public void testSaveOrUodate() {
		flightService.SaveOrUpdate(new Flight("748",10,20,20,20));
	}
	

}
