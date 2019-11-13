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
	
		//1.判断营业员登录
		@Test
		public void login(){
			ss.login("111", "111");
		}
		
		//2.查票
		@Test
		public void select(){
			List<Info> info = ss.select("北京", "上海", "2019-11-05");
			for (Info i : info) {
				System.out.println(i);
			}
		}
		
		//3.买票  增加更新
		@Test
		public void buy(){
			String s = "sdfdsf";
			ss.buy(new Ticket(s,"aaaaaaadsf",1200),"747", "business_class_remain_seats");
		}
		//买票第二版
		@Test
		public void buy2(){
			ss.addAndupdate(new Ticket(1,1,1,"商务舱","成人",1000), "747", "business_class_remain_seats");
		}
		
		//4.退票  删除更新
		@Test
		public void quit(){
			ss.quit(1, 1, "business_class_remain_seats");
		}
		
		//5.查看营业员个人信息
		@Test
		public void saleinfo(){
			List<Sales> sale = ss.saleinfo("111");
			System.out.println(sale);
		}
		
		//6.查看历史记录
		@Test
		public void history(){
			List<Ticket> history = ss.history("222");
			for (Ticket ticket : history) {
				System.out.println(ticket);
			}
		}

}
