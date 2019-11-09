package service.prototy;

import java.util.List;

import entity.PlaceAdmin;
import entity.Sales;
import entity.Ticket;
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
	//-- 查询营业员售票记录信息
	List<Ticket> TlistPaged(int sid,int pageNo,int pageSize);
	Pager<Ticket> TlistPager(int sid,int pageNo,int pageSize);
}
