package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.UserSelect;
import entity.UserSelectAll;
import service.prototy.IAirsysService;

@Controller
@RequestMapping("/user")
public class AirsysController {
	@Autowired
	private IAirsysService airService;
	
	
	@RequestMapping("/airsys")
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("/user/airsys");
		return mv;
	}
	
	@RequestMapping("/airsys/users")
	@ResponseBody
	public ModelAndView queryUsers( String fromCity,String toCity,String start,String aa) {
		System.out.println(start);
		System.out.println(toCity);
		System.out.println(fromCity);
		List<UserSelect> usts = airService.searchFlight(start, fromCity, toCity);
		for (UserSelect userSelect : usts) {
			System.out.println(userSelect);
		}
		ModelAndView mv = new ModelAndView("/user/flightInfo");
		mv.addObject("usts",usts);
		return mv;
	}
	
	@RequestMapping("/airsys/userbuff")
	@ResponseBody
	public ModelAndView queryflightBuff(String fnumber,String startDate) {
		System.out.println(fnumber);
		System.out.println(startDate);

		List<UserSelectAll> usts = airService.searchFlightBuff(fnumber, startDate);
		for (UserSelectAll userSelect : usts) {
			System.out.println(userSelect);
		}
		ModelAndView mv = new ModelAndView("/user/flightStatus");
		mv.addObject("usts",usts);
		return mv;
	}
	
	
	
}
