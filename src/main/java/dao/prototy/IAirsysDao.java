package dao.prototy;

import java.util.List;

import entity.Ticket;
import entity.UserSelect;
import entity.UserSelectAll;

public interface IAirsysDao {
	List<UserSelect> find (String start ,String from_city ,String to_city);
	List<UserSelectAll> findAll ();
	void delete(int uid,int fid,String passenger);
	void saveOrUpdate(Ticket fgt,int fid,String passenger);
}
