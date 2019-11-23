package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Airport;
import entity.Flight;
import entity.Info;
import service.prototy.IFlightService;
import service.prototy.IPlanService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	private IFlightService flightService;
	
	@RequestMapping("/flightinfo")
	public ModelAndView find() {
		ModelAndView mv = new ModelAndView("Flight/main");
		List<Flight> Fight =flightService.findAll();
		mv.addObject("flight",Fight);
		return mv;
	}

	@RequestMapping("/delete/{fnumber}")
	public ModelAndView delete(@PathVariable("fnumber") String fnumber) {
		ModelAndView mv = new ModelAndView();
		flightService.delete(fnumber);
		mv.setViewName("redirect:/flight/flightinfo");
		return mv;
	}
	@RequestMapping("/update/{fnumber}")
	public ModelAndView update(@PathVariable("fnumber") String fnumber) {
		ModelAndView mv = new ModelAndView("Flight/flightupdate");
		List<Flight> findByid = flightService.findByid(fnumber);
		// mv.setViewName("redirect:/air/airinfo");
		mv.addObject("info", findByid);
		return mv;
	}

	@RequestMapping("/back")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/flight/flightinfo");
		return mv;
		
	}
}
