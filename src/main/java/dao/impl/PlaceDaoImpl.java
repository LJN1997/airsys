package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.IPlaceDao;
import entity.Airport;
import entity.Place;
@Repository("placeDaoImpl")
public class PlaceDaoImpl implements IPlaceDao{
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void PlaceDelete(int pid) {
		jt.update("delete from airsys_place where pid=?",
				new Object[] {pid});
	}

	@Override
	public void PlaceSaveorUpadate(Place place) {
		if(place.getPid()==0) {
			jt.update("insert into airsys_place (pname,pphone,psite,province) values(?,?,?,?)",
					new Object[] {place.getPname(),place.getPphone(),place.getPsite(),place.getProvince()});
		}else {
			jt.update("update airsys_place set pname=?,pphone=?,psite=?,province=? where pid=?",
					new Object[] {place.getPname(),place.getPphone(),place.getPsite(),place.getProvince(),place.getPid()});
		}
	}

	@Override
	public List<Place> Placelistfind(int pageNo, int pageSize) {
		return jt.query("select * from airsys_place limit ?,?",
				new Object[] {pageNo,pageSize},
				new BeanPropertyRowMapper<Place>(Place.class));
	}

	@Override
	public List<Place> find(int pid) {
		return jt.query("select * from airsys_place where pid=?", 
				new Object[] {pid},
				new BeanPropertyRowMapper<Place>(Place.class));
	}

	@Override
	public List<Place> findAll() {
		return jt.query("select * from airsys_place", 
				new BeanPropertyRowMapper<Place>(Place.class));
	}

}
