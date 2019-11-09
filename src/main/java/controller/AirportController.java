package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping("/delete/{airport_number}")
	@ResponseBody
	public String delete(@PathVariable("airport_number")String id) {
		ModelAndView mv = new ModelAndView();
		int result = airService.AirDelete(id);
		if(result>0) {
			return "success";
		}else {
			return "false";
		}
	}
	
}