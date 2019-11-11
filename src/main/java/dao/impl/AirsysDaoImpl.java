package dao.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.IAirsysDao;
import entity.Ticket;
import entity.UserSelect;
import entity.UserSelectAll;
@Repository("accountDaoSpringImpl")
public class AirsysDaoImpl implements IAirsysDao{
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<UserSelect> find(String start, String fromCity, String toCity) {
		
		return  jdbctemplate.query("select * from airsys_plan p left join airsys_flight f on p.fnumber=f.fnumber where start_date = ? and from_city = ? and to_city=?",
				new Object[] {start,fromCity,toCity},
				new BeanPropertyRowMapper<UserSelect>(UserSelect.class));
	}
	
	@Override
	public List<UserSelectAll> findAll() {
		return jdbctemplate.query("select * from airsys_plan p left join airsys_flight f on p.fnumber=f.fnumber",
				new BeanPropertyRowMapper<UserSelectAll>(UserSelectAll.class));
	}
	

	@Override
	public void delete(int uid,int fid,String passenger) {
		
		if(passenger.equals("economy_class_remain_seats")) {
			String sql1 = "delete from airsys_ticket where uid = ?";
			jdbctemplate.update(sql1, new Object[] {uid});
			String sql2 = "update airsys_flight set economy_class_remain_seats = economy_class_remain_seats + 1 where fid= ?";
			jdbctemplate.update(sql2,new Object[] {fid});
		}else if(passenger.equals("business_class_remain_seats")) {
			String sql1 = "delete from airsys_ticket where uid = ?";
			jdbctemplate.update(sql1, new Object[] {uid});
			String sql2 = "update airsys_flight set business_class_remain_seats = business_class_remain_seats + 1 where fid= ?";
			jdbctemplate.update(sql2,new Object[] {fid});
		}else if(passenger.equals("first_class_remain_seats")) {
			String sql1 = "delete from airsys_ticket where uid = ?";
			jdbctemplate.update(sql1, new Object[] {uid});
			String sql2 = "update airsys_flight set first_class_remain_seats = first_class_remain_seats + 1 where fid= ?";
			jdbctemplate.update(sql2,new Object[] {fid});
		}
		
		
		
	}

	@Override
	public void saveOrUpdate(Ticket t, int fid, String passenger) {
		if(passenger.equals("economy_class_remain_seats")) {
			String sql1 = "insert into airsys_ticket (tclass,passenger_type,tprice,fid,uid) values(?,?,?,?,?)";
			jdbctemplate.update(sql1, new Object[] {t.getTclass(),t.getPassengerType(),t.getTprice(),t.getFid(),t.getUid()});
			String sql2 = "update airsys_flight set economy_class_remain_seats = economy_class_remain_seats - 1 where fid= ?";
			jdbctemplate.update(sql2,new Object[] {fid});
		}else if(passenger.equals("business_class_remain_seats")) {
			String sql1 = "insert into airsys_ticket (tclass,passenger_type,tprice,fid,uid) values(?,?,?,?,?)";
			jdbctemplate.update(sql1, new Object[] {t.getTclass(),t.getPassengerType(),t.getTprice(),t.getFid(),t.getUid()});
			String sql2 = "update airsys_flight set business_class_remain_seats = business_class_remain_seats - 1 where fid= ?";
			jdbctemplate.update(sql2,new Object[] {fid});
		}else if(passenger.equals("first_class_remain_seats")) {
			String sql1 = "insert into airsys_ticket (tclass,passenger_type,tprice,fid,uid) values(?,?,?,?,?)";
			jdbctemplate.update(sql1, new Object[] {t.getTclass(),t.getPassengerType(),t.getTprice(),t.getFid(),t.getUid()});
			String sql2 = "update airsys_flight set first_class_remain_seats = first_class_remain_seats - 1 where fid= ?";
			jdbctemplate.update(sql2,new Object[] {fid});
		}
	}

	@Override
	public List<UserSelectAll> findFlightBuff(String fnumber, String startDate) {
		return jdbctemplate.query("select * from airsys_plan p left join airsys_flight f on p.fnumber=f.fnumber where f.fnumber=? and start_date=?",
				new Object[] {fnumber,startDate},
				new BeanPropertyRowMapper<UserSelectAll>(UserSelectAll.class));
	}

}
