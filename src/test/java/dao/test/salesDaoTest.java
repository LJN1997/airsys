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

	// 1、判断营业员登录
	@Test
	public void login() {
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

	// 3、增加一张票
	@Test
	public void add() {
	//	Ticket t = new Ticket("头等舱", "成人", 1250);
	//	salesDao.add(t);
	}

	// 4、根据fid更新座位数
	@Test
	public void update1() {
		salesDao.update1(4, "business_class_remain_seats");
	}

	// 5、买票 实现飞机票中增加一条信息，航班票中减少相应座位
	@Test
	public void buy() {
		String s ="商务舱";
	//	salesDao.buy(new Ticket(s, "成人", 1000), "747", "business_class_remain_seats");
	}

	//买票 二版
	@Test
	public void buy2(){
		
		//salesDao.addAndupdate(new Ticket(1,1,1,"商务舱","成人",1000), "747", "business_class_remain_seats");
	}
	
	// 6、退票 根据用户id，航班号，座位数退票
	@Test
	public void delete() {
		salesDao.delete(2, 2, "business_class_remain_seats");
	}

	// 7、查看营业员个人信息
	@Test
	public void saleinfo() {
		List<Sales> sales = salesDao.saleinfo("111");
		System.out.println(sales);
	}

	// 8、查看历史记录
	@Test
	public void history() {
		List<Ticket> history = salesDao.history("111");
		for (Ticket ticket : history) {
			System.out.println(ticket);
		}
	}

}
