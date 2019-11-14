package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.ISelectAllDao;
import entity.Info;
import service.prototy.ISalesService;
@Repository("selectDaoImpl")
public class SelectDaoImpl implements ISelectAllDao{

	@Autowired
	private JdbcTemplate jt;
	@Override
	public List<Info> findFight() {
		return jt.query("SELECT *  FROM airsys_flight f RIGHT JOIN airsys_plan p ON f.fnumber=p.fnumber ", 
					new BeanPropertyRowMapper<Info>(Info.class));
	}

}
