package dao.prototy;

import java.util.List;

import entity.Info;

public interface ISelectAllDao {

	List<Info> findFight();
	List<Info> findforNumber(int fnumber);
}
