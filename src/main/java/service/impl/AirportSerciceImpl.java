package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dao.prototy.IAirportDao;
import entity.Airport;
import service.prototy.IAirportService;
@Service
public class AirportSerciceImpl  implements IAirportService{
	@Autowired
	private IAirportDao airDao;
	@Override
	public List<Airport> listAirport(int pageNo, int pageSize) {
		return airDao.Airlistfind((pageNo-1)*pageSize, pageSize);
	}
	@Override
	public int AirDelete(String airportNumber) {
		int a =airDao.AportDelete(airportNumber);
		return a;
		
	}
	@Override
	public void AirSaveorUpdate(Airport air) {
		airDao.AportSaveorUpadate(air);
	}
	@Override
	public int totalItems() {
		int totalItems = airDao.totalItems();
		return totalItems;
	}
	@Override
	public List<Airport> find(String airNumber) {
		return airDao.find(airNumber);
	}
	@Override
	public List<Airport> findAll() {
		return airDao.findall();
	}

}
