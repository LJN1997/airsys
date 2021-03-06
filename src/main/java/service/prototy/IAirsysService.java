package service.prototy;

import java.util.List;

import entity.Ticket;
import entity.UserInfo;
import entity.UserSelect;
import entity.UserSelectAll;
import util.MiniPager;

/*
 * Airsys业务接口
 */
public interface IAirsysService {
	@MiniPager(tableName="airsys")
	List<UserSelectAll> searchFlight(String start,String fromCity,String toCity);
	
	@MiniPager(tableName="airsys")
	List<UserSelectAll> searchFlightAll();
	@MiniPager(tableName="airsys")
	List<UserSelectAll> searchFlightBuff(String fnumber,String start_date);
	@MiniPager(tableName="ticket")
	void  delete(int uid,int fid,String passenger);
	@MiniPager(tableName="tcketFlight")
	void saveOrUpdate(Ticket fgt,int fid,String passenger);
	
	void Update(int uid,int fid,String passenger,Ticket fgt);
	//登陆
	int login(String uphone,String upwd);
	//注册
	int reg(String uphone,String upwd);
	//查uid
	int uid (String uphone,String upwd);
	//买票
	int buy(String uid, String idcard, String ophone,String oname);
	//买票改座位信息 经济
	int updateEco(String fid);
	//买票改座位信息 商务
	int updateBus(String fid);
	//买票改座位信息 头等
	int updateFir(String fid);
	//买票插票
	int insertBuy(String seats,String man,String tprice, String fid, String uid,String idcard,String status);
	//查询用户订单信息
	List<UserInfo> userTicket(int uid);
	//退票
	int outTicket(String uid,String tid);
	//改票改票状态
	int outTicket2(String uid,String tid);
	//退票改座位
	int outTicketClassEco(String fid);
	int outTicketClassBus(String fid);
	int outTicketClassFir(String fid);
}
