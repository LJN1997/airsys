package dao.prototy;

import java.util.List;

import entity.Ticket;
import entity.UserSelect;
import entity.UserSelectAll;

public interface IAirsysDao {
	List<UserSelect> find (String start ,String fromCity ,String toCity);
	List<UserSelectAll> findAll ();
	List<UserSelectAll> findFlightBuff (String fnumber,String expStartTime);
	void delete(int uid,int fid,String passenger);
	void saveOrUpdate(Ticket fgt,int fid,String start_date);
}
