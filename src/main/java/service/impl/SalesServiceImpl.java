package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.ISalesDao;
import entity.Info;
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
	public List<Info> select(String startplace, String destination, String startTime) {
		return sd.find(startplace, destination, startTime);
	}

	@Override
	public void buy(Ticket t, int fid, String seat) {
			sd.update2(t, fid, seat);
	}

	@Override
	public void quit(int uid, int fid, String seat) {
			sd.delete(uid, fid, seat);
	}

	@Override
	public void update(int uid) {

	}

}
