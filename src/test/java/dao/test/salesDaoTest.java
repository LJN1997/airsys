package dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import dao.prototy.ISalesDao;
import entity.Flight;
import entity.Info;
import entity.Order;
import entity.Plan;
import entity.Sales;
import entity.Ticket;

/**
 * 
 * Dao层测试
 * 
 * @author DanyangLi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class salesDaoTest {

	@Autowired
	private ISalesDao salesDao;

	
	//退票
	@Test
	public void findBy(){
		List<Ticket> f = salesDao.findBy("ss","22");
		System.out.println(f);
	}
	
	
	
	
	// 1、判断营业员登录
	@Test
	public void test01() {
		salesDao.login("111", "111");
	}

	// 2、查票 根据用户输入的出发地、目的地、时间 查询出符合条件的机票
	@Test
	public void test02() {
		List<Info> plan = salesDao.find("北京", "上海", "2019-11-05");
		for (Info o : plan) {
			System.out.println(o);
		}
	}
	// 3、查看营业员个人信息
	@Test
	public void test03() {
		List<Sales> sales = salesDao.saleinfo("111");
		System.out.println(sales);
	}

	// 4、查看历史记录
	@Test
	public void test04() {
		List<Ticket> history = salesDao.history("111");
		for (Ticket ticket : history) {
			System.out.println(ticket);
		}
	}

	//5、买票
			//5.1、先增加一张票进ticket表
			@Test
			public void test05() {
				Ticket t = new Ticket(1,1,1,"jjc","child",1000,1,"152488");
				salesDao.addTicket(t);
			}
			//5.2、增加一条信息进order表
			@Test
			public void test06() {
				Order o = new Order(1,1,"14270119970625","17335081644","huu");
				salesDao.addOrder(o);
			}
			//5.3、更新数据改座位
			@Test
			public void test07() {
				salesDao.updateFightSeat("747", "first_class_remain_seats");
			}


}
