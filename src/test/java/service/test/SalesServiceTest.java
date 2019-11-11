package service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Info;
import entity.Sales;
import entity.Ticket;
import service.prototy.ISalesService;

/**
* 
*  service层测试
* @author DanyangLi
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class SalesServiceTest {
		@Autowired
		private ISalesService ss;
	
		@Test
		public void login(){
			ss.login("111", "111");
		}
		
		
		@Test
		public void saleinfo(){
			List<Sales> sale = ss.saleinfo(1);
			System.out.println(sale);
		}
		@Test
		public void select(){
			List<Info> info = ss.select("xa", "sx", "2019-11-05");
			for (Info i : info) {
				System.out.println(i);
			}
		}
		
		@Test
		public void buy(){
			ss.buy(new Ticket("头等舱","儿童",1200),"747", "business_class_remain_seats");
		}
		
		@Test
		public void quit(){
			ss.quit(1, 1, "business_class_remain_seats");
		}
		
		
		
}
