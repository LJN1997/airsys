package dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototy.IFlightDao;
import entity.Flight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class}) 
public class TestFlight {
	@Autowired
	private IFlightDao flightDao;
	
	@Test
	public void find() {
		List<Flight> findAll = flightDao.findAll();
		for (Flight flight : findAll) {
			System.out.println(flight);
		}
	}
	@Test
	public void delete() {
		flightDao.delete("747");
	}
	@Test
	public void findByid() {
		List<Flight> findByid = flightDao.findByid("748");
		System.out.println(findByid);
	}
	
	@Test
	public void saveOrUpdate() {
		flightDao.SaveOrUpdate(new Flight("747",10,10,30,40));
	}
}
