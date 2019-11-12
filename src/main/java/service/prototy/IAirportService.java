package service.prototy;

import java.util.List;

import entity.Airport;
import util.MiniPager;

public interface IAirportService {
	@MiniPager(tableName="airsys_airport")
	List<Airport> listAirport(int pageNo,int pageSize);
	int AirDelete(String airportNumber);
	void AirSaveorUpdate(Airport air);
	int totalItems();
	List<Airport> find(String airNumber);
}
