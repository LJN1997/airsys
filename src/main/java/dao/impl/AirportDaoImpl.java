package dao.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.IAirportDao;
import entity.Airport;
import entity.User;

@Repository("airportDaoImpl")
public class AirportDaoImpl implements IAirportDao {
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int AportDelete(String airportNumber) {
		int a =jt.update("delete from airsys_airport  where airport_number=?",
				new Object[] {airportNumber});
		return a;
	}

	@Override
	public void AportSaveorUpadate(Airport airport) {
		int a  =jt.queryForObject("select count(*) as num from airsys_airport where airport_number=?",
				new Object[] {airport.getAirportNumber()},Integer.class);
		if(a==0) {
			jt.update("insert into airsys_airport (airport_number,airport_name,airport_city) values(?,?,?)",
					new Object[] {airport.getAirportNumber(),airport.getAirportName(),airport.getAirportCity()});
		}else {
			jt.update("update airsys_airport set airport_name=?,airport_city=? where airport_number=?",
					new Object[] {airport.getAirportName(),airport.getAirportCity(),airport.getAirportNumber()});
		}
	}

	@Override
	public List<Airport> Airlistfind(int pageNo, int pageSize) {
		return jt.query("select * from airsys_airport limit ?,?",
				new Object[] {pageNo,pageSize},
				new BeanPropertyRowMapper<Airport>(Airport.class));
		
	}

	@Override
	public int totalItems() {
		return jt.queryForObject("select count(*) from airsys_airport", 
				Integer.class);
	}

	@Override
	public List<Airport> find(String airNumber) {
		return jt.query("select * from airsys_airport where airport_number=?",
				new Object[] {airNumber},
				new BeanPropertyRowMapper<Airport>(Airport.class));
		
	}

	@Override
	public List<Airport> findall() {
		return jt.query("select * from airsys_airport", 
				new BeanPropertyRowMapper<Airport>(Airport.class));
	}

	@Override
	public List<Airport> findsth(String key) {
		return jt.query("SELECT * from airsys_airport WHERE CONCAT(airport_number,airport_name,airport_city) LIKE '%"+key+"%'", 
				new BeanPropertyRowMapper<>(Airport.class));
	}



}
