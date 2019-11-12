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
    int login(String num,String pwd);
	//2.查票
    List<Info>  select(String startplace,String destination,String startTime);
	//3.买票  增加更新
	void buy(Ticket t,String fnumber,String seat);
	//4.退票  删除更新
	void quit(int uid,int fid,String seat);
	//5.查看营业员个人信息
	List<Sales> saleinfo(int sid);
	//6.查看历史记录
	List<Ticket> history(int sid);
}
