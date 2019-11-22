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
    //6.1、通过姓名和身份证先查出用户这张票
    List<Ticket> findBy(String name,String idcard);
    //6.2、通过航班号和座位更新座位数（退票 该航班座位数+1）
    void addFightSeat(String fnumber,String seat);
    //6.3、更改票的状态为0，表示退票
    void updateTicketStatus(int tid);
  	
  	
  	
  	
  
	
}
