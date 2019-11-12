package dao.prototy;

import java.util.List;

import entity.Airport;

public interface IAirportDao {
	int AportDelete(String airportNumber);
	void AportSaveorUpadate(Airport airport);
	List<Airport> Airlistfind(int pageNo, int pageSize); 
	int totalItems();
	List<Airport> find(String airNumber);
	List<Airport> findall();
}
