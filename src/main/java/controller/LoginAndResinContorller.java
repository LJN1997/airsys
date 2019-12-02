package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Admin;
import entity.PlaceAdmin;
import entity.Sales;
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
	
	@RequestMapping("login1")
	public ModelAndView log() {
		ModelAndView mv = new ModelAndView("main/login");
		return mv;
	}
	@RequestMapping("/index")
	public ModelAndView getindex() {
		ModelAndView mv = new ModelAndView("main/show");
		return mv;
	}


	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public ModelAndView login(String name, String password, int role,HttpSession session) {

		if (role == 1) {
			int num = adminService.find(name, password);
			if (num > 0) {
				session.setAttribute("name", name);
				session.setAttribute("password", password);
				ModelAndView mv = new ModelAndView("/main/index");
				Admin admin = adminService.find(name);
				mv.addObject("admin", admin);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("/main/login");
				return mv;
			}
		} else if (role == 2) {
			int num = saleService.login(name, password);
			if (num > 0 ) {
				int sid = saleService.findSid(name, password);
				session.setAttribute("name", name);
				session.setAttribute("password", password);
				session.setAttribute("sid", sid);
				Sales login1 = saleService.login1(name, password);
				ModelAndView mv = new ModelAndView("/sales/index");
                mv.addObject("saleInfo",login1);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("/main/login");
				return mv;
			}

		} else {
			int num = paService.placeAdminLogin(name, password);
			if(num>0) {
				ModelAndView mv = new ModelAndView("/placeadmin/index");
				PlaceAdmin placeAdmin = paService.findPlaceAdmin(name);
				String panumber = placeAdmin.getPanumber();
				session.setAttribute("name", name);
				session.setAttribute("password", password);
				mv.addObject("placeAdmin",placeAdmin);
				return mv;
			}
			return null;
		}
	}
}
	
	
	