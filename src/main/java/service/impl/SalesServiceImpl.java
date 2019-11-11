package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.ISalesDao;
import entity.Info;
import entity.Sales;
import entity.Ticket;
import service.prototy.ISalesService;

/**
* 
*   营业员实现service层接口
* @author DanyangLi
*/
@Service("salesServiceImpl")
public class SalesServiceImpl implements ISalesService{

	@Autowired
	private ISalesDao sd;
	
	@Override
	public void login(String num, String pwd) {
          		sd.login(num, pwd);
	}
	
	@Override
	public List<Info> select(String startplace, String destination, String start_time) {
		return sd.find(startplace, destination, start_time);
	}

	@Override
	public void buy(Ticket t, String fnumber, String seat) {
			sd.buy(t, fnumber, seat);
	}

	@Override
	public void quit(int uid, int fid, String seat) {
			sd.delete(uid, fid, seat);
	}

	@Override
	public void update(int uid) {

	}

	//查看营业员个人信息
	@Override
	public List<Sales> saleinfo(int sid) {
		
		return sd.saleinfo(sid);
	}

}
