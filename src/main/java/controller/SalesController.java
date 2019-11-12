package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import dao.impl.SalesDaoImpl;
import entity.Info;
import entity.Sales;
import entity.Ticket;
import service.impl.SalesServiceImpl;
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
			//  String sale = JSON.toJSONString(salesService.saleinfo(1));
			  List<Sales> sale = salesService.saleinfo(sid);
			  mv.addObject("sale", sale);
			  return mv;
		}
	 
	 //查询历史记录
	 @RequestMapping("/history/{cid}")
	    public ModelAndView history(@PathVariable("cid") int cid){
	    	ModelAndView mv = new ModelAndView("/sales/history");
	    	List<Ticket> history =salesService.history(cid) ;
	    	mv.addObject("history", history);
	    	return mv;
	    }

	
	//管理员登录
	@RequestMapping("/login")
    public ModelAndView login(){
    	
    	ModelAndView mv = new ModelAndView("/sales/login");
    	return mv;
    }
	
    @RequestMapping("/index")
    public ModelAndView getUsers(){
    	
    	ModelAndView mv = new ModelAndView("/sales/login");
    	return mv;
    }
    
	@RequestMapping("/loginCon")
    public ModelAndView loginCon(HttpServletRequest request,HttpServletResponse response){
		String num = request.getParameter("num");
		String pwd = request.getParameter("pwd");
     
		int sale= salesService.login(num, pwd);
		if(sale>0){
			ModelAndView mv = new ModelAndView("/sales/index");
		  	  return mv;
		}else{
			ModelAndView mv = new ModelAndView("/sales/login");
		  	  return mv;
		}
    }
	
	//机票查询
	@RequestMapping("/query")
    public ModelAndView query(HttpServletRequest request,HttpServletResponse response){
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String startTime = request.getParameter("starttime");
		ModelAndView mv = new ModelAndView("/sales/querycon");
    	List<Info> info =salesService.select(from, to, startTime) ;
    	mv.addObject("info", info);
    		return mv;
    }

	//机票购买
	@RequestMapping(value="/buy")
	public ModelAndView buy(HttpServletRequest request){
		String  fnumber =request.getParameter("fnumber");
		String  grade =request.getParameter("grade");
		String  people =request.getParameter("people");
		double  price =Double.parseDouble(request.getParameter("price"));
		String tclass = "";
		if(grade.equals("business_class_remain_seats")){
			 tclass = "商务舱";
		}else if(grade.equals("first_class_remain_seats")){
			 tclass = "头等舱";
		}else if(grade.equals("economy_class_remain_seats")){
			 tclass = "经济舱";
		}
		salesService.buy(new Ticket(tclass,people,price), fnumber, grade);
		ModelAndView mv = new ModelAndView("/sales/successbuy");
		 return mv;
	}

    @RequestMapping("/user1")
    public ModelAndView getUsers1(){
    	
    	ModelAndView mv = new ModelAndView("/sales/query");
    	return mv;
    }
    @RequestMapping("/user2/{from}/{to}/{time}/{time2}/{price}/{fnumber}")
    public ModelAndView getUsers2(@PathVariable("from")String from,@PathVariable("to")String to,@PathVariable("time")String time,@PathVariable("time2")String time2,@PathVariable("price")double price,@PathVariable("fnumber")String fnumber){
    	
    	ModelAndView mv = new ModelAndView("/sales/add");
    	String starttime =  time.replaceAll("\\s*|\t|\r|\n", "");
    	String endtime = time2.replaceAll("\\s*|\t|\r|\n", "");
    	mv.addObject("fnumber", fnumber);
    	mv.addObject("from", from);
    	mv.addObject("to", to);
    	mv.addObject("time", starttime);
    	mv.addObject("time2", endtime);
    	mv.addObject("price", price);
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
   
    @RequestMapping("/successbuy")
    public ModelAndView successBuy(){
    	
    	ModelAndView mv = new ModelAndView("/sales/successbuy");
    	return mv;
    }
   
    
}
