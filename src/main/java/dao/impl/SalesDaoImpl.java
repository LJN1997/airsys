package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.ISalesDao;
import entity.Flight;
import entity.Info;
import entity.Order;
import entity.Place;
import entity.Plan;
import entity.Sales;
import entity.Ticket;
import entity.aa;

/**
 * 
 * 营业员接口实现类
 * 
 * @author DanyangLi
 */
@Repository("salesDaoImpl")
public class SalesDaoImpl implements ISalesDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 1、营业员登录，以对象的方式存储，在airsys/main/index那判断营业员登录时会用到
	@Override
	public Sales login1(String num, String pwd) {
		String sql = "SELECT  *  from airsys_sales WHERE snumber=? and spwd=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { num, pwd }, new BeanPropertyRowMapper<>(Sales.class));
	}

	/*
	 * 2、根据营业员的工号和密码查找营业员的sid，在airsys/main/index中判断营业员登录时将其写入session中
	 * 这样可以在买票那在ticket表中插入sid时用到 然后可以根据这个营业员的工号，sid连表查询查到这个营业员卖的所有票务记录
	 */
	@Override
	public int findSid(String num, String pwd) {
		String sql = "SELECT sid FROM airsys_sales WHERE snumber=? AND spwd=?";
		int sid = jdbcTemplate.queryForObject(sql, new Object[] { num, pwd }, Integer.class);
		return sid;
	}

	// 3、根据营业员的工号，可以查看到这个营业员卖过得票务信息
	@Override
	public List<Ticket> history(String num) {

		String sql = "SELECT * FROM airsys_ticket t JOIN airsys_sales s ON t.sid=s.sid WHERE s.snumber=?";
		return jdbcTemplate.query(sql, new Object[] { num }, new BeanPropertyRowMapper<Ticket>(Ticket.class));
	}

	// 4、查票 根据用户输入的出发地、目的地、时间 查询出符合条件的机票
	@Override
	public List<Info> find(String startplace, String destination, String startTime) {
		String sql = "SELECT *  FROM airsys_flight f RIGHT JOIN airsys_plan p ON f.fnumber=p.fnumber WHERE from_city = ? AND to_city= ? AND start_date= ? ";
		return jdbcTemplate.query(sql, new Object[] { startplace, destination, startTime },
				new BeanPropertyRowMapper<Info>(Info.class));
	}

	// 5、买票 需要三个方法
	
	// 5.1、根据航班号和座位更新相应的座位-1
	@Override
	public void updateFightSeat(String fnumber, String seat) {
		if (seat.equals("first_class_remain_seats")) {
			String sql = "update airsys_flight set first_class_remain_seats=first_class_remain_seats-1 where fnumber = ?";
			jdbcTemplate.update(sql, new Object[] { fnumber });
		}
		if (seat.equals("business_class_remain_seats")) {
			String sql = "update airsys_flight set business_class_remain_seats=business_class_remain_seats-1 where fnumber = ?";
			jdbcTemplate.update(sql, new Object[] { fnumber });
		}
		if (seat.equals("economy_class_remain_seats")) {
			String sql = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats-1 where fnumber = ?";
			jdbcTemplate.update(sql, new Object[] { fnumber });
		}

	}

	// 5.2、票表里多一条机票记录
	@Override
	public void addTicket(Ticket t) {
		String sql = "INSERT INTO airsys_ticket(plan_id,uid,sid,tclass,passenger_type,tprice,status,idcard) VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { t.getPlanId(), t.getUid(), t.getSid(), t.getTclass(),
				t.getPassengerType(), t.getTprice(), t.getStatus(), t.getIdcard() });
	}

	// 5.3、订单表里多一条用户记录
	@Override
	public void addOrder(Order o) {
		String sql = "INSERT INTO airsys_order(sid,uid,idcard,ophone,oname) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { o.getSid(), o.getUid(), o.getIdcard(), o.getOphone(), o.getOname() });
	}

	//5.4、先根据用户的身份证判断下order表里有没有这个用户，如果有的话，就不用再往order表里增加一条信息了
		@Override
		public int findIdcard(String idcard) {
			String sql = "select count(*) FROM airsys_order WHERE idcard=?";
			int number = jdbcTemplate.queryForObject(sql, new Object[] { idcard }, Integer.class);
			return number;
		}

	
	// 6、退票
	// 6.1、通过姓名和身份证先查出用户这张票
	@Override
	public List<Ticket> findBy(String name, String idcard) {
		String sql = "SELECT * FROM airsys_ticket t JOIN airsys_order o ON t.idcard=o.idcard JOIN airsys_plan p ON p.plan_id = t.plan_id WHERE o.oname = ?  AND o.idcard=? AND	t.`status` = 1 or t.`status` = 2";
		return jdbcTemplate.query(sql, new Object[] { name, idcard }, new BeanPropertyRowMapper<Ticket>(Ticket.class));
	}

	// 6.2、通过航班号和座位更新座位数（退票 该航班座位数+1）
	@Override
	public void addFightSeat(String fnumber, String seat) {
		if (seat.equals("first_class_remain_seats")) {
			String sql = "update airsys_flight set first_class_remain_seats=first_class_remain_seats+1 where fnumber = ?";
			jdbcTemplate.update(sql, new Object[] { fnumber });
		}
		if (seat.equals("business_class_remain_seats")) {
			String sql = "update airsys_flight set business_class_remain_seats=business_class_remain_seats+1 where fnumber = ?";
			jdbcTemplate.update(sql, new Object[] { fnumber });
		}
		if (seat.equals("economy_class_remain_seats")) {
			String sql = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats+1 where fnumber = ?";
			jdbcTemplate.update(sql, new Object[] { fnumber });
		}

	}

	// 6.3、更新票的状态为0，表示退票
	@Override
	public void updateTicketStatus(int tid) {
		String sql = "UPDATE airsys_ticket SET `status` = 0 WHERE tid=?";
		jdbcTemplate.update(sql, new Object[] { tid });

	}

	// 7、改签
	
	//改签查询
	@Override
	public List<Ticket> findByUser(String name, String idcard) {
		String sql = "SELECT * FROM airsys_ticket t JOIN airsys_order o ON t.idcard=o.idcard JOIN airsys_plan p ON p.plan_id = t.plan_id WHERE o.oname = ?  AND o.idcard=? AND	t.`status` = 1 ";
		return jdbcTemplate.query(sql, new Object[] { name, idcard }, new BeanPropertyRowMapper<Ticket>(Ticket.class));
	}
	
	// 7.1、更新票的状态为2，表示改签
	@Override
	public void changeTicketStatus(int tid) {
		String sql = "UPDATE airsys_ticket SET `status` = 2 WHERE tid=? ";
		jdbcTemplate.update(sql, new Object[] { tid });
	}
	// 7.2、相应的座位+1，直接用上面退票addFightSeat方法即可

	// 8、根据工号查看营业员个人信息
	@Override
	public List<Sales> saleinfo(String num) {
		String sql = "select * from airsys_sales s join airsys_place p on s.pid=p.pid where s.snumber=?";

		return jdbcTemplate.query(sql, new Object[] { num }, new BeanPropertyRowMapper<Sales>(Sales.class));
	}

	// 这个是我自己写的营业员登录，判断营业员登录，本项目没用到这个接口方法
	@Override
	public int login(String num, String pwd) {
		String sql = "SELECT  count(*)  from airsys_sales WHERE snumber=? and spwd=?";
		int number = jdbcTemplate.queryForObject(sql, new Object[] { num, pwd }, Integer.class);
		return number;
	}

	@Override
	public List<Info> findStatus(String name) {
		String sql = "select status FROM airsys_ticket WHERE idcard in (SELECT idcard FROM airsys_order WHERE oname=?)";
		
	return jdbcTemplate.query(sql, new Object[] { name }, new BeanPropertyRowMapper<Info>(Info.class));
	}



}
