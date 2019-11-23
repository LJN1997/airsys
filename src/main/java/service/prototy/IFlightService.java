package service.prototy;

import java.util.List;

import entity.Flight;

public interface IFlightService {
	List<Flight> findAll();
	void delete(String fnumber);
	void SaveOrUpdate(Flight flight);
	List<Flight> findByid(String fnumber);

}
