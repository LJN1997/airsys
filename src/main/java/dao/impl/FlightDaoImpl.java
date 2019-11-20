package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.IFlightDao;
import entity.Flight;

@Repository("flightDaoImpl")
public class FlightDaoImpl implements IFlightDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<Flight> findAll() {
		return jt.query("select * from airsys_flight", new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public void delete(String fnumber) {
		jt.update("delete from airsys_flight where fnumber = ?", new Object[] { fnumber });
	}

	@Override
	public void SaveOrUpdate(Flight flight) {
		int num = jt.queryForObject("select count(*) from airsys_flight where fnumber=?",
				new Object[] { flight.getFnumber() }, Integer.class);
		if (num == 0) {
			jt.update(
					"insert into airsys_flight(fnumber,season_discount,first_class_remain_seats,business_class_remain_seats,economy_class_remain_seats) values(?,?,?,?,?)",
					new Object[] { flight.getFnumber(), flight.getDiscount(), flight.getFirstClassRemainSeats(),
							flight.getBusinessClassRemainSeats(), flight.getEconomyClassRemainSeats() });
		} else {
			jt.update(
					"update airsys_flight set season_discount=?,first_class_remain_seats=?,business_class_remain_seats=?,economy_class_remain_seats=? where fnumber=?",
					new Object[] { flight.getDiscount(), flight.getFirstClassRemainSeats(),
							flight.getBusinessClassRemainSeats(), flight.getEconomyClassRemainSeats() },flight.getFnumber());
		}
	}

	@Override
	public List<Flight> findByid(String fnumber) {
		return jt.query("select * from airsys_flight where fnumber=?", new Object[] { fnumber },
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}

}
