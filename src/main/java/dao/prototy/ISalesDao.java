package dao.prototy;

import java.util.List;

import entity.Info;
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
	      void login(String num,String pwd);
	     //2、查票         根据用户输入的出发地、目的地、时间 查询出符合条件的机票  
	      List<Info>  find(String startplace,String destination,String startTime);
		 //3、增加一张票
			void add(Ticket t);
		 //4、根据fid更新座位数
			void update1(int fid,String seat);
		 //5、买票         实现飞机票中增加一条信息，航班票中减少相应座位
			void buy(Ticket t,String fnumber,String seat);
		 //6、退票        根据用户id，航班号，座位数退票
			void delete(int uid,int fid,String seat);
		//7、查看营业员个人信息
			List<Sales> saleinfo(int sid);
		//8、查看历史记录
			List<Ticket> history(int sid);
}
