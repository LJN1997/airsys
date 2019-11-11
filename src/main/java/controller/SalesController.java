package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.Info;
import entity.Sales;
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
	
	//查询个人信息
	 @RequestMapping("/saleinfo/{sid}")
	 @ResponseBody
		public ModelAndView  getUser1(@PathVariable("sid") int sid){
			  ModelAndView mv = new ModelAndView("/sales/selfinfo");
			  String sale = JSON.toJSONString(salesService.saleinfo(1));
			  mv.addObject("sale", sale);
			  return mv;
		}
 
	
	
	//管理员登录
	@RequestMapping("/login")
    public ModelAndView login(){
    	
    	ModelAndView mv = new ModelAndView("/sales/login");
    	return mv;
    }
	
	@RequestMapping("/loginCon")
    public ModelAndView loginCon(HttpServletRequest request,HttpServletResponse response){
    	
		String num = request.getParameter("num");
		String pwd = request.getParameter("pwd");
      if(num.equals("111" ) && pwd.equals("111")){
    	  ModelAndView mv = new ModelAndView("/sales/index");
      	  return mv;
      }
      ModelAndView mv1 = new ModelAndView("/sales/login");
  	  return mv1;
	      
    }
	@RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request,HttpServletResponse response){
		String route = request.getParameter("route");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endTime");
		ModelAndView mv = new ModelAndView("/sales/querycon");
    	List<Info> info =salesService.select(from, to, startTime) ;
    	mv.addObject("info", info);
    		return mv;
    }
	

    
    @RequestMapping("/index")
    public ModelAndView getUsers(){
    	
    	ModelAndView mv = new ModelAndView("/sales/login");
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

    
   
    
}
