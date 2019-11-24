package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Airport;
import entity.PlanNew;
import service.prototy.IPlanService;
import util.DateUtil;

@Controller
@RequestMapping("/plan")
public class PlanController {
	@Autowired
	private IPlanService planService;

	@RequestMapping("/planinfo")
	public ModelAndView getplan() {
		ModelAndView mv = new ModelAndView("plan/main");
		List<PlanNew> findFplan = planService.findFplan();
		mv.addObject("flightplan", findFplan);
		return mv;
	}

	@RequestMapping("/update/{fnumber}")
	public ModelAndView uppdatepPlan(@PathVariable("fnumber") String fnumber) {
		ModelAndView mv = new ModelAndView("plan/planupdate");
		List<PlanNew> findByNumber = planService.findByNumber(fnumber);
		mv.addObject("planinfo", findByNumber);
		return mv;
	}

	@RequestMapping("/delete/{fnumber}")
	public ModelAndView getAirport(@PathVariable("fnumber") String fnumber) {
		ModelAndView mv = new ModelAndView();
		planService.delete(fnumber);
		mv.setViewName("redirect:/plan/planinfo");
		return mv;
	}

	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ModelAndView data(String fnumber, String fromCity, String toCity, String startdate, String enddate,
			int planId, String type) {
		ModelAndView mv = new ModelAndView();
		PlanNew p = new PlanNew();
		p.setFnumber(fnumber);
		p.setFromCity(fromCity);
		p.setToCity(toCity);
		p.setStartDate(startdate);
		p.setEndDate(enddate);
		p.setPlanId(planId);
		p.setType(type);
		planService.UpdateOrSave(p);
		mv.setViewName("redirect:/plan/planinfo");
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("plan/add");
		return mv;
	}

	@RequestMapping(value = "/adds", method = RequestMethod.POST)
	public ModelAndView adds(String fnumber, String fromCity, String tocity, String startdate, String enddate,
			String type, double tprice, int length) {
		ModelAndView mv = new ModelAndView();
		PlanNew p = new PlanNew();
		p.setFnumber(fnumber);
		p.setFromCity(fromCity);
		p.setToCity(tocity);
		p.setStartDate(startdate);
		p.setEndDate(enddate);
		p.setType(type);
		p.setTprice(tprice);
		p.setExpStartTime(DateUtil.toDate("yyyy-MM-dd", startdate));
		p.setExpEndTime(DateUtil.toDate("yyyy-MM-dd", enddate));
		mv.setViewName("redirect:/plan/planinfo");
		planService.UpdateOrSave(p);
		return mv;
	}

}
