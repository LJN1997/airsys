package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.ISalesDao;
import entity.Info;
import entity.Order;
import entity.Sales;
import entity.Ticket;
import service.prototy.ISalesService;

/**
 * 
 * 营业员实现service层接口
 * 
 * @author DanyangLi
 */
@Service("salesServiceImpl")
public class SalesServiceImpl implements ISalesService {

	@Autowired
	private ISalesDao sd;

	// 1.判断营业员登录
	@Override
	public int login(String num, String pwd) {
		int number = sd.login(num, pwd);
		return number;
	}

	// 2.查票
	@Override
	public List<Info> select(String startplace, String destination, String startTime) {
		return sd.find(startplace, destination, startTime);
	}
	// 3.查看营业员个人信息
	@Override
	public List<Sales> saleinfo(String snumber) {
		return sd.saleinfo(snumber);
	}

	// 4.查看历史记录
	@Override
	public List<Ticket> history(String num) {
		return sd.history(num);
	}
    //5.买票
	@Override
	public void updateFightSeat(String fnumber, String seat) {
               sd.updateFightSeat(fnumber, seat);		
	}

	@Override
	public void addTicket(Ticket t) {
         sd.addTicket(t);		
	}

	@Override
	public void addOrder(Order o) {
         sd.addOrder(o);		
	}
	

	
	// 3.买票 增加更新
	@Override
	public void buy(Ticket t, String fnumber, String seat) {
		sd.buy(t, fnumber, seat);
	}

	@Override
	public void addAndupdate(Ticket t, String fnumber, String seat) {
      sd.addAndupdate(t, fnumber, seat);		
	}
	
	// 4.退票 删除更新
	@Override
	public void quit(int uid, int fid, String seat) {
		sd.delete(uid, fid, seat);
	}



	@Override
	public int findSid(String num, String pwd) {
		return sd.findSid(num, pwd);
	}
	 //6、退票
    //6.1、通过订单编号和身份证先查出用户这张票

	@Override
	public List<Ticket> findBy(String name, String idcard) {
		// TODO Auto-generated method stub
		return sd.findBy(name, idcard);
	}











}
