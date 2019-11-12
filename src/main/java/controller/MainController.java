package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Airport;
import service.prototy.IAirportService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Autowired
	private IAirportService airService;

	@RequestMapping("/index")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("main/login");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("main/login");
		List<Airport> airport = airService.listAirport(1, 5);
		mv.addObject(airport);
		return mv;
	}

	@RequestMapping("/resign")
	public ModelAndView resigon() {
		ModelAndView mv = new ModelAndView("main/resign");
		List<Airport> airport = airService.listAirport(1, 5);
		mv.addObject(airport);
		return mv;
	}
	@RequestMapping("/pwd")
	public ModelAndView pasword() {
		ModelAndView mv = new ModelAndView("main/Password");
		List<Airport> airport = airService.listAirport(1, 5);
		mv.addObject(airport);
		return mv;
	}
}