package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import aj.org.objectweb.asm.Type;
import entity.PlaceAdmin;
import entity.PlaceAdminCountClass;
import entity.PlaceAdminCountPassenger;
import entity.PlaceAdminCountSales;
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
	@RequestMapping(value="/sales/{pid}",method=RequestMethod.POST)
	public ModelAndView  getSales(@PathVariable("pid")int pid,HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView("/placeadmin/sales");
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+pageNo);
		Pager<Sales> slistPager = pas.SlistPager(pid, 2, 5);
		int pageNum = slistPager.getPageNum();
		List<Sales> data = slistPager.getData();
		int saleTotalItems = pas.saleTotalItems(pid);
		mv.addObject("data", data);
		mv.addObject("pageNum", pageNum);	
		mv.addObject("saleTotalItems", saleTotalItems);	
		mv.addObject("pid",pid);
		return mv;
	}

	@RequestMapping("/saless/{pid}/{pageNo}")
	public ModelAndView  getSaless(@PathVariable("pid")int pid,@PathVariable("pageNo")int pageNo) {
		ModelAndView mv = new ModelAndView("/placeadmin/sales");
		Pager<Sales> slistPager = pas.SlistPager(pid, pageNo, 5);
		int pageNum = slistPager.getPageNum();
		List<Sales> data = slistPager.getData();
		int saleTotalItems = pas.saleTotalItems(pid);
		mv.addObject("data", data);
		mv.addObject("pageNo", pageNo);	
		mv.addObject("pageNum", pageNum);	
		mv.addObject("saleTotalItems", saleTotalItems);	
		mv.addObject("pid",pid);
		return mv;
	}
	
	@RequestMapping(value="/salesss/{pid}/{pageNo}",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String  getSalesss(@PathVariable("pid")int pid,@PathVariable("pageNo")int pageNo) {
		//ModelAndView mv = new ModelAndView("/placeadmin/sales");
		Pager<Sales> slistPager = pas.SlistPager(pid, pageNo, 5);
		int pageNum = slistPager.getPageNum();
		List<Sales> data = slistPager.getData();
		int saleTotalItems = pas.saleTotalItems(pid);
		//mv.addObject("data", data);
		//mv.addObject("pageNo", pageNo);	
		//mv.addObject("pageNum", pageNum);	
		//mv.addObject("saleTotalItems", saleTotalItems);	
		//mv.addObject("pid",pid);
		return JSON.toJSONString(data);
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
		mv.setViewName("redirect:/placeadmin/saless/"+pid+"/1");	
		return mv;
	}
	
	//-- 删除营业员
	@RequestMapping("/delete/{sid}/{pid}")
	public ModelAndView  delete(@PathVariable("sid") int sid ,@PathVariable("pid")int pid) {
		ModelAndView mv = new ModelAndView();
		pas.delete(sid);
		mv.setViewName("redirect:/placeadmin/saless/"+pid+"/1");	
		return mv;
	}
	
	//-- 营业员售票记录界面
	@RequestMapping("/ticketinfo/{pid}")
	public ModelAndView ticket(@PathVariable("pid") int pid,int pageNo) {	
		ModelAndView mv = new ModelAndView("/placeadmin/ticketinfo");
		Pager<SalesTicket> tlistPager = pas.TlistPager(pid, pageNo, 5);
		List<SalesTicket> data = tlistPager.getData();
		int pageNum = tlistPager.getPageNum();
		mv.addObject("data", data);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pid",pid);
		return mv;
	}
	
	@RequestMapping("/ticketinfo1/{pid}/{pageNo}")
	public ModelAndView ticket1(@PathVariable("pid") int pid,@PathVariable("pageNo") int pageNo) {	
		ModelAndView mv = new ModelAndView("/placeadmin/ticketinfo");
		Pager<SalesTicket> tlistPager = pas.TlistPager(pid, pageNo, 5);
		List<SalesTicket> data = tlistPager.getData();
		int pageNum = tlistPager.getPageNum();
		mv.addObject("data", data);
		mv.addObject("pageNum1", pageNum);
		mv.addObject("pageNo", pageNo);
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
		ModelAndView mv = new ModelAndView("redirect:/placeadmin/ticketinfo1/"+pid+"/1");
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
		mv.setViewName("redirect:/placeadmin/saless/"+pid+"/1");	
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
			mv.setViewName("redirect:/placeadmin/ticketinfo1/"+pid+"/1");	
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
	
	
	//--统计xinxi
	@RequestMapping("/count/{panumber}")
	public ModelAndView  count(@PathVariable("panumber") String panumber) {	
		
		ModelAndView mv = new ModelAndView("/placeadmin/count");
		mv.addObject("panumber",panumber);
		return mv;
	}  
	
	@RequestMapping(value="/csums/{panumber}",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String csums(@PathVariable("panumber") String panumber) {
		List<PlaceAdminCountSales> OfSalesType = pas.countTotalPerformanceOfSalesType(panumber);
		double countTotalSales = pas.countTotalSales(panumber);
		List<PlaceAdminCountPassenger> passengerType = pas.countTotalPerformanceOfPassengerType(panumber);
		List<PlaceAdminCountClass> ofClassType = pas.countTotalPerformanceOfClassType(panumber);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("sum",countTotalSales);

		String charts="{";

		for(int i=0;i<OfSalesType.size();i++) {
			charts+='"'+OfSalesType.get(i).getSname()+'"'+":";
			charts+=OfSalesType.get(i).getTprice()+",";
		}
		charts = charts.substring(0,charts.lastIndexOf(","));
		charts+="}";
		
		String downloadJson="{";
		for(int i=0;i<passengerType.size();i++) {
			downloadJson+='"'+passengerType.get(i).getPassengerType()+'"'+":";
			downloadJson+=passengerType.get(i).getTprice()+",";
		}
		downloadJson = downloadJson.substring(0,downloadJson.lastIndexOf(","));
		downloadJson+="}";
		
		String themeJson="{";
		for(int i=0;i<ofClassType.size();i++) {
			themeJson+='"'+ofClassType.get(i).getTclass()+'"'+":";
			themeJson+=ofClassType.get(i).getTprice()+",";
		}
		themeJson = themeJson.substring(0,themeJson.lastIndexOf(","));
		themeJson+="}";
	
	/*	System.out.println(charts);
		System.out.println(downloadJson);
		System.out.println(themeJson);
*/
		map.put("charts",charts);
		map.put("downloadJson",downloadJson);
		map.put("themeJson",themeJson);
		
		return JSON.toJSONString(map);
	}
	
}
