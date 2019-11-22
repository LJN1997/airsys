package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.Info;
import entity.Order;
import entity.Sales;
import entity.Ticket;
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
	
	//6、退票
	//HttpServletRequest request,HttpServletResponse response
	/*@RequestMapping(value="/selectOid"  ,method = RequestMethod.POST,   produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String  selectOid(@RequestBody Map<String,Object> map){
		String oname = (String)map.get("oname");
		String idcard = (String)map.get("idcard");
		System.out.println(oname);
		System.out.println(idcard);
    	List<Ticket> t =salesService.findBy(oname, idcard);
    	System.out.println(t);
    	String a =  JSON.toJSONString(t);
    	return a;
    }*/
	@RequestMapping(value="/selectOid"  ,method = RequestMethod.POST,   produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String  selectOid(HttpServletRequest request){
		String oname = request.getParameter("oname");
		String idcard = request.getParameter("idcard");
    	List<Ticket> t =salesService.findBy(oname, idcard);
    	String a =  JSON.toJSONString(t);
    	return a;
    }
	
	//退票成功 座位增加一个 票表里面的状态改为0
	@RequestMapping(value="/delTicket"  ,method = RequestMethod.POST,   produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String  delTicket(HttpServletRequest request){
		int tid = Integer.parseInt(request.getParameter("tid"));
		System.out.println(tid);
		String fnumber = request.getParameter("fnumber");
		String seat = request.getParameter("tclass");
		String tclass = "";
		if(seat.equals("商务舱")){
			 tclass = "business_class_remain_seats";
		}else if(seat.equals("头等舱")){
			 tclass = "first_class_remain_seats";
		}else if(seat.equals("经济舱")){
			 tclass = "economy_class_remain_seats";
		}	
		salesService.addFightSeat(fnumber, tclass);
		salesService.updateTicketStatus(tid);
    	return "ok";
    }
	
	
	
	
	
	//1、机票查询  request 获取输入的出发地、目的地、出发时间
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
	//2、查到对应的票务信息后点击预订携带参数跳转到reserve
		 //然后将参数信息存起来，add.jsp能获取到这些参数
	    @RequestMapping("/reserve/{from}/{to}/{time}/{time2}/{price}/{fnumber}/{planId}")
	    public ModelAndView getUsers2(@PathVariable("from")String from,@PathVariable("to")String to,@PathVariable("time")String time,@PathVariable("time2")String time2,@PathVariable("price")double price,@PathVariable("fnumber")String fnumber,@PathVariable("planId")int planId){
	    	System.out.println(planId);
	    	ModelAndView mv = new ModelAndView("/sales/add");
	    	String starttime =  time.replaceAll("\\s*|\t|\r|\n", "");
	    	String endtime = time2.replaceAll("\\s*|\t|\r|\n", "");
	    	mv.addObject("fnumber", fnumber);
	    	mv.addObject("from", from);
	    	mv.addObject("to", to);
	    	mv.addObject("time", starttime);
	    	mv.addObject("time2", endtime);
	    	mv.addObject("price", price);
	    	mv.addObject("planId", planId);
	    	return mv;
	    }
	
	  //3、机票购买  获取add.jsp中的参数  执行买票的三个方法
		@RequestMapping("/buy")
		public ModelAndView buy(HttpServletRequest request){		
			int planId =  Integer.parseInt(request.getParameter("planId"));
			String  fnumber =request.getParameter("fnumber");
			String  people =request.getParameter("people");
			String  seat =request.getParameter("grade");
			String  name =request.getParameter("name");
			String  phone =request.getParameter("phone");
			String  idcard =request.getParameter("idcard");
			String expStartTime = request.getParameter("starttime");
			int sid = Integer.parseInt(request.getParameter("sid"));
			double  price =Double.parseDouble(request.getParameter("price"));	
			String tclass = "";
			if(seat.equals("business_class_remain_seats")){
				 tclass = "商务舱";
			}else if(seat.equals("first_class_remain_seats")){
				 tclass = "头等舱";
			}else if(seat.equals("economy_class_remain_seats")){
				 tclass = "经济舱";
			}	
			salesService.addTicket(new Ticket(planId,0,sid,tclass,people,price,1,idcard));
			salesService.addOrder(new Order(sid,0,idcard,phone,name));
			salesService.updateFightSeat(fnumber, seat);
			ModelAndView mv = new ModelAndView("/sales/successbuy");
			 return mv;
		}
	
	
		//4、退票
		  @RequestMapping("/quitTicket")
		    public ModelAndView quitTicket(){
		    	ModelAndView mv = new ModelAndView("/sales/delete");
		    	return mv;
		    }

	//营业员登录
		@RequestMapping("/loginCon")
	    public ModelAndView loginCon(HttpServletRequest request,HttpServletResponse response){
			String num = request.getParameter("num");
			String pwd = request.getParameter("pwd");
	     
		/*	List<Sales> login1 = salesService.login1(num, pwd);
			ModelAndView mv = new ModelAndView("/sales/index");
			  return mv;*/
			  
			int sale= salesService.login(num, pwd);
			int sid= salesService.findSid(num, pwd);
			if(sale>0){
				List<Sales> saleInfo = salesService.saleinfo(num);
				ModelAndView mv = new ModelAndView("/sales/index");
				HttpSession session = request.getSession(true);
				session.setAttribute("sid", sid);
				mv.addObject("saleInfo", saleInfo);
			  	  return mv;
			}else{
				ModelAndView mv = new ModelAndView("/sales/login");
			  	  return mv;
			}
	    }
	
	//查询个人信息
	 @RequestMapping("/saleinfo/{num}")
	 @ResponseBody
		public ModelAndView  getUser1(@PathVariable("num") String num){
			  ModelAndView mv = new ModelAndView("/sales/selfinfo");
			//  String sale = JSON.toJSONString(salesService.saleinfo(1));
			  List<Sales> sale = salesService.saleinfo(num);
			  mv.addObject("sale", sale);
			  return mv;
		}
	 
	 //查询历史记录
	 @RequestMapping("/history/{num}")
	    public ModelAndView history(@PathVariable("num") String num){
	    	ModelAndView mv = new ModelAndView("/sales/history");
	    	List<Ticket> history =salesService.history(num) ;
	    	mv.addObject("history", history);
	    	return mv;
	    }

	
	//营业员登录
	@RequestMapping("/login")
    public ModelAndView login(){
    	
    	ModelAndView mv = new ModelAndView("/sales/login");
    	return mv;
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
