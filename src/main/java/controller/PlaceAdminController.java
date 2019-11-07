package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.Sales;
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
	
	//-- 分页查询营业员
	@RequestMapping("/sales/{pid}")
	public ModelAndView  getSales(@PathVariable("pid") int pid) {
		ModelAndView mv = new ModelAndView("/placeadmin/list");
		Pager<Sales> slistPager = pas.SlistPager(pid, 2, 5);
		List<Sales> data = slistPager.getData();
		int pageNum = slistPager.getPageNum();
		
		List<Sales> sales = pas.SlistPaged(pid, 1, 5);
		mv.addObject("sales", sales);
		mv.addObject("data",data);	
		mv.addObject("pageNum", pageNum);	
		return mv;
	}
	
	@RequestMapping("/sale/{snumber}")
	@ResponseBody
	public String getSale(@PathVariable("snumber") String snumber) {
		Sales sales = pas.querry(snumber);
		return JSON.toJSONString(sales);
	}
	

}
