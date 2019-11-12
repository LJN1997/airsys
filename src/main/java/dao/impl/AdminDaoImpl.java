package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.IAdminDao;
import entity.Admin;

@Repository("adminDaoImpl")
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public int find(String anumber, String pwd) {
		int num = jt.queryForObject("select count(*) from airsys_admin where anumber =? and apwd=?",
				new Object[] { anumber, pwd }, Integer.class);
		return num;
	}

	@Override
	public List<Admin> find(String anumber) {
		return jt.query("select * from airsys_admin where anumber=?", 
				new Object[] {anumber},
				new BeanPropertyRowMapper<Admin>(Admin.class));
	}

	@Override
	public void update(Admin admin) {
		jt.update("update airsys_admin set apwd=? where anumber=?",
				new Object[] {admin.getApwd(),admin.getAnumber()});
	}

	

}
