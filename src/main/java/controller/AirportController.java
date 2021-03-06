package controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.prototy.IAdminDao;
import entity.Admin;
import entity.Airport;
import entity.Place;
import service.prototy.IAdminService;
import service.prototy.IAirportService;

@Controller
@RequestMapping("/air")
public class AirportController {
	@Autowired
	private IAirportService airService;
	@Autowired
	private IAdminService adminService;

	@RequestMapping("/airinfo")
	public ModelAndView getAirport() {
		ModelAndView mv = new ModelAndView("main/main");
		List<Airport> air = airService.findAll();
		mv.addObject("air", air);
		return mv;
	}

/*	@RequestMapping("/userinfo/{name}")
	public ModelAndView getAirinfo(@PathVariable("name")String name) {
		ModelAndView mv = new ModelAndView("main/information");
		Admin find = adminService.find(name);
		mv.addObject("admin", find);
		return mv;
	}
*/
	@RequestMapping("/userpwd/{aid}")
	public ModelAndView Password(@PathVariable("aid") int aid) {
		ModelAndView mv = new ModelAndView("main/updatePassword");
		Admin admin = adminService.findByAid(aid);
		mv.addObject("admin",admin);
		
		return mv;
	}

	@RequestMapping("/delete/{airportNumber}")
	public ModelAndView delete(@PathVariable("airportNumber") String id) {
		ModelAndView mv = new ModelAndView();
		airService.AirDelete(id);
		mv.setViewName("redirect:/air/airinfo");
		return mv;
	}

/*	@RequestMapping("/update/{airportNumber}")
	public ModelAndView update(@PathVariable("airportNumber") String id) {
		ModelAndView mv = new ModelAndView("main/airupdate");
		List<Airport> find = airService.find(id);
		// mv.setViewName("redirect:/air/airinfo");
		mv.addObject("info", find);
		return mv;
	}*/

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
		mv.setViewName("redirect:/air/airinfo");
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