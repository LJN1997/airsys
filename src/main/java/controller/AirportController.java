package controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Airport;
import entity.Place;
import service.prototy.IAirportService;

@Controller
@RequestMapping("/air")
public class AirportController {
	@Autowired
	private IAirportService airService;

	
	
	
	@RequestMapping("/airinfo")
	public ModelAndView getAirport() {
		ModelAndView mv = new ModelAndView("main/main");
		List<Airport> air = airService.findAll();
		mv.addObject("air", air);
		return mv;
	}

	@RequestMapping("/userinfo")
	public ModelAndView getAirinfo() {
		ModelAndView mv = new ModelAndView("main/information");
		List<Airport> airport = airService.listAirport(1, 5);
		mv.addObject("air", airport);
		return mv;
	}

	@RequestMapping("/userpwd")
	public ModelAndView Password() {
		ModelAndView mv = new ModelAndView("main/updatePassword");
		List<Airport> airport = airService.listAirport(1, 5);
		mv.addObject(airport);
		return mv;
	}

	@RequestMapping("/delete/{airportNumber}")
	public ModelAndView delete(@PathVariable("airportNumber") String id) {
		ModelAndView mv = new ModelAndView();
		airService.AirDelete(id);
		mv.setViewName("redirect:/air/airinfo");
		return mv;
	}

	@RequestMapping("/update/{airportNumber}")
	public ModelAndView update(@PathVariable("airportNumber") String id) {
		ModelAndView mv = new ModelAndView("main/airupdate");
		List<Airport> find = airService.find(id);
		// mv.setViewName("redirect:/air/airinfo");
		mv.addObject("info", find);
		return mv;
	}

	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ModelAndView data(String number, String name, String city) {
		ModelAndView mv = new ModelAndView();
		airService.AirSaveorUpdate(new Airport(number, name, city));
		mv.setViewName("redirect:/air/airinfo");
		return mv;
	}

	@RequestMapping("/back")
	public ModelAndView back() {
		ModelAndView mv = new ModelAndView("main/main");
		// airService.AirSaveorUpdate(new Airport(id,name,city));
		return mv;
	}
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("main/add");
		return mv;
	}
	@RequestMapping(value = "/adds", method = RequestMethod.POST)
	public ModelAndView adds(String number, String name, String city) {
		ModelAndView mv = new ModelAndView();
		airService.AirSaveorUpdate(new Airport(number,name,city));
		mv.setViewName("redirect:/air/airinfo");
		return mv;
	}

}