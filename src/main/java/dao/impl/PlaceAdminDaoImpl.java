package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.PlaceAdminDao;
import entity.PlaceAdmin;
import entity.Sales;
import entity.Ticket;
import util.Pager;
/**
 * AplaceAdminDao实现类
 * @author Administrator
 */
@Repository("placeAdminDaoImpl") 
public class PlaceAdminDaoImpl implements PlaceAdminDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveOrUpdate(Sales sales) {
		int number = jdbcTemplate.queryForObject(
				"SELECT count(*) AS num FROM airsys_sales where snumber = ?",
				new Object[]{sales.getSnumber()},Integer.class);
		if(sales.getSid()==0) {
			if(number<=0) {
			jdbcTemplate.update(
					"INSERT INTO airsys_sales (snumber,sname,spwd,shead,pid) values (?,?,?,?,?)",
					new Object[] {sales.getSnumber(),sales.getSname(),sales.getSpwd(),sales.getShead(),sales.getPid()});
			}else {
				System.out.println("工号不能重复");
			}
			
		}else {
			int num = jdbcTemplate.queryForObject(
					"SELECT count(*) AS num FROM airsys_sales where sid = ?",
					new Object[]{sales.getSid()},Integer.class);
			if(number>0) {
				System.out.println("工号不能重复");
			}
			if(num>0) {
			jdbcTemplate.update(
					"update airsys_sales set snumber=?,sname=?,spwd=?,shead=?,pid=? where sid=?",
					new Object[] {sales.getSnumber(),sales.getSname(),sales.getSpwd(),sales.getShead(),sales.getPid(),sales.getSid()});
			}else if(num<=0){
				System.out.println("没有该营业员！");
			} 
		}
		
	}

	@Override
	public void delete(String snumber) {
		int number = jdbcTemplate.queryForObject(
				"SELECT count(*) AS num FROM airsys_sales where snumber = ?",
				new Object[]{snumber},Integer.class);
		if(number>0) {
			jdbcTemplate.update("delete from airsys_sales where snumber = "+snumber+"");	
		}else {
			System.out.println("没有该营业员！");
		}
	}
	
	@Override
	public Sales find(String snumber) {
		int number = jdbcTemplate.queryForObject(
				"SELECT count(*) AS num FROM airsys_sales where snumber = ?",
				new Object[]{snumber},Integer.class);
		if(number>0) {
			return  jdbcTemplate.queryForObject(
					"select * from airsys_sales where snumber = "+snumber+"", 
					new BeanPropertyRowMapper<>(Sales.class));
		}
			return null;

	}

	@Override
	public List<Sales> findAll(int pid) {
		
		return jdbcTemplate.query(
				"select * from airsys_sales where pid = "+pid+"",
				new BeanPropertyRowMapper<>(Sales.class));
	}

	@Override
	public List<Sales> listfind(int pid,int offset, int pageSize) {
	
		return jdbcTemplate.query(
				"select * from airsys_sales where pid = ? limit ?,?", 
				new Object[] {pid,offset,pageSize},
				new BeanPropertyRowMapper<>(Sales.class));

	}

	
	@Override
	public void updateSelf(PlaceAdmin padmin) {
		int number = jdbcTemplate.queryForObject(
				"SELECT count(*) AS num FROM airsys_place_admin where paid = ?",
				new Object[]{padmin.getPaid()},Integer.class);
		if(number>0) {
		jdbcTemplate.update(
				"update airsys_place_admin set paname=?,papwd=?,pahead=? where paid = ?",
				new Object[] {padmin.getPaname(),padmin.getPapwd(),padmin.getPahead(),padmin.getPaid()});		
		}
	}

	
	@Override
	public List<Ticket> findTicketList(int sid,int offset, int pageSize) {
		return jdbcTemplate.query(
				"select * from airsys_ticket where sid=? limit ?,?", 
				new Object[] {sid,offset,pageSize},
				new BeanPropertyRowMapper<>(Ticket.class));
	}

	@Override
	public int saleTotalItems(int pid) {	
		return jdbcTemplate.queryForObject(
				"select count(*) from airsys_sales where pid ="+pid+" ", 
				new Object[] {},Integer.class
				);
	} 

	@Override
	public int ticketTotalItems(int sid) {	
		return jdbcTemplate.queryForObject(
				"select count(*) from airsys_ticket where sid = "+sid+"", 
				new Object[] {},Integer.class
				);
	}

	@Override
	public Pager<Sales> findSalesPage(int pid, int offset, int pageSize) {
		Pager<Sales> pager = new Pager<Sales>();
		pager.setData(listfind(pid, offset, pageSize));
		pager.setPageNum((saleTotalItems(pid)+pageSize-1)/pageSize);
		return pager;
		
	}

	@Override
	public Pager<Ticket> findTicketPage(int sid, int offset, int pageSize) {
		Pager<Ticket> ticketPager = new Pager<Ticket>();
		ticketPager.setData(findTicketList(sid, offset, pageSize));
		ticketPager.setPageNum((saleTotalItems(sid)+pageSize-1)/pageSize);
		return ticketPager;
	}


}