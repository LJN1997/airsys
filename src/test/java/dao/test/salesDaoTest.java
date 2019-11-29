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
import entity.aa;

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

	// 1、营业员登录，以对象的方式存储，在airsys/main/index那判断营业员登录时会用到
	@Test
	public void login1() {
		Sales s = salesDao.login1("111", "111");
		System.out.println(s);
	}

	/*
	 * 2、根据营业员的工号和密码查找营业员的sid，在airsys/main/index中判断营业员登录时将其写入session中
	 * 这样可以在买票那在ticket表中插入sid时用到 然后可以根据这个营业员的工号，sid连表查询查到这个营业员卖的所有票务记录
	 */
	@Test
	public void findSid() {
		int findSid = salesDao.findSid("111", "111");
		System.out.println(findSid);
	}

	// 3、根据营业员的工号，可以查看到这个营业员卖过得票务信息
	@Test
	public void history() {
		List<Ticket> history = salesDao.history("111");
		for (Ticket ticket : history) {
			System.out.println(ticket);
		}
	}

	// 4、查票 根据用户输入的出发地、目的地、时间 查询出符合条件的机票
	@Test
	public void find() {
		List<Info> plan = salesDao.find("北京", "上海", "2019-11-05");
		for (Info o : plan) {
			System.out.println(o);
		}
	}

	// 5、买票 需要三个方法
	
	// 5.1、根据航班号和座位更新相应的座位-1
	@Test
	public void updateFightSeat() {
		salesDao.updateFightSeat("747", "first_class_remain_seats");
	}

	// 5.2、票表里多一条机票记录
	@Test
	public void addTicket() {
		Ticket t = new Ticket(1, 1, 1, "jjc", "child", 1000, 1, "152488");
		salesDao.addTicket(t);
	}

	// 5.3、订单表里多一条用户记录
	@Test
	public void addOrder() {
		Order o = new Order(1, 1, "14270119970625", "17335081644", "huu");
		salesDao.addOrder(o);
	}

	//5.4、先根据用户的身份证判断下order表里有没有这个用户，如果有的话，就不用再往order表里增加一条信息了
		@Test
		public void findIdcard() {
			int findIdcard = salesDao.findIdcard("111");
			System.out.println(findIdcard);
		}
		
	// 6、退票
	// 6.1、通过姓名和身份证先查出用户这张票
	@Test
	public void findBy() {
		List<Ticket> f = salesDao.findBy("ss", "22");
		System.out.println(f);
	}

	// 6.2、通过航班号和座位更新座位数（退票 该航班座位数+1）
	@Test
	public void addFightSeat() {
		salesDao.addFightSeat("747", "first_class_remain_seats");
	}

	// 6.3更新票表的状态为0 表示退票
	@Test
	public void updateTicketStatus() {
		salesDao.updateTicketStatus(2);
	}

	// 7、改签
	// 7.1、更新票的状态为2，表示改签
	@Test
	public void changeStatus() {
		salesDao.changeTicketStatus(2);
	}
	// 7.2、相应的座位+1，直接用上面退票addFightSeat方法即可

	// 8、根据工号查看营业员个人信息
	@Test
	public void saleinfo() {
		List<Sales> sales = salesDao.saleinfo("111");
		System.out.println(sales);
	}

	// 这个是我自己写的营业员登录，判断营业员登录，本项目没用到这个接口方法
	@Test
	public void login() {
		salesDao.login("111", "111");
	}

	@Test
	public void findStatus(){
		List<Info> f = salesDao.findStatus("aa");
		for (Info ff : f) {
			System.out.println(ff);
		}
	}
}
