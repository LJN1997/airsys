package dao.prototy;

import java.util.List;

import entity.PlaceAdmin;
import entity.PlaceAdminCount;
import entity.PlaceAdminCountClass;
import entity.PlaceAdminCountPassenger;
import entity.PlaceAdminCountSales;
import entity.Sales;
import entity.SalesTicket;
import util.Pager;

/**
 * 营业点管理员Dao接口
 * @author Administrator
 */
public interface PlaceAdminDao {
	//增加或修改营业员
	void saveOrUpdate(Sales sales);
	//删除营业员
	void delete(int sid);
	//根据ID查询营业员
	Sales find(int sid);
	//分页查询
	List<Sales> findAll(int pid);
	List<Sales> listfind(int pid,int offset,int pageSize);
	Pager<Sales> findSalesPage(int pid,int offset,int pageSize);
	//修改密码
	void updatePwd(int paid, String papwd);
	//修改营业管理员个人信息
	void updateSelf(PlaceAdmin padmin) ;
	//查询营业员售票记录
	List<SalesTicket> findTicketList(int pid,int offset,int pageSize);
	List<SalesTicket> findTicket(int tid);
	Pager<SalesTicket> findTicketPage(int pid,int offset,int pageSize);
	//获取营业员总条目数
	int saleTotalItems(int pid);
	//获取票总条目数
	int ticketTotalItems(int pid);
	//模糊查询营业员信息
	List<Sales> likeFind(String keys) ;
	//模糊查询售票记录信息
	List<SalesTicket> likeTicket(String keys);
	//管理员登录
	PlaceAdmin findPlaceAdmin(String panumber);
	int placeAdminLogin(String panumber,String papwd);
	
	// 统计信息
	// 营业点总销售额
	double countTotalSales(String panumber);

	// 营业点营业员出售的乘客类型总业绩
	List<PlaceAdminCountPassenger> countTotalPerformanceOfPassengerType(String panumber);

	// 营业点营业员出售的舱位等级总业绩
	List<PlaceAdminCountClass> countTotalPerformanceOfClassType(String panumber);

	// 营业点营业员的总业绩
	List<PlaceAdminCountSales> countTotalPerformanceOfSalesType(String panumber);
	
}
