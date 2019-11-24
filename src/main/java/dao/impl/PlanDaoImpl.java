package dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.unit.DataUnit;

import dao.prototy.IPlanDao;
import entity.Fplan;
import entity.Info;
import entity.Plan;
import entity.PlanNew;
import service.prototy.ISalesService;
import util.DateUtil;

@Repository("planDaoImpl")
public class PlanDaoImpl implements IPlanDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<PlanNew> findFight() {
		return jt.query("select * from airsys_plan", new BeanPropertyRowMapper<>(PlanNew.class));
	}

	@Override
	public List<PlanNew> findforNumber(String fnumber) {
		return jt.query("select * from airsys_plan where fnumber=?", new Object[] { fnumber },
				new BeanPropertyRowMapper<PlanNew>(PlanNew.class));
	}

	@Override
	public void delete(String fnumber) {
		jt.update("delete from airsys_plan where fnumber=?", new Object[] { fnumber });
	}

	@Override
	public void UpdateOrSave(PlanNew plan) {

		int a = jt.queryForObject("select count(*)  from airsys_plan where fnumber=?",
				new Object[] { plan.getFnumber() }, Integer.class);
		if (a <= 0) {
			jt.update(
					"insert into airsys_plan (fnumber,from_city,to_city,start_date,end_date,type,tprice,sail_length,exp_start_time,exp_end_time) values(?,?,?,?,?,?,?,?,?,?)",
					new Object[] { plan.getFnumber(), plan.getFromCity(), plan.getToCity(),
							DateUtil.toDate("yyyy-MM-dd", plan.getStartDate()),
							DateUtil.toDate("yyyy-MM-dd", plan.getEndDate()),plan.getType(),plan.getTprice(),plan.getSailLength(),plan.getExpEndTime(),plan.getExpEndTime() });
		} else {
			jt.update(
					"update airsys_plan set fnumber=?,from_city=?,to_city=?,start_date=?,end_date=?,type=? where plan_id=?",
					new Object[] { plan.getFnumber(), plan.getFromCity(), plan.getToCity(),
							DateUtil.toDate("yyyy-MM-dd", plan.getStartDate()),
							DateUtil.toDate("yyyy-MM-dd", plan.getEndDate()), plan.getType(), plan.getPlanId() });
		}
	}

}
