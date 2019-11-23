package dao.prototy;

import java.util.List;

import entity.Plan;

public interface IPlanDao {

	List<Plan> findFight();
	List<Plan> findforNumber(String fnumber);
	void delete(String fnumber);
	void UpdateOrSave(Plan plan);
}
