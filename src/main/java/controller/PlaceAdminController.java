package controller;

import java.io.UnsupportedEncodingException;
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
	
	//-- 主界面
	@RequestMapping("/index")
	public ModelAndView  index() {	
		ModelAndView mv = new ModelAndView("/main/index");
		return mv;
	
	}
	

	
	//-- 分页查询营业员
	@RequestMapping("/sales")
	public ModelAndView  getSales(HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView("/placeadmin/sales");
		/*Integer pid = Integer.parseInt(req.getParameter("id"));
		Integer pageNo = Integer.parseInt(req.getParameter("pageNo"));*/
		Pager<Sales> slistPager = pas.SlistPager(2, 1, 10);
		int pageNum = slistPager.getPageNum();
		List<Sales> data = slistPager.getData();
		mv.addObject("data", data);
		mv.addObject("pageNum", pageNum);	

		return mv;
	}
	
	//-- 添加营业员
	@RequestMapping("/add/{pid}")
	public ModelAndView  add(@PathVariable("pid") int pid,HttpServletRequest req) {	
		ModelAndView mv = new ModelAndView("/placeadmin/add");
		return mv;
	
	}
	
	@RequestMapping(value="/add2",method=RequestMethod.POST)
	public ModelAndView add2( String snumber,String sname,String spwd,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		try {
			snumber = new String(snumber .getBytes("iso8859-1"),"utf-8");
			sname = new String(sname .getBytes("iso8859-1"),"utf-8");
			spwd = new String(spwd .getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(111);
		Sales sales = new Sales();
		//int pid =Integer.parseInt(req.getParameter("pid"));
		sales.setPid(2);
		sales.setSnumber(snumber);
		sales.setSname(sname);
		sales.setSpwd(spwd);
		 pas.saveOrUpdate(sales);
		 
		 mv.setViewName("redirect:/placeadmin/sales");	
		 return mv;

	}
	

	
	//-- 删除营业员
	@RequestMapping("/delete/{sid}")
	public ModelAndView  delete(@PathVariable("sid") int sid) {
		ModelAndView mv = new ModelAndView();
		pas.delete(sid);
		mv.setViewName("redirect:/placeadmin/sales");	
		return mv;
	
	}
	
	//-- 营业员售票记录界面
	@RequestMapping("/ticketinfo")
	public ModelAndView ticket() {	
		ModelAndView mv = new ModelAndView("/placeadmin/ticketinfo");
		Pager<SalesTicket> tlistPager = pas.TlistPager(2, 1, 10);
		List<SalesTicket> data = tlistPager.getData();
		int pageNum = tlistPager.getPageNum();
		mv.addObject("data", data);
		mv.addObject("pageNum", pageNum);
		return mv;
	
	}
	
	//-- 查看营业员售票记录详细信息界面
	@RequestMapping("/view/{tid}")
	public ModelAndView ticketinfo(@PathVariable("tid") int tid) {	
		ModelAndView mv = new ModelAndView("/placeadmin/view");
		return mv;
	
	}
	
	@RequestMapping("/saleticket")
	public ModelAndView  saleticket() {	
		ModelAndView mv = new ModelAndView("redirect:/placeadmin/ticketinfo");
		return mv;
	
	}
	
	@RequestMapping("/sale/{snumber}")
	@ResponseBody
	public String getSale(@PathVariable("snumber") String snumber) {
		Sales sales = pas.querry(1);
		return JSON.toJSONString(sales);
	}
	
	@RequestMapping("/user")
	public ModelAndView getUser() {
		ModelAndView mv = new ModelAndView("/placeadmin/user");
		return mv;
	}
	

 
}
