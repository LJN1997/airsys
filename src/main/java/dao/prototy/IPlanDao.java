package dao.prototy;

import java.util.List;

import entity.Info;
import entity.Plan;

public interface IPlanDao {

	List<Plan> findFight();
	List<Plan> findforNumber(String fnumber);
	void delete(int planId);
	void UpdateOrSave(Plan plan);
}
