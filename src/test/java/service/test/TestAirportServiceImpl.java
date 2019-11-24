package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import entity.Airport;
import service.prototy.IAirportService;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAirportServiceImpl {
	@Autowired
	private IAirportService airService;
	@Test
	public void testListFind() {
		Pager<Airport> pager = (Pager<Airport>) airService.listAirport(1, 1);
		for (Airport air : pager.getData()) {
			System.out.println(air);
		}
		System.out.println(pager.getPageNum());
	}
	@Test
	public void testDetele() {
		airService.AirDelete("AUE");
	
	}
	@Test
	public void testSaveOrUpdate() {
		airService.AirSaveorUpdate(new Airport("XXX", "zs", "bj"));
	}
	@Test
	public void testTotalItems() {
		System.out.println(airService.totalItems());
	}
	@Test
	public void testFindnumber() {
		System.out.println(airService.find("XXX"));
	}
	@Test
	public void testFindAll() {
		System.out.println(airService.findAll());
	}
	@Test
	public void testlikefind() {
		System.out.println(airService.likefind("s"));
	}
}
