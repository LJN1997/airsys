package dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import dao.prototy.ISalesDao;
import entity.Flight;
import entity.Info;
import entity.Plan;
import entity.Sales;
import entity.Ticket;

/**
* 
*	Dao层测试
* @author DanyangLi
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class salesDaoTest {
		
	@Autowired
	private ISalesDao salesDao;
	
	//判断管理员登录
	@Test
	public void login(){
		salesDao.login("111", "111");
	}
	
	@Test
	public void saleinfo(){
		List<Sales> sales =  salesDao.saleinfo(1);
		System.out.println(sales);
	}
	@Test
	public void test02(){
		List<Info> plan = salesDao.find("xa", "sx", "2019-11-05");
		for (Object o:plan){
			System.out.println(o);
		}
	}
	@Test
	public void test3(){
		List plan = salesDao.find1("xa", "sx", "2019-11-05");
		for (Object o:plan){
			System.out.println(o);
		}
	}
	
	
	@Test
	public void test03(){
		List<Plan> p = salesDao.findall();
		for(Plan ps:p){
			System.out.println(ps);
		}
	}
	@Test
	public void  add(){
		Ticket t =new Ticket("头等舱","成人",1000);
		salesDao.add(t);
	}
		
	@Test
	public void update(){
		 salesDao.update("747");
	}
	
	@Test
	public void update1(){
		salesDao.update1(4, "business_class_remain_seats");
	}
	
	//买票
	@Test
	public void buy(){
		salesDao.buy(new Ticket("商务舱","成人",1000),"747", "business_class_remain_seats");
	}
	
	@Test
	public void delete(){
		salesDao.delete(2, 2, "business_class_remain_seats");
	}
	
}
