package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.ISelectAllDao;
import entity.Info;
import service.prototy.ISelectService;
@Service
public class SelectServiceImpl implements ISelectService{
	
	@Autowired
	private ISelectAllDao selectDao;
	@Override
	public List<Info> findFight() {
		return selectDao.findFight();
	}
	@Override
	public List<Info> findByNumber(int fnumber) {
		return selectDao.findforNumber(fnumber);
	}

}
