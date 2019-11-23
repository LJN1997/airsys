package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IPlanDao;
import entity.Fplan;
import entity.Info;
import entity.Plan;
import service.prototy.IPlanService;
@Service
public class PlanServiceImpl implements IPlanService{
	
	@Autowired
	private IPlanDao planDao;

	@Override
	public List<Plan> findFplan() {
		return planDao.findFight();
	}

	@Override
	public List<Plan> findByNumber(String fnumber) {
		return planDao.findforNumber(fnumber);
	}

	@Override
	public void delete(String fnumber) {
		planDao.delete(fnumber);
	}

	@Override
	public void UpdateOrSave(Plan plan) {
		planDao.UpdateOrSave(plan);
	}
	
}
