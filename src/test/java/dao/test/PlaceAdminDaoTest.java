package dao.test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import controller.SalesController;
import dao.prototy.PlaceAdminDao;
import entity.PlaceAdmin;
import entity.Sales;
import entity.SalesTicket;
import entity.Ticket;
import util.Pager;

/**
 * 营业点管理员dao测试类
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class PlaceAdminDaoTest {
	@Autowired
	private PlaceAdminDao pad;
	@Test
	public void testSaveOrUpdate() {
		Sales s = new Sales(); 
		
		s.setSname("李四");
		s.setSnumber("131313");
		s.setSpwd("12345");
		s.setSphone("11313131331");
		s.setPid(2);
	
		pad.saveOrUpdate(s);
	}
	@Test
	public void testDelete() { 
		pad.delete(1);
	}
	
	@Test
	public void testFind() {
		Sales s = pad.find(1);
		System.out.println(s);	
	}
	@Test 
	public void testListFind() {
		List<Sales> listfind = pad.listfind(1, 0, 5);
			for (Sales sales : listfind) {
				System.out.println(sales);
			}
	}
	@Test
	public void testFindAll() {
		List<Sales> findAll = pad.findAll(1);
			for (Sales sales : findAll) {
				System.out.println(sales);
			}
	}
	@Test
	public void testUpdateSelf() {
		PlaceAdmin pa = new PlaceAdmin();
		pa.setPaid(2);
		pa.setPaname("李佳妮1");
		pa.setPapwd("11111");
		pa.setPahead("2.png");
		pad.updateSelf(pa);
	}
	 
	@Test
	public void testFndTicketList() {
			
		List<SalesTicket> findAll = pad.findTicketList(2, 0, 5);
		for (SalesTicket sales : findAll) {
			System.out.println(sales);
		}
	}
	
	@Test
	public void testSaleTotalItems() {
		int saleTotalItems = pad.saleTotalItems(0);
		System.out.println(saleTotalItems);
	}
	
	@Test
	public void testTicketTotalItems() {
		int saleTotalItems = pad.ticketTotalItems(5);
		System.out.println(saleTotalItems);
	}
	
	@Test
	public void testFindSalesPage() {
		Pager<Sales> findSalesPage = pad.findSalesPage(1, 0, 5);
		System.out.println(findSalesPage.getData());
		System.out.println(findSalesPage.getPageNum());
	}
	
	@Test
	public void testFindTicketPage() {
		SalesTicket salesTicket = new SalesTicket(); 
		Pager<SalesTicket> findTicketPage = pad.findTicketPage(2, 0, 5);
		System.out.println(findTicketPage.getData());
		System.out.println(findTicketPage.getPageNum());
	}
	
	@Test
	public void findTicket() {
		List<SalesTicket> findTicketPage = pad.findTicket(1);
		System.out.println(findTicketPage);
	}
	
	@Test
	public void likeFind() {
		List<Sales> likeFind = pad.likeFind("1");
		for (Sales sales : likeFind) {
			System.out.println(sales);
		}
	}
	
	@Test
	public void likeTicket() {
		List<SalesTicket> likeTicket = pad.likeTicket("333");
		for (SalesTicket salesTicket : likeTicket) {
			System.out.println(salesTicket);
		}
	}
	 
	@Test
	public void testPlaceAdminLogin() {
		int placeAdminLogin = pad.placeAdminLogin("2020", "11111");
		System.out.println(placeAdminLogin);
	}

	@Test
	public void testFindPlaceAdmin() {
		PlaceAdmin findPlaceAdmin = pad.findPlaceAdmin("2020");
		System.out.println(findPlaceAdmin);
	}
	@Test
	public void testupPwd() {
		pad.updatePwd(2,"123");
	}
}
