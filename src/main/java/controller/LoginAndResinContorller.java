package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Admin;
import entity.PlaceAdmin;
import service.prototy.IAdminService;
import service.prototy.ISalesService;
import service.prototy.PlaceAdminService;

@Controller
@RequestMapping("/login")
public class LoginAndResinContorller {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private ISalesService saleService;
	@Autowired
	private PlaceAdminService paService;
	
/*	@RequestMapping("log")
	public ModelAndView log() {
		ModelAndView mv = new ModelAndView("main/login");
		return mv;
	}
	
	@RequestMapping("log1")
	public String login(String number,String password,HttpServletRequest req) {
		if(StringUtils.isEmpty(number) ||StringUtils.isEmpty(password)) {
			req.setAttribute("error", "用户名或密码为空");
			return "redirect:/login/log";
		}
		
	}
*/
	
	
	
	
	
	
	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public ModelAndView login(String name, String password, int role,HttpSession session) {

		if (role == 1) {
			int num = adminService.find(name, password);
			if (num > 0) {
				ModelAndView mv = new ModelAndView("main/index");
				List<Admin> admin = adminService.find(name);
				mv.addObject("admin", admin);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("main/login");
				return mv;
			}
		} else if (role == 2) {
			int num = saleService.login(name, password);
			if (num > 0) {
				ModelAndView mv = new ModelAndView("sales/index");

				return mv;
			} else {
				ModelAndView mv = new ModelAndView("main/login");
				return mv;
			}

		} else {
			int num = paService.placeAdminLogin(name, password);
			if(num>0) {
				ModelAndView mv = new ModelAndView("placeadmin/index");
				PlaceAdmin placeAdmin = paService.findPlaceAdmin(name);
				String panumber = placeAdmin.getPanumber();
				int pid = placeAdmin.getPid();
				int paid = placeAdmin.getPaid();
				String paname = placeAdmin.getPaname();
				String papwd = placeAdmin.getPapwd();
				session.setAttribute("panumber", panumber);
				session.setAttribute("pid", pid);
				session.setAttribute("paid", paid);
				session.setAttribute("paname", paname);
				session.setAttribute("papwd", papwd);
				return mv;
			}
			return null;
		}

	}

}
	
	
	
	
	

