package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Order;
import entity.UserSelectAll;
import service.prototy.IAirsysService;

@Controller
@RequestMapping("/user")
public class AirsysController {
	@Autowired
	private IAirsysService airService;

	// 主界面
	@RequestMapping("/airsys")
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("/user/airsys");
		return mv;
	}

	// 跳转到登陆
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("/user/signIn");
		return mv;
	}

	// 跳转到注册
	@RequestMapping("/reg")
	public ModelAndView reg() {
		ModelAndView mv = new ModelAndView("/user/reg");
		return mv;
	}

	// 用户登陆
	@RequestMapping("/sigcon")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String uphone = request.getParameter("uphone");
		String upwd = request.getParameter("upwd");

		int a = airService.login(uphone, upwd);
		int uid = airService.uid(uphone, upwd);
		if (a > 0) {
			ModelAndView mv = new ModelAndView("/user/airsys");
			HttpSession session = request.getSession(true);
			session.setAttribute("uid", uid);
			return mv;
		}
		ModelAndView mv = new ModelAndView("/user/signIn");
		return mv;
	}

	// 用户注册
	@RequestMapping("/regcon")
	public ModelAndView reg(HttpServletRequest request, HttpServletResponse response) {
		String uphone = request.getParameter("uphone");
		String upwd = request.getParameter("upwd");
		String upwd2 = request.getParameter("upwd2");
		if (upwd.equals(upwd2)) {
			airService.reg(uphone, upwd2);
			ModelAndView mv = new ModelAndView("/user/signIn");
			return mv;
		}

		ModelAndView mv = new ModelAndView("/user/reg");
		return mv;
	}

	// 用户查航班
	@RequestMapping("/airsys/users")
	@ResponseBody
	public ModelAndView queryUsers(String fromCity, String toCity, String start) {
		List<UserSelectAll> usts = airService.searchFlight(start, fromCity, toCity);
		// 总时长
		Date DepartureTime = usts.get(0).getDepartureTime();
		Date ArrivalTime = usts.get(0).getArrivalTime();
		long tem = ArrivalTime.getTime() - DepartureTime.getTime();
		long temp = tem / 1000 / 60;

		int count = 0;
		for (UserSelectAll userSelectAll : usts) {
			usts.get(count).setTemp(temp);
			count++;
		}

		ModelAndView mv = new ModelAndView("/user/flightInfo");
		mv.addObject("usts", usts);
		return mv;
	}

	// 用户航班状态
	@RequestMapping("/airsys/userbuff")
	@ResponseBody
	public ModelAndView queryflightBuff(String fnumber, String startDate) {
		List<UserSelectAll> usts = airService.searchFlightBuff(fnumber, startDate);

		// 飞行状态
		Date a1 = usts.get(0).getDepartureTime();
		Date a2 = new Date();

		Date a3 = usts.get(0).getArrivalTime();

		if (a1.before(a2) && a2.before(a3)) {
			usts.get(0).setStr("飞行中");
		} else if (a1.before(a2) && a3.before(a2)) {
			usts.get(0).setStr("已降落");
		} else {
			usts.get(0).setStr("未起飞");

		}

		// 总时长
		Date DepartureTime = usts.get(0).getDepartureTime();
		Date ArrivalTime = usts.get(0).getArrivalTime();
		long tem = ArrivalTime.getTime() - DepartureTime.getTime();
		long temp = tem / 1000 / 60;
		usts.get(0).setTemp(temp);

		ModelAndView mv = new ModelAndView("/user/flightStatus");
		mv.addObject("usts", usts);
		return mv;
	}

	// 用户购买
	@RequestMapping("/buy/{type}/{expStartTime}/{fid}/{tprice}/{expEndTime}/{temp}/{fromCity}/{toCity}/{season_discount}/{firstClassRemainSeats}/{businessClassRemainSeats}/{economyClassRemainSeats}")
	public ModelAndView buy(@PathVariable("type") String type, @PathVariable("expStartTime") String expStartTime,
			@PathVariable("expEndTime") String expEndTime, @PathVariable("temp") String temp,
			@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity,
			@PathVariable("season_discount") String season_discount,
			@PathVariable("firstClassRemainSeats") String firstClassRemainSeats,
			@PathVariable("businessClassRemainSeats") String businessClassRemainSeats,
			@PathVariable("fid") String fid,
			@PathVariable("economyClassRemainSeats") String economyClassRemainSeats,
			@PathVariable("tprice") String tprice){
		ModelAndView mv = new ModelAndView("/user/userBuy");
		mv.addObject("type", type);
		mv.addObject("expStartTime", expStartTime);
		mv.addObject("expEndTime", expEndTime);
		mv.addObject("temp", temp);
		mv.addObject("fromCity", fromCity);
		mv.addObject("toCity", toCity);
		mv.addObject("season_discount", season_discount);
		mv.addObject("firstClassRemainSeats", firstClassRemainSeats);
		mv.addObject("businessClassRemainSeats", businessClassRemainSeats);
		mv.addObject("economyClassRemainSeats", economyClassRemainSeats);
		mv.addObject("tprice", tprice);
		mv.addObject("fid",fid);
		return mv;
	}
	//提交订单
	@RequestMapping("/userbuy")
	public ModelAndView Userbuy(HttpServletRequest request, HttpServletResponse response,HttpSession ses) {
		
		String uid = ses.getAttribute("uid").toString();
		String idcard = request.getParameter("idcard");
		String ophone = request.getParameter("ophone");
		String oname = request.getParameter("oname");
		String seats = request.getParameter("seats");
		String fid = request.getParameter("fid");
		String man = request.getParameter("man");
		String tprice = request.getParameter("tprice");
		String one = "1";
		String two = "2";
		String three = "3";
		String status = "1";
		System.out.println(request.getParameter("man"));
		System.out.println(request.getParameter("tprice"));
		//舱位比较
		if(seats.equals(three)) {
			seats = "经济舱";
			airService.updateEco(fid);
		}
		if(seats.equals(two)) {
			seats = "商务舱";
			airService.updateBus(fid);
		}
		if(seats.equals(one)) {
			seats = "头等舱";
			airService.updateFir(fid);
		}
		
		//乘客类型比较
		if(man.equals(three)) {
			man = "婴儿";
			airService.insertBuy(seats, man, tprice, fid, uid, idcard, status);
		}
		if(man.equals(two)) {
			man = "儿童";
			airService.insertBuy(seats, man, tprice, fid, uid, idcard, status);
		}
		if(man.equals(one)) {
			man = "成人";
			airService.insertBuy(seats, man, tprice, fid, uid, idcard, status);
		}

		ModelAndView mv = new ModelAndView("/user/buySuccess");
		mv.addObject( airService.buy(uid, idcard, ophone, oname));
		return mv;
	}
}
