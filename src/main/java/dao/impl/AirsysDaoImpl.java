package dao.impl;



import java.util.List;

import javax.management.Query;

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
	public List<UserSelectAll> find(String start, String from_city, String to_city) {
	
		return  jdbctemplate.query("select * from airsys_plan p left join airsys_flight f on p.fnumber=f.fnumber where p.start_date = ? and p.from_city = ? and p.to_city=?",
				new Object[] {start,from_city,to_city},
			
				new BeanPropertyRowMapper<UserSelectAll>(UserSelectAll.class));
	}
	
	@Override
	public List<UserSelectAll> findAll() {
		return jdbctemplate.query("select * from airsys_plan p left join airsys_flight f on p.fnumber=f.fnumber ",
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
		//	jdbctemplate.update(sql1, new Object[] {t.getTclass(),t.getPassengerType(),t.getTprice(),t.getFid(),t.getUid()});
			String sql2 = "update airsys_flight set economy_class_remain_seats = economy_class_remain_seats - 1 where fid= ?";
			jdbctemplate.update(sql2,new Object[] {fid});
		}else if(passenger.equals("business_class_remain_seats")) {
			String sql1 = "insert into airsys_ticket (tclass,passenger_type,tprice,fid,uid) values(?,?,?,?,?)";
		//	jdbctemplate.update(sql1, new Object[] {t.getTclass(),t.getPassengerType(),t.getTprice(),t.getFid(),t.getUid()});
			String sql2 = "update airsys_flight set business_class_remain_seats = business_class_remain_seats - 1 where fid= ?";
			jdbctemplate.update(sql2,new Object[] {fid});
		}else if(passenger.equals("first_class_remain_seats")) {
			String sql1 = "insert into airsys_ticket (tclass,passenger_type,tprice,fid,uid) values(?,?,?,?,?)";
		//	jdbctemplate.update(sql1, new Object[] {t.getTclass(),t.getPassengerType(),t.getTprice(),t.getFid(),t.getUid()});
			String sql2 = "update airsys_flight set first_class_remain_seats = first_class_remain_seats - 1 where fid= ?";
			jdbctemplate.update(sql2,new Object[] {fid});
		}
	}

	@Override
	public List<UserSelectAll> findFlightBuff(String fnumber, String start_date) {
		return jdbctemplate.query("select * from airsys_plan p left join airsys_flight f on p.fnumber=f.fnumber where f.fnumber=? and start_date=?",
				new Object[] {fnumber,start_date},
				new BeanPropertyRowMapper<UserSelectAll>(UserSelectAll.class));
	}
	//用户登陆
	@Override
	public int login(String uphone, String upwd) {
		String sql = "select count(*) from airsys_user where uphone=? and upwd=?";
		
		return jdbctemplate.queryForObject(sql,
				new Object[] {uphone,upwd},
				Integer.class
				);
	}
	//用户注册
	@Override
	public int reg(String uphone, String upwd) {
		String sql = "insert into airsys_user(uphone,upwd) value(?,?)";
		return jdbctemplate.update(sql,
				new Object[] {uphone,upwd}
				);
	}
	
	//uid
	@Override
	public int uid(String uphone, String upwd) {
		String sql = "select uid from airsys_user where uphone = ? and upwd = ?";
		return jdbctemplate.queryForObject(sql,new Object[] {uphone,upwd},Integer.class);
	}

	@Override
	public int buy(String uid, String idcard, String ophone, String oname) {
		String sql = "insert into airsys_order (uid,idcard,ophone,oname) value(?,?,?,?)";
		return jdbctemplate.update(sql,new Object[] {uid,idcard,ophone,oname});
	}

	@Override
	public int updateEco(String fid) {
		String sql = "update airsys_flight set economy_class_remain_seats = economy_class_remain_seats -1 where fid = ?";
		return jdbctemplate.update(sql,new Object[] {fid});
	}

	@Override
	public int updateBus(String fid) {
		String sql = "update airsys_flight set business_class_remain_seats = business_class_remain_seats -1 where fid = ?";
		return jdbctemplate.update(sql,new Object[] {fid});
	}

	@Override
	public int updateFir(String fid) {
		String sql = "update airsys_flight set first_class_remain_seats = first_class_remain_seats -1 where fid = ?";
		return jdbctemplate.update(sql,new Object[] {fid});
	}

	@Override
	public int insertBuy(String seats, String man, String tprice, String fid, String uid, String idcard,
			String status) {
		
		String sql = "insert into airsys_ticket (tclass,passenger_type,tprice,fid,uid,idcard,status) values(?,?,?,?,?,?,?)";
		return jdbctemplate.update(sql, new Object[] {seats,man,tprice,fid,uid,idcard,status});
	}

}
