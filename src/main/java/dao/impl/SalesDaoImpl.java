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
import entity.Plan;
import entity.Sales;
import entity.Ticket;

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

	// 1、判断营业员登录
	@Override
	public int login(String num, String pwd) {
		String sql = "SELECT  count(*)  from airsys_sales WHERE snumber=? and spwd=?";
		int number =jdbcTemplate.queryForObject(sql, new Object[] { num, pwd },Integer.class);
		return number;
	}
	
	//查出营业员的sid
	@Override
	public int findSid(String num, String pwd) {
		String sql = "SELECT sid FROM airsys_sales WHERE snumber=? AND spwd=?";
		int sid =jdbcTemplate.queryForObject(sql, new Object[] { num, pwd },Integer.class);
		return sid;
	}
	

	// 2、查票 根据用户输入的出发地、目的地、时间 查询出符合条件的机票
	@Override
	public List<Info> find(String startplace, String destination, String startTime) {
		String sql = "SELECT *  FROM airsys_flight f RIGHT JOIN airsys_plan p ON f.fnumber=p.fnumber WHERE from_city = ? AND to_city= ? AND start_date= ? ";
		return jdbcTemplate.query(sql, new Object[] { startplace, destination, startTime },new BeanPropertyRowMapper<Info>(Info.class));
	}
	
	// 3、查看营业员个人信息
		@Override
		public List<Sales> saleinfo(String num) {
			String sql = "select * from airsys_sales s join airsys_place p on s.pid=p.pid where s.snumber=?";

			return jdbcTemplate.query(sql, new Object[] { num }, new BeanPropertyRowMapper<Sales>(Sales.class));
		}

		// 4、查看历史记录
		@Override
		public List<Ticket> history(String num) {

			String sql = "SELECT s.snumber,t.tdate,t.tprice,t.passenger_type FROM airsys_ticket t JOIN airsys_sales s ON t.sid=s.sid WHERE s.snumber=?";
			return jdbcTemplate.query(sql, new Object[] { num }, new BeanPropertyRowMapper<Ticket>(Ticket.class));
		}
	
      //5、买票
		//5.1、更新航班表的座位
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

		//5.2、同时增加一条信息进票表
		@Override
		public void addTicket(Ticket t) {
			String sql = "INSERT INTO airsys_ticket(plan_id,uid,sid,tclass,passenger_type,tprice,status,idcard) VALUES(?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, new Object[]{t.getPlanId(),t.getUid(),t.getSid(),t.getTclass(),t.getPassengerType(),t.getTprice(),t.getStatus(),t.getIdcard()});
		}

		//5.3、同时增加一条信息进订单表
		@Override
		public void addOrder(Order o) {
			String sql = "INSERT INTO airsys_order(sid,uid,idcard,ophone,oname) VALUES(?,?,?,?,?)";
			jdbcTemplate.update(sql, new Object[]{o.getSid(),o.getUid(),o.getIdcard(),o.getOphone(),o.getOname()});
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	// 3、增加一张票
	@Override
	public void add(Ticket t) {
		String sql = "INSERT INTO airsys_ticket(tclass,passenger_type,tprice) VALUES(?,?,?)";
		jdbcTemplate.update(sql, new Object[] { t.getTclass(), t.getPassengerType(), t.getTprice() });
	}

	// 4、根据fid更新座位数
	@Override
	public void update1(int fid, String seat) {
		if (seat.equals("first_class_remain_seats")) {
			String sql = "update airsys_flight set first_class_remain_seats=first_class_remain_seats-1 where fid = ?";
			jdbcTemplate.update(sql, new Object[] { fid });
		}
		if (seat.equals("business_class_remain_seats")) {
			String sql = "update airsys_flight set business_class_remain_seats=business_class_remain_seats-1 where fid = ?";
			jdbcTemplate.update(sql, new Object[] { fid });
		}
		if (seat.equals("economy_class_remain_seats")) {
			String sql = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats-1 where fid = ?";
			jdbcTemplate.update(sql, new Object[] { fid });
		}
	}
	 //5、买票         实现飞机票中增加一条信息，航班票中减少相应座位
	@Override
	public void buy(Ticket t, String fnumber, String seat) {

		if (seat.equals("first_class_remain_seats")) {
			String sql = "INSERT INTO airsys_ticket(tclass,passenger_type,tprice) VALUES(?,?,?)";
			jdbcTemplate.update(sql, new Object[] { t.getTclass(), t.getPassengerType(), t.getTprice() });

			String sql1 = "update airsys_flight set first_class_remain_seats=first_class_remain_seats-1 where fnumber = ?";
			jdbcTemplate.update(sql1, new Object[] { fnumber });
		}
		if (seat.equals("business_class_remain_seats")) {
			String sql = "INSERT INTO airsys_ticket(tclass,passenger_type,tprice) VALUES(?,?,?)";

			jdbcTemplate.update(sql, new Object[] { t.getTclass(), t.getPassengerType(), t.getTprice() });
			String sql1 = "update airsys_flight set business_class_remain_seats=business_class_remain_seats-1 where fnumber = ?";
			jdbcTemplate.update(sql1, new Object[] { fnumber });

		}
		if (seat.equals("economy_class_remain_seats")) {
			String sql = "INSERT INTO airsys_ticket(tclass,passenger_type,tprice) VALUES(?,?,?)";

			jdbcTemplate.update(sql, new Object[] { t.getTclass(), t.getPassengerType(), t.getTprice() });
			String sql1 = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats-1 where fnumber = ?";
			jdbcTemplate.update(sql1, new Object[] { fnumber });
		}
	}

	
	//买票 插入营业员sid 航班fid 用户uid
	@Override
	public void addAndupdate(Ticket t, String fnumber, String seat) {
		if (seat.equals("first_class_remain_seats")) {
			String sql = "INSERT INTO airsys_ticket(fid,uid,sid,tclass,passenger_type,tprice) VALUES(?,?,?,?,?,?)";
			//jdbcTemplate.update(sql, new Object[] { t.getFid(),t.getUid(),t.getSid(),t.getTclass(), t.getPassengerType(), t.getTprice() });

			String sql1 = "update airsys_flight set first_class_remain_seats=first_class_remain_seats-1 where fnumber = ?";
			jdbcTemplate.update(sql1, new Object[] { fnumber });
		}
		if (seat.equals("business_class_remain_seats")) {
			String sql = "INSERT INTO airsys_ticket(fid,uid,sid,tclass,passenger_type,tprice) VALUES(?,?,?,?,?,?)";
		//	jdbcTemplate.update(sql, new Object[] { t.getFid(),t.getUid(),t.getSid(),t.getTclass(), t.getPassengerType(), t.getTprice() });
			String sql1 = "update airsys_flight set business_class_remain_seats=business_class_remain_seats-1 where fnumber = ?";
			jdbcTemplate.update(sql1, new Object[] { fnumber });
		}
		if (seat.equals("economy_class_remain_seats")) {
			String sql = "INSERT INTO airsys_ticket(fid,uid,sid,tclass,passenger_type,tprice) VALUES(?,?,?,?,?,?)";
			//jdbcTemplate.update(sql, new Object[] { t.getFid(),t.getUid(),t.getSid(),t.getTclass(), t.getPassengerType(), t.getTprice() });
			String sql1 = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats-1 where fnumber = ?";
			jdbcTemplate.update(sql1, new Object[] { fnumber });
		}
		
	}
	// 6、退票 根据用户id，航班号，座位数退票
	@Override
	public void delete(int uid, int fid, String seat) {

		if (seat.equals("first_class_remain_seats")) {
			String sql = "delete from airsys_ticket where uid=?";
			jdbcTemplate.update(sql, new Object[] { uid });

			String sql1 = "update airsys_flight set first_class_remain_seats=first_class_remain_seats+1 where fid = ?";
			jdbcTemplate.update(sql1, new Object[] { fid });
		}
		if (seat.equals("business_class_remain_seats")) {
			String sql = "delete from airsys_ticket where uid=?";
			jdbcTemplate.update(sql, new Object[] { uid });
			String sql1 = "update airsys_flight set business_class_remain_seats=business_class_remain_seats+1 where fid = ?";
			jdbcTemplate.update(sql1, new Object[] { fid });
		}
		if (seat.equals("economy_class_remain_seats")) {
			String sql = "delete from airsys_ticket where uid=?";
			jdbcTemplate.update(sql, new Object[] { uid });
			String sql1 = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats+1 where fid = ?";
			jdbcTemplate.update(sql1, new Object[] { fid });
		}

	}

	

	

	//退票
	//通过订单编号和身份证先查出用户要退的这张票
	@Override
	public List<Ticket> findByOId(int oid, String idcard) {
		String sql="  SELECT * FROM airsys_ticket WHERE tid=? AND idcard = ?";
		return jdbcTemplate.query(sql, new Object[]{oid,idcard },new BeanPropertyRowMapper<Ticket>(Ticket.class));
	}





	

}
