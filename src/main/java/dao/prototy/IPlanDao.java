package dao.prototy;

import java.util.List;

import entity.Plan;
import entity.PlanNew;

public interface IPlanDao {

	List<PlanNew> findFight();
	List<PlanNew> findforNumber(String fnumber);
	void delete(String fnumber);
	void UpdateOrSave(PlanNew plan);
}
