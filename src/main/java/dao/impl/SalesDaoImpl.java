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
	public void login(String num, String pwd) {
		String sql = "SELECT * from airsys_sales WHERE snumber=? and spwd=?";
		jdbcTemplate.queryForList(sql, new Object[] { num, pwd });
	}

	// 2、查票 根据用户输入的出发地、目的地、时间 查询出符合条件的机票
	@Override
	public List<Info> find(String startplace, String destination, String startTime) {
		String sql = "SELECT f.fnumber ,p.from_city ,p.to_city ,p.start_date ,p.departure_time ,p.arrival_time ,f.first_class_remain_seats ,f.business_class_remain_seats ,f.economy_class_remain_seats ,p.tprice ,f.season_discount  FROM airsys_flight f RIGHT JOIN airsys_plan p ON f.fnumber=p.fnumber WHERE from_city = ? AND to_city= ? AND start_date= ? ";
		return jdbcTemplate.query(sql, new Object[] { startplace, destination, startTime },
				new BeanPropertyRowMapper<Info>(Info.class));
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

	// 7、查看营业员个人信息
	@Override
	public List<Sales> saleinfo(int sid) {
		String sql = "select s.sid,s.shead,s.sname,s.snumber,p.pname,p.psite,s.sphone ,p.province from airsys_sales s join airsys_place p on s.pid=p.pid where s.sid=?";

		return jdbcTemplate.query(sql, new Object[] { sid }, new BeanPropertyRowMapper<Sales>(Sales.class));
	}

	// 8、查看历史记录
	@Override
	public List<Ticket> history(int sid) {

		String sql = "SELECT s.snumber,t.tdate,t.tprice,t.passenger_type FROM airsys_ticket t JOIN airsys_sales s ON t.sid=s.sid WHERE s.sid=?";
		return jdbcTemplate.query(sql, new Object[] { sid }, new BeanPropertyRowMapper<Ticket>(Ticket.class));
	}

}
