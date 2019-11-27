package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.IDataDao;
import entity.CountData;
@Repository("dataDaoImpl")
public class DataDaoImpl implements IDataDao{
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<CountData> find() {
		return jt.query("SELECT p.pname,SUM(t.tprice) as allprice,COUNT(*) as count FROM	airsys_place p JOIN airsys_sales s ON p.pid=s.sid JOIN airsys_ticket t ON   s.sid=t.sid GROUP BY pname", 
				new BeanPropertyRowMapper<CountData>(CountData.class));
	}

}
