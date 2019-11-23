package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IFlightDao;
import entity.Flight;
import service.prototy.IFlightService;

@Service
public class FlightServiceImpl implements IFlightService{
	@Autowired
	private IFlightDao flightDao;

	@Override
	public List<Flight> findAll() {
		return flightDao.findAll();
	}

	@Override
	public void delete(String fnumber) {
		flightDao.delete(fnumber);
	}

	@Override
	public void SaveOrUpdate(Flight flight) {
		flightDao.SaveOrUpdate(flight);
	}

	@Override
	public List<Flight> findByid(String fnumber) {
		return flightDao.findByid(fnumber);
	}

}
