package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IPlanDao;
import entity.Info;
import entity.Plan;
import service.prototy.IPlanService;
@Service
public class SelectServiceImpl implements IPlanService{
	
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
	public void delete(int planId) {
		planDao.delete(planId);
	}

	@Override
	public void UpdateOrSave(Plan plan) {
		planDao.UpdateOrSave(plan);
	}
	
}
