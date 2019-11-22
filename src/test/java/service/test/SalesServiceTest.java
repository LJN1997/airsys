package service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Info;
import entity.Order;
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
		public void login1(){
			System.out.println(ss.login1("111", "111"));
		}
		
		//1.判断营业员登录
		@Test
		public void login(){
			System.out.println(ss.login("111", "111"));
		}
		
		//2.查票
		@Test
		public void select(){
			List<Info> info = ss.select("北京", "上海", "2019-11-05");
			for (Info i : info) {
				System.out.println(i);
			}
		}
		

		//3.查看营业员个人信息
		@Test
		public void saleinfo(){
			List<Sales> sale = ss.saleinfo("111");
			System.out.println(sale);
		}
		
		//4.查看历史记录
		@Test
		public void history(){
			List<Ticket> history = ss.history("222");
			for (Ticket ticket : history) {
				System.out.println(ticket);
			}
		}
		
		//5、买票
		//5.1、先增加一张票进ticket表
		@Test
		public void test05() {
			Ticket t = new Ticket(1,1,1,"swc","child",1000,1,"147852");
			ss.addTicket(t);
		}
		//5.2、增加一条信息进order表
		@Test
		public void test06() {
			Order o = new Order(1,1,"52147852","123458","ddd");
			ss.addOrder(o);
		}
		//5.3、更新数据改座位
		@Test
		public void test07() {
			ss.updateFightSeat("747", "first_class_remain_seats");
		}

		
		//6.退票
		//6.1先根据姓名和idcard查到有没有这张票
		@Test
		public void findBy(){
			List<Ticket> f = ss.findBy("aa", "11");
			System.out.println(f);
		}
		  //6.2通过航班号和座位更新座位数（退票 该航班座位数+1）
		@Test
		public void updateSeat(){
			  ss.addFightSeat("747", "first_class_remain_seats");
		}
		//6.3、更改票的状态为0，表示退票
		@Test
		public void updateStatus(){
			ss.updateTicketStatus(5);
		}
		
	

}
