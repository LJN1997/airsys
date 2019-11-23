package service.prototy;

import java.util.List;

import entity.Fplan;
import entity.Info;
import entity.Plan;
import entity.PlanNew;

public interface IPlanService {
	List<PlanNew> findFplan();
	List<PlanNew> findByNumber(String fnumber);
	void delete(String fnumber);
	void UpdateOrSave(PlanNew plan);
	
}
