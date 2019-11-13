package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView add2( String snumber,String sname,String spwd,String sphone,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();

		Sales sales = new Sales();
		//int pid =Integer.parseInt(req.getParameter("pid"));
		sales.setPid(2);
		sales.setSnumber(snumber);
		sales.setSname(sname);
		sales.setSpwd(spwd);
		sales.setSphone(sphone);;
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
		List<SalesTicket> findTicket = pas.findTicket(tid);
		mv.addObject("findTicket",findTicket);
		return mv;
	}
	
	@RequestMapping("/saleticket")
	public ModelAndView  saleticket() {	
		ModelAndView mv = new ModelAndView("redirect:/placeadmin/ticketinfo");
		return mv;
	}

	//--模糊查询营业员
	@RequestMapping(value="/searchs" ,method=RequestMethod.POST)
	public ModelAndView  likeSales(String keys) {	
		ModelAndView mv = new ModelAndView("/placeadmin/likesales");
		List<Sales> likeQuerry = pas.likeQuerry(keys);
		mv.addObject("likeQuerry",likeQuerry);
		return mv;
	}
	@RequestMapping("/ret")
	public ModelAndView  ret() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/placeadmin/sales");	
		return mv;
	}
	
	//-- 模糊查询售票记录

		@RequestMapping(value="/searcht" ,method=RequestMethod.POST)
		public ModelAndView  likeTicket(String keys) {	
			ModelAndView mv = new ModelAndView("/placeadmin/liketicketinfo");
			 List<SalesTicket> likeTicket = pas.likeTicket(keys);
			mv.addObject("likeTicket",likeTicket);
			return mv;
		}
		@RequestMapping("/ret2")
		public ModelAndView  ret2() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/placeadmin/ticketinfo");	
			return mv;
		}
 
}
