package dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import dao.prototy.IAirportDao;
import entity.Airport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAirportDaoImpl {
	@Autowired
	private IAirportDao air;
	
	@Test
	public void testDelete() {
		air.AportDelete("OKN");
		
	}
	@Test
	public void testSaveOrUpdate() {
		air.AportSaveorUpadate(new Airport("SAD","okok", "OK"));
	}
	@Test
	public void testListFind() {
		System.out.println(air.Airlistfind(1, 2));
	}
	@Test
	public void testTotalItems() {
		System.out.println(air.totalItems());
	}
	@Test
	public void testFindid() {
		System.out.println(air.find("XXX"));
	}
	@Test
	public void testFindAll() {
		System.out.println(air.findall());
	}
}
