package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Info;
import service.prototy.IPlanService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private IPlanService selectService;
	
	@RequestMapping("/flightinfo")
	public ModelAndView find() {
		ModelAndView mv = new ModelAndView("Flight/main");
		//List<Info> Fight = selectService.findFight();
		//mv.addObject("flight",Fight);
		return mv;
	}

	@RequestMapping("/view/{fnumber}")
	public ModelAndView view(@PathVariable("fnumber")int fnumber) {
		ModelAndView mv = new ModelAndView("Flight/info");
		System.out.println(fnumber);
		//List<Info> Fight = selectService.findByNumber(fnumber);
		//mv.addObject("flight",Fight);
		return mv;
	}
	@RequestMapping("/back")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/flight/flightinfo");
		return mv;
		
	}
}
