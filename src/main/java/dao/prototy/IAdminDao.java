package dao.prototy;

import java.util.List;

import entity.Admin;

public interface IAdminDao {
	int find(String anumber,String pwd);
	Admin find(String anumber);
	void update(Admin admin);
}
