package service.prototy;

import java.util.List;

import entity.PlaceAdmin;
import entity.Sales;
import entity.SalesTicket;
import util.Pager;

/**
 * 营业点管理员Service接口
 * @author Administrator
 */
public interface PlaceAdminService {
	//-- 增加或修改营业员信息6
	void saveOrUpdate(Sales sales);
	//-- 查询营业员信息
	Sales querry(int sid);
	List<Sales> SlistPaged(int pid,int pageNo,int pageSize);
	Pager<Sales> SlistPager(int pid,int pageNo,int pageSize);
	//-- 删除营业员信息
	void delete(int sid);
	//-- 修改个人信息
	void updateSelf(PlaceAdmin placeAdmin);
	void updatepwd(int paid,String papwd);
	//-- 查询营业员售票记录信息
	List<SalesTicket> TlistPaged(int pid,int pageNo,int pageSize);
	List<SalesTicket> findTicket(int tid);
	
	Pager<SalesTicket> TlistPager(int pid,int pageNo,int pageSize);
	//-- 模糊查询
	List<Sales> likeQuerry(String keys);
	List<SalesTicket> likeTicket(String keys);
	
	//管理员登录
	PlaceAdmin findPlaceAdmin(String panumber);
	int placeAdminLogin(String panumber,String papwd);
}
