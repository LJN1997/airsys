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
import entity.Ticket;

/**
* 
*  营业员接口实现类
* @author DanyangLi
*/
@Repository("salesDaoImpl")
public class SalesDaoImpl implements ISalesDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//查票
	@Override
	public List<Info>  find(String startplace, String destination, String startTime) {
		String sql = "SELECT f.fnumber ,p.from_city ,p.to_city ,p.start_date ,p.departure_time ,p.arrival_time ,f.first_class_remain_seats ,f.business_class_remain_seats ,f.economy_class_remain_seats ,p.tprice ,f.season_discount  FROM airsys_flight f RIGHT JOIN airsys_plan p ON f.fnumber=p.fnumber WHERE from_city = ? AND to_city= ? AND start_date= ? ";
		return jdbcTemplate.query(sql, new Object[]{startplace,destination,startTime},new BeanPropertyRowMapper<Info>(Info.class));
	}
	@Override
	public List  find1(String startplace, String destination, String startTime) {
		String sql = "SELECT f.fnumber 航班号,p.from_city 出发地,p.to_city 目的地,p.start_date 出发时间,p.departure_time 离港时间,p.arrival_time 到港时间,f.first_class_remain_seats 头等舱剩余座位,f.business_class_remain_seats 公务舱剩余座位,f.economy_class_remain_seats 经济舱剩余座位,p.tprice 票价,f.season_discount 折扣 FROM airsys_flight f RIGHT JOIN airsys_plan p ON f.fnumber=p.fnumber WHERE from_city = ? AND to_city= ? AND start_date= ? ";
		return jdbcTemplate.queryForList(sql, new Object[]{startplace,destination,startTime});
	}

	//查计划表所有内容
	@Override
	public List<Plan> findall() {
		return jdbcTemplate.query("select * from airsys_plan", new BeanPropertyRowMapper<Plan>(Plan.class));
	}

	
	@Override
	public void add(Ticket t) {
			String sql="INSERT INTO airsys_ticket(tclass,passenger_type,tprice) VALUES(?,?,?)";
			jdbcTemplate.update(sql,new Object[]{t.getTclass(),t.getPassengerType(),t.getTprice()});
	}



	@Override
	public void update(String f) {
		String sql = "update airsys_flight set first_class_remain_seats=first_class_remain_seats-1 where fnumber = ?";
		jdbcTemplate.update(sql,new Object[]{f});
	}



	@Override
	public void update1(int fid, String seat) {
		  if(seat.equals("first_class_remain_seats")){
			  String sql = "update airsys_flight set first_class_remain_seats=first_class_remain_seats-1 where fid = ?";
				jdbcTemplate.update(sql,new Object[]{fid});
		  }
		  if(seat.equals("business_class_remain_seats")){
			  String sql = "update airsys_flight set business_class_remain_seats=business_class_remain_seats-1 where fid = ?";
				jdbcTemplate.update(sql,new Object[]{fid});
		  }
		  if(seat.equals("economy_class_remain_seats")){
			  String sql = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats-1 where fid = ?";
				jdbcTemplate.update(sql,new Object[]{fid});
		  }
	}



	@Override
	public void update2(Ticket t, int fid, String seat) {
		
		if(seat.equals("first_class_remain_seats")){
			String sql="INSERT INTO airsys_ticket(tclass,passenger_type,tprice) VALUES(?,?,?)";
			jdbcTemplate.update(sql,new Object[]{t.getTclass(),t.getPassengerType(),t.getTprice()});
			
			  String sql1 = "update airsys_flight set first_class_remain_seats=first_class_remain_seats-1 where fid = ?";
				jdbcTemplate.update(sql1,new Object[]{fid});
		  }
		  if(seat.equals("business_class_remain_seats")){
			  String sql="INSERT INTO airsys_ticket(tclass,passenger_type,tprice) VALUES(?,?,?)";
				jdbcTemplate.update(sql,new Object[]{t.getTclass(),t.getPassengerType(),t.getTprice()});
			  String sql1 = "update airsys_flight set business_class_remain_seats=business_class_remain_seats-1 where fid = ?";
				jdbcTemplate.update(sql1,new Object[]{fid});
		  }
		  if(seat.equals("economy_class_remain_seats")){
			  String sql="INSERT INTO airsys_ticket(tclass,passenger_type,tprice) VALUES(?,?,?)";
				jdbcTemplate.update(sql,new Object[]{t.getTclass(),t.getPassengerType(),t.getTprice()});
			  String sql1 = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats-1 where fid = ?";
				jdbcTemplate.update(sql1,new Object[]{fid});
		  }
	}



	@Override
	public void delete(int uid, int fid, String seat) {
		
		if(seat.equals("first_class_remain_seats")){
			String sql="delete from airsys_ticket where uid=?";
			jdbcTemplate.update(sql,new Object[]{uid});
			
			  String sql1 = "update airsys_flight set first_class_remain_seats=first_class_remain_seats+1 where fid = ?";
				jdbcTemplate.update(sql1,new Object[]{fid});
		  }
		  if(seat.equals("business_class_remain_seats")){
			  String sql="delete from airsys_ticket where uid=?";
				jdbcTemplate.update(sql,new Object[]{uid});
			  String sql1 = "update airsys_flight set business_class_remain_seats=business_class_remain_seats+1 where fid = ?";
				jdbcTemplate.update(sql1,new Object[]{fid});
		  }
		  if(seat.equals("economy_class_remain_seats")){
			  String sql="delete from airsys_ticket where uid=?";
				jdbcTemplate.update(sql,new Object[]{uid});
			  String sql1 = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats+1 where fid = ?";
				jdbcTemplate.update(sql1,new Object[]{fid});
		  }
		
	}

	@Override
	public void modify(int uid, int fid, String seat) {
		if(seat.equals("first_class_remain_seats")){
			String sql="delete from airsys_ticket where uid=?";
			jdbcTemplate.update(sql,new Object[]{uid});
			
			  String sql1 = "update airsys_flight set first_class_remain_seats=first_class_remain_seats+1 where fid = ?";
				jdbcTemplate.update(sql1,new Object[]{fid});
		  }
		  if(seat.equals("business_class_remain_seats")){
			  String sql="delete from airsys_ticket where uid=?";
				jdbcTemplate.update(sql,new Object[]{uid});
			  String sql1 = "update airsys_flight set business_class_remain_seats=business_class_remain_seats+1 where fid = ?";
				jdbcTemplate.update(sql1,new Object[]{fid});
		  }
		  if(seat.equals("economy_class_remain_seats")){
			  String sql="delete from airsys_ticket where uid=?";
				jdbcTemplate.update(sql,new Object[]{uid});
			  String sql1 = "update airsys_flight set economy_class_remain_seats=economy_class_remain_seats+1 where fid = ?";
				jdbcTemplate.update(sql1,new Object[]{fid});
		  }
		
	}
	@Override
	public Info findByNum(String fnumber) {

		
		
		
		return null;
	}

	
	
	
}
