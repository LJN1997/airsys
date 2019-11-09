package service.prototy;

import java.util.List;

import entity.Airport;
import util.MiniPager;

public interface IAirportService {
	@MiniPager(tableName="airsys_airport")
	List<Airport> listAirport(int pageNo,int pageSize);
	void AirDelete(String airport_number);
	void AirSaveorUpdate(Airport air);
	int totalItems();
	List<Airport> find(String air_number);
}
