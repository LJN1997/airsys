package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.User;
import service.prototy.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/userinfo")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("usershow/main");
		List<User> user = userService.findAll();
		mv.addObject("user",user);
		return mv;
	}
	@RequestMapping("/delete/{uid}")
	public ModelAndView delete(@PathVariable("uid") int id) {
		ModelAndView mv = new ModelAndView();
		userService.delete(id);
		mv.setViewName("redirect:/user/userinfo");
		return mv;
	}
}
