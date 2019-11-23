package service.prototy;

import java.util.List;

import entity.Admin;

public interface IAdminService {
	int find(String anumber,String pwd);
	Admin find(String anumber);
}
