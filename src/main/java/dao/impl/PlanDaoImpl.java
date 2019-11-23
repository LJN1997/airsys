package dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.IPlanDao;
import entity.Fplan;
import entity.Info;
import entity.Plan;
import service.prototy.ISalesService;
@Repository("planDaoImpl")
public class PlanDaoImpl implements IPlanDao{

	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<Plan> findFight() {
		return jt.query("select * from airsys_plan",
					new BeanPropertyRowMapper<Plan>(Plan.class));
	}

	@Override
	public List<Plan> findforNumber(String fnumber) {
		return jt.query("select * from airsys_plan where fnumber=?", 
					new Object[] {fnumber},
					new BeanPropertyRowMapper<Plan>(Plan.class));
	}

	@Override
	public void delete(String fnumber) {
		jt.update("delete from airsys_plan where fnumber=?",
					new Object[] {fnumber});
	}

	@Override
	public void UpdateOrSave(Plan plan) {
		int a  =jt.queryForObject("select count(*)  from airsys_plan where fnumber=?",
				new Object[] {plan.getFnumber()},Integer.class);
		if(a<=0) {
			jt.update("insert into airsys_plan (fnumber,from_city,to_city,start_date,end_date,type,tprice) values(?,?,?,?,?)",
					new Object[] {plan.getFnumber(),plan.getFromCity(),plan.getToCity(),plan.getStartDate(),plan.getEndDate(),plan.getType(),plan.getTprice()});
		}else {
			jt.update("update airsys_plan set fnumber=?,from_city=?,to_city=?,start_date=?,end_date=?,type=?,tprice=? where plan_id=?",
					new Object[] {plan.getPlanId(),plan.getFnumber(),plan.getFromCity(),plan.getToCity(),plan.getStartDate(),plan.getEndDate(),plan.getType(),plan.getTprice()});
		}
	}    

 
}
