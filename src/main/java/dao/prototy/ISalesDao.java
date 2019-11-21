package dao.prototy;

import java.util.List;

import entity.Info;
import entity.Order;
import entity.Plan;
import entity.Sales;
import entity.Ticket;

/**
* 
*		营业员接口
* @author DanyangLi
*/
public interface ISalesDao {
	      //1、判断营业员登录
	      int login(String num,String pwd);
	      //根据营业员的工号和密码查找营业员的sid，将其写入session中
	      int findSid(String num,String pwd);
	     //2、查票         根据用户输入的出发地、目的地、时间 查询出符合条件的机票  
	      List<Info>  find(String startplace,String destination,String startTime);
	    //3、根据工号查看营业员个人信息
			List<Sales> saleinfo(String num);
		//4、查看历史记录
			List<Ticket> history(String num);
	      //5、买票
			void updateFightSeat(String fnumber,String seat);
			void addTicket(Ticket t);
	        void addOrder(Order o);  
	       //6、退票
	        //6.1、通过姓名和身份证先查出用户这张票
	        List<Ticket> findBy(String name,String idcard);
	       
	      //3、增加一张票
			void add(Ticket t);
		 //4、根据fid更新座位数
			void update1(int fid,String seat);
		 //5、买票         实现飞机票中增加一条信息，航班票中减少相应座位
			void buy(Ticket t,String fnumber,String seat);
			void addAndupdate(Ticket t,String fnumber,String seat);
		 //6、退票        根据用户id，航班号，座位数退票
			void delete(int uid,int fid,String seat);
		
}
