package service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import entity.Airport;
import entity.Place;
import service.prototy.IPlaceService;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestPlaceServiceImpl {
	
	@Autowired
	private IPlaceService placeService;
	
	@Test
	public void testDelete() {
		placeService.Detele(6);
	}
	@Test
	public void testSaveOrUpdate() {
		placeService.SaveOrUpdate(new Place(7,"lk","1216516","ll","nc"));
	}
	@Test
	public void testListfind() {
		Pager<Place> pager = (Pager<Place>) placeService.listPlace(1, 1);
		for (Place place : pager.getData()) {
			System.out.println(place);
		}
	}
	@Test
	public void testFind() {
		System.out.println(placeService.find(1));
	}
}
