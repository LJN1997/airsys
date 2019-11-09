package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Airport;
import service.prototy.IAirportService;
import util.Pager;

@Controller
@RequestMapping("/air")
public class AirportController {
	@Autowired
	private IAirportService airService;

	@RequestMapping("/airinfo")
	public ModelAndView getAirport() {
		ModelAndView mv = new ModelAndView("main/main");
		List<Airport> air =  airService.listAirport(1, 8);
		mv.addObject("air",air);
		return mv;
	}

	@RequestMapping("/userinfo")
	public ModelAndView getAirinfo() {
		ModelAndView mv = new ModelAndView("main/information");
		List<Airport> airport = airService.listAirport(1, 5);
		mv.addObject("air",airport);
		return mv;
	}
	@RequestMapping("/userpwd")
	public ModelAndView Password() {
		ModelAndView mv = new ModelAndView("main/updatePassword");
		List<Airport> airport = airService.listAirport(1, 5);
		mv.addObject(airport);
		return mv;
	}
}