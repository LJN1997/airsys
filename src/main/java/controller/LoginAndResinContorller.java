package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Admin;
import service.prototy.IAdminService;

@Controller
@RequestMapping("/login")
public class LoginAndResinContorller {

	@Autowired
	private IAdminService adminService;
	
	
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public ModelAndView login(String name,String password,int role) {
		
		if(role==1) {
			int num = adminService.find(name,password);
			if(num>0) {
				ModelAndView mv = new ModelAndView("main/index");
				List<Admin> admin = adminService.find(name);
				mv.addObject("admin",admin);
				return mv;
			}else {
				ModelAndView mv = new ModelAndView("main/login");
				return mv;
			}
		}else if(role==2) {
			
		}
		return null;
		
		
		
		
	}
}