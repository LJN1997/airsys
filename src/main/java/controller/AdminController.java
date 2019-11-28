package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.User;
import service.prototy.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	public ModelAndView ipdatewPwd(String pwd1,String pwd2,int aid) {
		if(pwd1.equals(pwd2)) {
			ModelAndView mv = new ModelAndView("main/login");
			adminService.updatePwd(pwd1,aid);
			mv.setViewName("redirect:http://localhost:8080/airsys/login/log");
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("main/updatePassword");
			return mv;
		}
		
	}

}
