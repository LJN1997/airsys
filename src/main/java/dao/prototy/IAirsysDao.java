package dao.prototy;

import java.util.List;

import entity.Ticket;
import entity.UserSelect;
import entity.UserSelectAll;

public interface IAirsysDao {
	//查航班
	List<UserSelectAll> find (String start ,String fromCity ,String toCity);
	List<UserSelectAll> findAll ();
	//查状态
	List<UserSelectAll> findFlightBuff (String fnumber,String expStartTime);
	//删除
	void delete(int uid,int fid,String passenger);
	//修改
	void saveOrUpdate(Ticket fgt,int fid,String start_date);
	//登陆
	int login(String uphone,String upwd);
	//注册
	int reg(String uphone,String upwd);
}
