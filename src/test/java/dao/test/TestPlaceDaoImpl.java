package dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototy.IPlaceDao;
import entity.Place;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class}) 
public class TestPlaceDaoImpl {
	@Autowired
	private IPlaceDao placeDao;
	@Test
	public void testDetele() {
		placeDao.PlaceDelete(5);
	}
	@Test
	public void testSaveOrUpdate() {
		placeDao.PlaceSaveorUpadate(new Place(6,"vv","125457","sx","as"));
	}
	@Test
	public void testListFine() {
		System.out.println(placeDao.Placelistfind(0, 2));
	}
	@Test
	public void testFind() {
		System.out.println(placeDao.find(2));
	}
	@Test
	public void testFindAll() {
		System.out.println(placeDao.findAll());
	}
}
