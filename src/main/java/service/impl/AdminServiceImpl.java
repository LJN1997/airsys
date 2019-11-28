package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IAdminDao;
import entity.Admin;
import service.prototy.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminDao adminDao;
	
	@Override
	public int find(String aid,String pwd) {
	 int num = adminDao.find(aid,pwd);
	 return num;
	}

	@Override
	public Admin find(String anumber) {
		return adminDao.find(anumber);
	}

	@Override
	public void updatePwd(String pwd, int aid) {
		adminDao.updatePwd(pwd, aid);
	}

	@Override
	public Admin findByAid(int aid) {
		return adminDao.findByAid(aid);
	}

}
