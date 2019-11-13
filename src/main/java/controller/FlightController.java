package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.prototy.ISelectService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private ISelectService selectService;
	
	@RequestMapping("/flightinfo")
	public ModelAndView find() {
		
		return null;
	}
	
}
