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
	public List<UserSelect> searchFlight(String start, String from_city, String to_city) {
		
		return asDao.find(start, from_city, to_city);
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
	



}
