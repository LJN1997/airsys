package dao.prototy;

import java.util.List;

import entity.Info;
import entity.Order;
import entity.Place;
import entity.Plan;
import entity.Sales;
import entity.Ticket;
import entity.aa;

/**
 * 
 * 营业员接口
 * 
 * @author DanyangLi
 */
public interface ISalesDao {

	// 1、营业员登录，以对象的方式存储，在airsys/main/index那判断营业员登录时会用到
	Sales login1(String num, String pwd);

	/*
	 * 2、根据营业员的工号和密码查找营业员的sid，在airsys/main/index中判断营业员登录时将其写入session中
	 * 这样可以在买票那在ticket表中插入sid时用到 然后可以根据这个营业员的工号，sid连表查询查到这个营业员卖的所有票务记录
	 */
	int findSid(String num, String pwd);

	// 3、根据营业员的工号，可以查看到这个营业员卖过得票务信息
	List<Ticket> history(String num);

	// 4、查票 根据用户输入的出发地、目的地、时间 查询出符合条件的机票
	List<Info> find(String startplace, String destination, String startTime);

	// 5、买票 需要三个方法

	// 5.1、根据航班号和座位更新相应的座位-1
	void updateFightSeat(String fnumber, String seat);

	// 5.2、票表里多一条机票记录
	void addTicket(Ticket t);

	// 5.3、订单表里多一条用户记录
	void addOrder(Order o);

	//5.4、先根据用户的身份证判断下order表里有没有这个用户，如果有的话，就不用再往order表里增加一条信息了
	//由于idcard是唯一的，如果这个用户下次再用自己的身份证买票的时候，order表就插不进这个用户的信息了，因为idcard的表结构是唯一不能重复的
	int findIdcard(String idcard);
	
	// 6、退票
	// 6.1、通过姓名和身份证先查出用户这张票
	List<Ticket> findBy(String name, String idcard);
	List<Info> findStatus(String name);
	// 6.2、通过航班号和座位更新座位数（退票 该航班座位数+1）
	void addFightSeat(String fnumber, String seat);

	// 6.3、更新票的状态为0，表示退票
	void updateTicketStatus(int tid);

	// 7、改签
	List<Ticket> findByUser(String name, String idcard);
	// 7.1、更新票的状态为2，表示改签
	void changeTicketStatus(int tid);
	// 7.2、相应的座位+1，直接用上面退票addFightSeat方法即可

	// 8、根据工号查看营业员个人信息
	List<Sales> saleinfo(String num);
	
	// 这个是我自己写的营业员登录，判断营业员登录，本项目没用到这个接口方法
	int login(String num, String pwd);

}
