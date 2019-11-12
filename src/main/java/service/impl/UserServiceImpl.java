package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IUserDao;
import entity.User;
import service.prototy.IUserService;
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	@Override
	public List<User> Userlistfind(int pageNo, int pageSize) {
		return userDao.Userlistfind((pageNo-1)*pageSize, pageSize);
	}
	@Override
	public List<User> find(int uid) {
		return userDao.find(uid);
	}
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	@Override
	public void delete(int uid) {
		userDao.delete(uid);;
	}

}
