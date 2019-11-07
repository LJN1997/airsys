package dao.prototy;

import java.util.List;


import entity.PlaceAdmin;
import entity.Sales;
import entity.Ticket;
import util.Pager;

/**
 * 营业点管理员Dao接口
 * @author Administrator
 */
public interface PlaceAdminDao {
	//增加或修改营业员
	void saveOrUpdate(Sales sales);
	//删除营业员
	void delete(String snumber);
	//根据ID查询营业员
	Sales find(String snumber);
	//分页查询
	List<Sales> findAll(int pid);
	List<Sales> listfind(int pid,int offset,int pageSize);
	Pager<Sales> findSalesPage(int pid,int offset,int pageSize);
	//修改营业管理员个人信息
	void updateSelf(PlaceAdmin padmin) ;
	//查询营业员售票记录
	List<Ticket> findTicketList(int sid,int offset,int pageSize);
	Pager<Ticket> findTicketPage(int sid,int offset,int pageSize);
	//获取营业员总条目数
	int saleTotalItems(int pid);
	//获取票总条目数
	int ticketTotalItems(int sid);

}
