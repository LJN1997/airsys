package service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.PlaceAdmin;
import entity.Sales;
import entity.Ticket;
import service.prototy.PlaceAdminService;
import util.Pager;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class PlaceAdminServiceTest {
	@Autowired
	private PlaceAdminService pas;
	
	@Test
	public void testSaveOrUpdate() {
		Sales s = new Sales();
	
		s.setSname("赵四");
		s.setSnumber("333333");
		s.setSpwd("12345");
		s.setPid(2);
		
		pas.saveOrUpdate(s);;
	}
	
	@Test
	public void testquerry() {
		Sales sales = pas.querry(1);
		System.out.println(sales); 
	}
	
	@Test
	public void testSlistPaged() {
		List<Sales> slistPaged = pas.SlistPaged(2,0, 5);
		for (Sales sales : slistPaged) {
			System.out.println(sales); 
		}
	}
	
	@Test
	public void testSlistPager() {
		Pager<Sales> slistPager = pas.SlistPager(2, 1, 5);
		System.out.println(slistPager.getData());
		System.out.println(slistPager.getPageNum());
	} 
	
	@Test
	public void testTlistPaged() {
		List<Ticket> slistPaged = pas.TlistPaged(1, 1, 5);
		for (Ticket sales : slistPaged) {
			System.out.println(sales); 
		}
	}
	
	@Test
	public void testTlistPager() {
		Pager<Ticket> slistPager = pas.TlistPager(2, 1, 5);
		System.out.println(slistPager.getData());
		System.out.println(slistPager.getPageNum());
	} 
	
	@Test
	public void testDelete() {
		pas.delete(1);
	}
	
	@Test
	public void testUpdateSelf() {
		PlaceAdmin placeAdmin = new PlaceAdmin();
		placeAdmin.setPaid(2);
		placeAdmin.setPahead("3.png");
		placeAdmin.setPaname("lijiani");
		placeAdmin.setPanumber("33333");
		placeAdmin.setPapwd("123123");
		placeAdmin.setPid(2);
		pas.updateSelf(placeAdmin);
	}
}
