package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.PlaceAdminDao;
import entity.PlaceAdmin;
import entity.Sales;
import entity.SalesTicket;
import entity.Ticket;
import service.prototy.PlaceAdminService;
import util.Pager;

/**
 * PlaceAdminServiceImpl实现类
 * @author Administrator
 */
@Service("placeAdminServiceImpl")
public class PlaceAdminServiceImpl implements PlaceAdminService{
	@Autowired
	private PlaceAdminDao pad;
	
	@Override
	public void saveOrUpdate(Sales sales) {
		pad.saveOrUpdate(sales);
	}

	@Override
	public Sales querry(int sid) {	
		return pad.find(sid);
	}

	@Override
	public void delete(int sid) {
		pad.delete(sid);
		
	}

	@Override
	public void updateSelf(PlaceAdmin placeAdmin) {
		pad.updateSelf(placeAdmin);		
	}

	@Override
	public Pager<Sales> SlistPager(int pid, int pageNo, int pageSize) {
		//-- 依赖Dao实现
		int totalItems = pad.saleTotalItems(pid);//--总条目数
		int pageNum = (totalItems+pageSize-1)/pageSize;
		if(pageNo >= pageNum) {   //--控制最大页码
			pageNo = pageNum;
		}
		if(pageNo == 0) {   //--控制最小页码
			pageNo = 1;
		}

		Pager<Sales> pager = pad.findSalesPage(pid, (pageNo-1)*pageSize, pageSize);
		return pager;
	}

	@Override
	public Pager<SalesTicket> TlistPager(int pid, int pageNo, int pageSize) {
		//-- 依赖Dao实现
		int totalItems = pad.saleTotalItems(pid);//--总条目数
		int pageNum = (totalItems+pageSize-1)/pageSize;
		if(pageNo >= pageNum) {   //--控制最大页码
			pageNo = pageNum;
		}
		if(pageNo == 0) {   //--控制最小页码
			pageNo = 1;
		}

		Pager<SalesTicket> pager = pad.findTicketPage(pid,(pageNo-1)*pageSize, pageSize);
		return pager;
	}

	@Override
	public List<Sales> SlistPaged(int pid, int pageNo, int pageSize) {
		int totalItems = pad.saleTotalItems(pid);//--总条目数
		int pageNum = (totalItems+pageSize-1)/pageSize;
		if(pageNo >= pageNum) {   //--控制最大页码
			pageNo = pageNum;
		}
		if(pageNo == 0) {   //--控制最小页码
			pageNo = 1;
		}
		return pad.listfind(pid, (pageNo-1)*pageSize, pageSize);
	}

	@Override
	public List<SalesTicket> TlistPaged(int pid, int pageNo, int pageSize) {
		int totalItems = pad.saleTotalItems(pid);//--总条目数
		int pageNum = (totalItems+pageSize-1)/pageSize;
		if(pageNo >= pageNum) {   //--控制最大页码
			pageNo = pageNum;
		}
		if(pageNo == 0) {   //--控制最小页码
			pageNo = 1;
		}
		return pad.findTicketList(pid, (pageNo-1)*pageSize, pageSize);
	}

	@Override
	public List<SalesTicket> findTicket(int tid) {

		return pad.findTicket(tid);
	}

	@Override
	public List<Sales> likeQuerry(String keys) {
		
		return  pad.likeFind(keys);
	}

	@Override
	public List<SalesTicket> likeTicket(String keys) {

		return pad.likeTicket(keys);
	}

}
