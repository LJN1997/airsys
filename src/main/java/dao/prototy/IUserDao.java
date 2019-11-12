package dao.prototy;

import java.util.List;

import entity.User;

public interface IUserDao {
	List<User> Userlistfind(int pageNo, int pageSize); 
	List<User> find( int uid);
	List<User> findAll();
	void delete(int uid);
}
