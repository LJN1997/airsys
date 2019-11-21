package service.prototy;

import java.util.List;

import entity.Info;
import entity.Order;
import entity.Sales;
import entity.Ticket;

/**
* 
*	service层接口
* @author DanyangLi
*/
public interface ISalesService {
	//1、判断营业员登录
    int login(String num,String pwd);
    int findSid(String num,String pwd);
	//2、查票
    List<Info>  select(String startplace,String destination,String startTime);
    //3、查看营业员个人信息
  	List<Sales> saleinfo(String snumber);
  	//4、查看历史记录
  	List<Ticket> history(String num);
    //5、买票
  	void updateFightSeat(String fnumber,String seat);
	void addTicket(Ticket t);
    void addOrder(Order o);

    //6、退票
    //6.1、通过订单编号和身份证先查出用户这张票
    List<Ticket> findBy(String name,String idcard);
  	
  	
  	
  	
  	
  	//3.买票  增加更新
	void buy(Ticket t,String fnumber,String seat);
	//买票自动增加fid sid uid
	void addAndupdate(Ticket t,String fnumber,String seat);
	//4.退票  删除更新
	void quit(int uid,int fid,String seat);
	
}
