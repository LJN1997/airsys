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

import entity.PlaceAdmin;
import entity.Sales;
import entity.SalesTicket;
import service.prototy.PlaceAdminService;
import util.Pager;

/**
 * 营业点管理员Conteoller类
 * @author Administrator
 */
@Controller
@RequestMapping("/placeadmin")
public class PlaceAdminController {
	@Autowired 
	private PlaceAdminService pas;
	
/*	//-- 主界面
	@RequestMapping("/index")
	public ModelAndView  index() {	
		ModelAndView mv = new ModelAndView("/placeadmin/index");
		return mv;
	}	*/
	
	//--检查
	@RequestMapping("/check")
	public ModelAndView  check() {	
		ModelAndView mv = new ModelAndView("/main/check");
		return mv;
	}	
	//--检查
	@RequestMapping("/exit")
	public ModelAndView  exit() {	
		ModelAndView mv = new ModelAndView("/main/exit");
		return mv;
	}	
	//-- 分页查询营业员
	@RequestMapping("/sales/{pid}")
	public ModelAndView  getSales(@PathVariable("pid")int pid,HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView("/placeadmin/sales");
		Pager<Sales> slistPager = pas.SlistPager(pid, 1, 5);
		int pageNum = slistPager.getPageNum();
		List<Sales> data = slistPager.getData();
		mv.addObject("data", data);
		mv.addObject("pageNum", pageNum);	
		mv.addObject("pid",pid);
		return mv;
	}
	
	//-- 添加营业员
	@RequestMapping("/add/{pid}")
	public ModelAndView  add(@PathVariable("pid") int pid,HttpServletRequest req) {	
		ModelAndView mv = new ModelAndView("/placeadmin/add");
		System.out.println(pid);
		mv.addObject("pid",pid);
		return mv;
	}	
	@RequestMapping(value="/add2",method=RequestMethod.POST)
	public ModelAndView add2( int pid,String snumber,String sname,String spwd,String sphone,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Sales sales = new Sales();
		sales.setPid(pid);
		sales.setSnumber(snumber);
		sales.setSname(sname);
		sales.setSpwd(spwd);
		sales.setSphone(sphone);;
		pas.saveOrUpdate(sales);	 
		mv.setViewName("redirect:/placeadmin/sales/"+pid+"");	
		return mv;
	}
	
	//-- 删除营业员
	@RequestMapping("/delete/{sid}/{pid}")
	public ModelAndView  delete(@PathVariable("sid") int sid ,@PathVariable("pid")int pid) {
		ModelAndView mv = new ModelAndView();
		pas.delete(sid);
		mv.setViewName("redirect:/placeadmin/sales/"+pid+"");	
		return mv;
	}
	
	//-- 营业员售票记录界面
	@RequestMapping("/ticketinfo/{pid}")
	public ModelAndView ticket(@PathVariable("pid") int pid) {	
		ModelAndView mv = new ModelAndView("/placeadmin/ticketinfo");
		Pager<SalesTicket> tlistPager = pas.TlistPager(pid, 1, 5);
		List<SalesTicket> data = tlistPager.getData();
		int pageNum = tlistPager.getPageNum();
		mv.addObject("data", data);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pid",pid);
		return mv;
	}
	
	//-- 查看营业员售票记录详细信息界面
	@RequestMapping("/view/{tid}/{pid}")
	public ModelAndView ticketinfo(@PathVariable("tid") int tid,@PathVariable("pid") int pid) {	
		ModelAndView mv = new ModelAndView("/placeadmin/view");
		List<SalesTicket> findTicket = pas.findTicket(tid);
		mv.addObject("findTicket",findTicket);
		mv.addObject("pid",pid);
		return mv;
	}	
	@RequestMapping("/saleticket/{pid}")
	public ModelAndView  saleticket(@PathVariable("pid")int pid) {	
		ModelAndView mv = new ModelAndView("redirect:/placeadmin/ticketinfo/"+pid+"");
		return mv;
	}

	//--模糊查询营业员
	@RequestMapping(value="/searchs" ,method=RequestMethod.POST)
	public ModelAndView  likeSales(int pid,String keys) {	
		ModelAndView mv = new ModelAndView("/placeadmin/likesales");
		List<Sales> likeQuerry = pas.likeQuerry(keys);
		mv.addObject("likeQuerry",likeQuerry);
		mv.addObject("pid",pid);
		return mv;
	}
	@RequestMapping("/ret")
	public ModelAndView  ret(int pid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/placeadmin/sales/"+pid+"");	
		return mv;
	}
	
	//-- 模糊查询售票记录

		@RequestMapping(value="/searcht" ,method=RequestMethod.POST)
	public ModelAndView  likeTicket(String keys,int pid) {	
		ModelAndView mv = new ModelAndView("/placeadmin/liketicketinfo");
		 List<SalesTicket> likeTicket = pas.likeTicket(keys);
		mv.addObject("likeTicket",likeTicket);
		mv.addObject("pid",pid);
		return mv;
	}
	@RequestMapping("/ret2")
	public ModelAndView  ret2(int pid) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/placeadmin/ticketinfo/"+pid+"");	
			return mv;
		}
 
	//-- 个人信息设置
	@RequestMapping("/selfinfo/{panumber}")
	public ModelAndView selfInfo(@PathVariable("panumber")String panumber) {
		ModelAndView mv = new ModelAndView("/placeadmin/selfinfo");
		PlaceAdmin findPlaceAdmin = pas.findPlaceAdmin(panumber);
		mv.addObject("findPlaceAdmin",findPlaceAdmin);
		return mv;	
	}
	
	@RequestMapping("/updatepwd/{paid}/{panumber}")
	public ModelAndView updatePwd(@PathVariable("paid")int paid,@PathVariable("panumber")String panumber) {
		ModelAndView mv = new ModelAndView("/placeadmin/updatepwd");
		mv.addObject("paid",paid);
		return mv;	
	}
	@RequestMapping(value="/updatepwd2",method=RequestMethod.POST)
	public ModelAndView updatePwd2(int paid,String papwd,String papwd1) {
		System.out.println(paid);
		System.out.println(papwd);
		System.out.println(papwd1);
		ModelAndView mv = new ModelAndView();

		if(papwd.equals(papwd1)) {
			pas.updatepwd(paid, papwd);
			mv.addObject("paid",paid);
			mv.setViewName("redirect:/main/index");
			return mv;
		}else {
			mv.addObject("paid",paid);
			mv.setViewName("/placeadmin/updatepwd");
			return mv;
		}
	}
	
	//--查询该营业点所有营业员
	@RequestMapping(value="/aa",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String test() {
		List<Sales> findAll = pas.findAll(2);
		String jsonString = JSON.toJSONString(findAll);
		return jsonString;		
	}
	
	@RequestMapping("/test")
	public String test1() {
		return "/placeadmin/test";
	}
	
}
