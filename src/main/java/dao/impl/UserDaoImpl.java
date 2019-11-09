package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.IUserDao;
import entity.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements IUserDao{
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<User> Userlistfind(int pageNo, int pageSize) {
		return jt.query("select * from airsys_user limit ?,?",
				new Object[] {pageNo,pageSize},
				new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> find(int uid) {
		return jt.query("select * from airsys_user where uid=?", 
						new Object[] {uid},
						new BeanPropertyRowMapper<User>(User.class));
	}

}
