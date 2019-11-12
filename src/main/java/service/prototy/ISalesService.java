package service.prototy;

import java.util.List;

import entity.Info;
import entity.Sales;
import entity.Ticket;

/**
* 
*	service层接口
* @author DanyangLi
*/
public interface ISalesService {
	//1.判断营业员登录
    void login(String num,String pwd);
	//2.查票
	List<Info>  select(String startplace,String destination,String start_time);
	//3.买票  增加更新
	void buy(Ticket t,String fnumber,String seat);
	//4.退票  删除更新
	void quit(int uid,int fid,String seat);
	//5.改签
	void update(int uid);
	//6.查看营业员个人信息
	List<Sales> saleinfo(int sid);
	//7.查看历史记录
	List<Ticket> history(int sid);
}
