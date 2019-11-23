package service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IAirsysDao;
import entity.Ticket;
import entity.UserSelect;
import entity.UserSelectAll;
import service.prototy.IAirsysService;

@Service("airsysServiceDaoImpl")
public class AirsysServiceDaoImpl implements IAirsysService{
	@Autowired
	private IAirsysDao asDao;

	@Override
	public List<UserSelectAll> searchFlight(String start, String from_city, String toCity) {
		
		return asDao.find(start, from_city, toCity);
	}

	@Override
	public List<UserSelectAll> searchFlightAll() {
		return asDao.findAll();
	}

	@Override
	public void delete(int uid, int fid, String passenger) {
		asDao.delete(uid, fid, passenger);
	}

	@Override
	public void saveOrUpdate(Ticket fgt, int fid, String passenger) {
		asDao.saveOrUpdate(fgt, fid, passenger);
	}

	@Override
	public void Update(int uid, int fid, String passenger, Ticket fgt) {
		asDao.delete(uid, fid, passenger);
		asDao.saveOrUpdate(fgt, fid, passenger);
	}

	@Override
	public List<UserSelectAll> searchFlightBuff(String fnumber,String start_date) {
		
		return asDao.findFlightBuff(fnumber, start_date);
	}

	@Override
	public int login(String uphone, String upwd) {
		
		return asDao.login(uphone, upwd);
	}

	@Override
	public int reg(String uphone, String upwd) {
		
		return asDao.reg(uphone, upwd);
	}

	@Override
	public int uid(String uphone, String upwd) {
		
		return asDao.uid(uphone, upwd);
	}

	@Override
	public int buy(String uid, String idcard, String ophone, String oname) {
		return asDao.buy(uid, idcard, ophone, oname);
	}

	@Override
	public int updateEco(String fid) {
		return asDao.updateEco(fid);
	}

	@Override
	public int updateBus(String fid) {
		return asDao.updateBus(fid);
	}

	@Override
	public int updateFir(String fid) {
		return asDao.updateFir(fid);
	}

	@Override
	public int insertBuy(String seats, String man, String tprice, String fid, String uid, String idcard,
			String status) {
		return asDao.insertBuy(seats, man, tprice, fid, uid, idcard, status);
	}
	



}
