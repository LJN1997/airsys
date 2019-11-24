package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.ISalesDao;
import entity.Info;
import entity.Order;
import entity.Sales;
import entity.Ticket;
import entity.aa;
import service.prototy.ISalesService;

/**
 * 
 * 营业员实现service层接口
 * 
 * @author DanyangLi
 */
@Service("salesServiceImpl")
public class SalesServiceImpl implements ISalesService {

	@Autowired
	private ISalesDao sd;

	// 1、营业员登录，以对象的方式存储，在airsys/main/index那判断营业员登录时会用到
	@Override
	public Sales login1(String num, String pwd) {
		return sd.login1(num, pwd);
	}

	/*
	 * 2、根据营业员的工号和密码查找营业员的sid，在airsys/main/index中判断营业员登录时将其写入session中
	 * 这样可以在买票那在ticket表中插入sid时用到 然后可以根据这个营业员的工号，sid连表查询查到这个营业员卖的所有票务记录
	 */
	@Override
	public int findSid(String num, String pwd) {
		return sd.findSid(num, pwd);
	}

	// 3、根据营业员的工号，可以查看到这个营业员卖过得票务信息
	@Override
	public List<Ticket> history(String num) {
		return sd.history(num);
	}

	// 4、查票 根据用户输入的出发地、目的地、时间 查询出符合条件的机票
	@Override
	public List<Info> find(String startplace, String destination, String startTime) {
		return sd.find(startplace, destination, startTime);
	}

	// 5、买票 需要三个方法
	// 5.1、根据航班号和座位更新相应的座位-1
	@Override
	public void updateFightSeat(String fnumber, String seat) {
		sd.updateFightSeat(fnumber, seat);
	}

	// 5.2、票表里多一条机票记录
	@Override
	public void addTicket(Ticket t) {
		sd.addTicket(t);
	}

	// 5.3、订单表里多一条用户记录
	@Override
	public void addOrder(Order o) {
		sd.addOrder(o);
	}

	//5.4、先根据用户的身份证判断下order表里有没有这个用户，如果有的话，就不用再往order表里增加一条信息了
	@Override
	public int findIdcard(String idcard) {
		return sd.findIdcard(idcard);
	}
	
	// 6、退票
	// 6.1、通过姓名和身份证先查出用户这张票
	@Override
	public List<Ticket> findBy(String name, String idcard) {
		return sd.findBy(name, idcard);
	}

	// 6.2、通过航班号和座位更新座位数（退票 该航班座位数+1）
	@Override
	public void addFightSeat(String fnumber, String seat) {
		sd.addFightSeat(fnumber, seat);
	}

	// 6.3、更新票的状态为0，表示退票
	@Override
	public void updateTicketStatus(int tid) {
		sd.updateTicketStatus(tid);
	}

	// 7、改签
	// 7.1、更改票的状态为2，表示改签
	@Override
	public void changeTicketStatus(int tid) {
		sd.changeTicketStatus(tid);
	}
	// 7.2、相应的座位+1，直接用上面退票addFightSeat方法即可

	// 8、根据工号查看营业员个人信息
	@Override
	public List<Sales> saleinfo(String snumber) {
		return sd.saleinfo(snumber);
	}

	// 这个是我自己写的营业员登录，判断营业员登录，本项目没用到这个接口方法
	@Override
	public int login(String num, String pwd) {
		int number = sd.login(num, pwd);
		return number;
	}


}
