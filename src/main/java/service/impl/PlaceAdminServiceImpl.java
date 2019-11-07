package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.PlaceAdminDao;
import entity.PlaceAdmin;
import entity.Sales;
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
	public Sales querry(String snumber) {	
		return pad.find(snumber);
	}

	@Override
	public void delete(String snumber) {
		pad.delete(snumber);
		
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
	public Pager<Ticket> TlistPager(int sid, int pageNo, int pageSize) {
		//-- 依赖Dao实现
		int totalItems = pad.saleTotalItems(sid);//--总条目数
		int pageNum = (totalItems+pageSize-1)/pageSize;
		if(pageNo >= pageNum) {   //--控制最大页码
			pageNo = pageNum;
		}
		if(pageNo == 0) {   //--控制最小页码
			pageNo = 1;
		}

		Pager<Ticket> pager = pad.findTicketPage(sid,(pageNo-1)*pageSize, pageSize);
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
	public List<Ticket> TlistPaged(int sid, int pageNo, int pageSize) {
		int totalItems = pad.saleTotalItems(sid);//--总条目数
		int pageNum = (totalItems+pageSize-1)/pageSize;
		if(pageNo >= pageNum) {   //--控制最大页码
			pageNo = pageNum;
		}
		if(pageNo == 0) {   //--控制最小页码
			pageNo = 1;
		}
		return pad.findTicketList(sid, (pageNo-1)*pageSize, pageSize);
	}

}