package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
* 
*   营业员管理Controller类
* @author DanyangLi
*/
@Controller 
@RequestMapping("/sales")
public class SalasController {
	@RequestMapping("/user")
	@ResponseBody
public String  getUser(){
			return "hello";
}
    
    @RequestMapping("/users")
    public ModelAndView getUsers(){
    	
    	ModelAndView mv = new ModelAndView("/sales/sales");
    	return mv;
    }
    
    @RequestMapping("/user1")
    public ModelAndView getUsers1(){
    	
    	ModelAndView mv = new ModelAndView("/sales/query");
    	return mv;
    }
    @RequestMapping("/user2")
    public ModelAndView getUsers2(){
    	
    	ModelAndView mv = new ModelAndView("/sales/add");
    	return mv;
    }
    @RequestMapping("/user3")
    public ModelAndView getUsers3(){
    	
    	ModelAndView mv = new ModelAndView("/sales/delete");
    	return mv;
    }
    @RequestMapping("/user4")
    public ModelAndView getUsers4(){
    	
    	ModelAndView mv = new ModelAndView("/sales/change");
    	return mv;
    }
    @RequestMapping("/user5")
    public ModelAndView getUsers5(){
    	
    	ModelAndView mv = new ModelAndView("/sales/history");
    	return mv;
    }
    @RequestMapping("/user6")
    public ModelAndView getUsers6(){
    	
    	ModelAndView mv = new ModelAndView("/sales/selfinfo");
    	return mv;
    }
}
