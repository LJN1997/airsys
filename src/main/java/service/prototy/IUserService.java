package service.prototy;

import java.util.List;

import entity.User;
import util.MiniPager;

public interface IUserService {
	@MiniPager(tableName="airsys_user")
	List<User> Userlistfind(int pageNo, int pageSize); 
	List<User> find(int uid);
	List<User> findAll();
	void delete(int uid);
}
