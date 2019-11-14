package service.prototy;

import java.util.List;

import entity.Info;
import entity.Plan;

public interface IPlanService {
	List<Plan> findFplan();
	List<Plan> findByNumber(String fnumber);
	void delete(int planId);
	void UpdateOrSave(Plan plan);
	
}
