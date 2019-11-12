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
	    
	      //判断营业员登录
	      void login(String num,String pwd);
	
	
			//1、查票         根据用户输入的出发地、目的地、时间 查询出符合条件的机票  
				List<Plan> findall();		
				List  find1(String startplace,String destination,String start_time);
				List<Info>  find(String startplace,String destination,String start_time);
			//增加
			void add(Ticket t);
			//更新
			void update(String f);
			void update1(int fid,String seat);
			
			//2、买票         实现飞机票中增加一条信息，航班票中减少相应座位
			void buy(Ticket t,String fnumber,String seat);
		
			//3、退票
			void delete(int uid,int fid,String seat);
		
			//4.改签
			void modify(int uid,int fid,String seat);
			
			//5.根据id查一条数据
			Info findByNum(String fnumber);
			
			//6.查看营业员个人信息
			List<Sales> saleinfo(int sid);
			//7.查看历史记录
			List<Ticket> history(int sid);
}
