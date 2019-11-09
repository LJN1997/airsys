package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.UserSelect;
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
	public ModelAndView queryUsers( String from_city,String to_city,String start,String aa) {
		System.out.println(start);
		System.out.println(to_city);
		System.out.println(from_city);
		List<UserSelect> usts = airService.searchFlight(start, from_city, to_city);
		for (UserSelect userSelect : usts) {
			System.out.println(userSelect);
		}
		ModelAndView mv = new ModelAndView("/user/flightInfo");
		mv.addObject("usts",usts);
		return mv;
	}
	
	
}
