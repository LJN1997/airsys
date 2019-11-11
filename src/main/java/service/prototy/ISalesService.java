package service.prototy;

import java.util.List;

import entity.Info;
import entity.Ticket;

/**
* 
*	service层接口
* @author DanyangLi
*/
public interface ISalesService {
	//查票
	List<Info>  select(String startplace,String destination,String startTime);
	//买票  增加更新
	void buy(Ticket t,int fid,String seat);
	//退票  删除更新
	void quit(int uid,int fid,String seat);
	//改签
	void update(int uid);
}
