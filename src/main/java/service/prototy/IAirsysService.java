package service.prototy;

import java.util.List;

import entity.Ticket;
import entity.UserSelect;
import entity.UserSelectAll;
import util.MiniPager;

/*
 * Airsys业务接口
 */
public interface IAirsysService {
	@MiniPager(tableName="airsys")
	List<UserSelect> searchFlight(String start,String fromCity,String toCity);
	
	@MiniPager(tableName="airsys")
	List<UserSelectAll> searchFlightAll();
	@MiniPager(tableName="ticket")
	void  delete(int uid,int fid,String passenger);
	@MiniPager(tableName="tcketFlight")
	void saveOrUpdate(Ticket fgt,int fid,String passenger);
	
	void Update(int uid,int fid,String passenger,Ticket fgt);
	
}
