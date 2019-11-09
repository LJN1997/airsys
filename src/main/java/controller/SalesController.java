package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Info;
import service.prototy.ISalesService;

/**
* 
*   营业员管理Controller类
* @author DanyangLi
*/
@Controller 
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	private ISalesService salesService;
	
	@RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request,HttpServletResponse response){
		String route = request.getParameter("route");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endTime");
		
		
		
		
		
		
		ModelAndView mv = new ModelAndView("/sales/querycon");
    	List<Info> info1 =salesService.select(from, to, startTime) ;
    	mv.addObject("info", info1);
    		return mv;
    	
    
      /* ModelAndView mv = new ModelAndView("/sales/querycon");
    	List<Info> info =salesService.select("xa", "sx", "2019-11-05") ;
    	mv.addObject("info", info);
    	return mv;*/
    }
	
	@RequestMapping("/user")
				@ResponseBody
			public String  getUser(){
						return "hello";
			}
    
    @RequestMapping("/index")
    public ModelAndView getUsers(){
    	
    	ModelAndView mv = new ModelAndView("/sales/index");
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
