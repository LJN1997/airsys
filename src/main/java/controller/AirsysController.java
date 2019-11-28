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

import entity.UserInfo;
import entity.UserSelectAll;
import service.prototy.IAirsysService;

@Controller
@RequestMapping("/user")
public class AirsysController {
	@Autowired
	private IAirsysService airService;

	// 主界面
	@RequestMapping("/airsys")
	public String query() {
		return "user/airsys";
	}

	// 跳转到登陆
	@RequestMapping("/login")
	public ModelAndView login() {

		ModelAndView mv = new ModelAndView("/user/signIn");
		return mv;
	}

	// 清session
	@RequestMapping("/session")
	public ModelAndView session(HttpSession session) {
		System.out.println(111);
		session.removeAttribute("uid");
		ModelAndView mv = new ModelAndView("/user/airsys");
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
		//有没有这个账户
		int a = airService.login(uphone, upwd);
		
		HttpSession session = request.getSession(true);
		String status = request.getParameter("status");
		System.out.println("sdafasgasgasgdsgdsgshsdhsdhsdh"+status);

			if(status==null) {
				status ="10";
			}
			if(status.equals("1")) {
				
			String oldUid = session.getAttribute("uid").toString();
			if(!oldUid.equals("0")||!oldUid.equals("")) {
				ModelAndView mv = new ModelAndView();
				List<UserInfo> usts;
				int uid = new Integer(oldUid);
				// 拿订单信息
				usts = airService.userTicket(uid);
				if (null == usts || usts.size() == 0) {
					System.out.println(session.getAttribute("uid"));
					mv.setViewName("forward:/user/airsys");
					mv.addObject("usts", usts);
					return mv;
				}
				// 总时长
				Date DepartureTime = usts.get(0).getDepartureTime();
				Date ArrivalTime = usts.get(0).getArrivalTime();
				long tem = ArrivalTime.getTime() - DepartureTime.getTime();
				long temp = tem / 1000 / 60;

				int count = 0;
				for (UserInfo userInfo : usts) {
					System.out.println(userInfo);
					usts.get(count).setTemp(temp);
					count++;
				}
				mv.setViewName("forward:/user/airsys");
				mv.addObject("usts", usts);
				return mv;
			}
			}

			
		
		// 有没有这个账号
		if (a > 0) {
			ModelAndView mv = new ModelAndView();
			String ljn = request.getParameter("ljn");
			String code = request.getParameter("code");
			if(ljn.equals(code)) {
			int uid = 0;
			// 查uid
			uid = airService.uid(uphone, upwd);
			List<UserInfo> usts;
			// 拿订单信息
			usts = airService.userTicket(uid);
			if (null == usts || usts.size() == 0) {
				System.out.println("走到判断条件里");
				System.out.println(session.getAttribute("uid"));
				session.setAttribute("uid", uid);
				mv.setViewName("forward:/user/airsys");
				mv.addObject("usts", usts);
				return mv;
			}
			// 总时长
			Date DepartureTime = usts.get(0).getDepartureTime();
			Date ArrivalTime = usts.get(0).getArrivalTime();
			long tem = ArrivalTime.getTime() - DepartureTime.getTime();
			long temp = tem / 1000 / 60;

			int count = 0;
			for (UserInfo userInfo : usts) {
				System.out.println(userInfo);
				usts.get(count).setTemp(temp);
				count++;
			}
			mv.setViewName("forward:/user/airsys");
			session.setAttribute("uid", uid);
			mv.addObject("usts", usts);
			return mv;
			}
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
		if(usts.isEmpty()) {
			ModelAndView mv = new ModelAndView("/user/airsys");
			String Catch = "1";
			mv.addObject("Catch", Catch);
			return mv;
		}
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
	@RequestMapping("/buy/{type}/{expStartTime}/{fid}/{tprice}/{expEndTime}/{temp}/{fromCity}/{toCity}/{season_discount}/{firstClassRemainSeats}/{businessClassRemainSeats}/{economyClassRemainSeats}/{buff}/{tid}/{tclass}/{oname}/{idcard}")
	public ModelAndView buy(@PathVariable("type") String type, @PathVariable("expStartTime") String expStartTime,
			@PathVariable("expEndTime") String expEndTime, @PathVariable("temp") String temp,
			@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity,
			@PathVariable("season_discount") String season_discount,
			@PathVariable("firstClassRemainSeats") String firstClassRemainSeats,
			@PathVariable("businessClassRemainSeats") String businessClassRemainSeats, @PathVariable("fid") String fid,
			@PathVariable("economyClassRemainSeats") String economyClassRemainSeats,
			@PathVariable("tprice") String tprice,
			@PathVariable("buff") String buff,
			@PathVariable("tid") String tid,
			@PathVariable("tclass") String tclass,
			@PathVariable("oname") String oname,
			@PathVariable("idcard") String idcard){
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
		mv.addObject("fid", fid);
		mv.addObject("buff1",buff);
		mv.addObject("tid",tid);
		mv.addObject("tclass",tclass);
		mv.addObject("oname", oname);
		mv.addObject("idcard", idcard);
		return mv;
	}
	
	@RequestMapping("/buy1/{type}/{expStartTime}/{fid}/{tprice}/{expEndTime}/{temp}/{fromCity}/{toCity}/{season_discount}/{firstClassRemainSeats}/{businessClassRemainSeats}/{economyClassRemainSeats}")
	public ModelAndView buy1(@PathVariable("type") String type,
			@PathVariable("expStartTime") String expStartTime,
			@PathVariable("expEndTime") String expEndTime, @PathVariable("temp") String temp,
			@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity,
			@PathVariable("season_discount") String season_discount,
			@PathVariable("firstClassRemainSeats") String firstClassRemainSeats,
			@PathVariable("businessClassRemainSeats") String businessClassRemainSeats, @PathVariable("fid") String fid,
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
		mv.addObject("fid", fid);
		return mv;
	}


	// 提交订单
	@RequestMapping("/userbuy")
	public ModelAndView Userbuy(HttpServletRequest request, HttpServletResponse response, HttpSession ses) {
		String uid = ses.getAttribute("uid").toString();
		String idcard = request.getParameter("idcard");
		String ophone = request.getParameter("ophone");
		String oname = request.getParameter("oname");
		String seats = request.getParameter("seats");
		String fid = request.getParameter("fid");
		String man = request.getParameter("man");
		String tprice = request.getParameter("tprice");
		String tid = request.getParameter("tid");
		String tclass = request.getParameter("tclass");
		
		String one = "1";
		String two = "2";
		String three = "3";
		String status = "1";
		System.out.println(request.getParameter("man"));
		System.out.println(request.getParameter("tprice"));
		String buff = request.getParameter("buff");
		if(buff.equals("1")) {
			airService.outTicket(uid, tid);
			if(tclass.equals("经济舱")) {
				airService.outTicketClassEco(fid);
			}else if(tclass.equals("商务舱")) {
				airService.outTicketClassBus(fid);
			}else if(tclass.equals("头等舱")){
				airService.outTicketClassFir(fid);
			}
		}
		// 舱位比较
		if (seats.equals(three)) {
			seats = "经济舱";
			airService.updateEco(fid);
		}
		if (seats.equals(two)) {
			seats = "商务舱";
			airService.updateBus(fid);
		}
		if (seats.equals(one)) {
			seats = "头等舱";
			airService.updateFir(fid);
		}

		// 乘客类型比较
		if (man.equals(three)) {
			man = "婴儿";
			airService.insertBuy(seats, man, tprice, fid, uid, idcard, status);
		}
		if (man.equals(two)) {
			man = "儿童";
			airService.insertBuy(seats, man, tprice, fid, uid, idcard, status);
		}
		if (man.equals(one)) {
			man = "成人";
			airService.insertBuy(seats, man, tprice, fid, uid, idcard, status);
		}
		
		ModelAndView mv = new ModelAndView("/user/buySuccess");
		mv.addObject(airService.buy(uid, idcard, ophone, oname));
		return mv;
	}

	// 退票
	@RequestMapping("/outticket")
	public ModelAndView outTicket(HttpServletRequest request, HttpServletResponse response, HttpSession ses) {
		ModelAndView mv = new ModelAndView("/user/outSuccess");
		String tid = request.getParameter("tid");
		String fid = request.getParameter("fid");
		String tclass = request.getParameter("tclass");
		System.out.println(tid);
		String uid = ses.getAttribute("uid").toString();
		airService.outTicket(uid, tid);
		if(tclass.equals("经济舱")) {
			airService.outTicketClassEco(fid);
		}else if(tclass.equals("商务舱")) {
			airService.outTicketClassBus(fid);
		}else {
			airService.outTicketClassFir(fid);
		}
		return mv;
	}
	
	//改签页面
	@RequestMapping("/update/user")
	public ModelAndView updateTicket(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/user/updateFlight");
		String startDate = request.getParameter("startDate");
		String fnumber = request.getParameter("fnumber");
		String tid = request.getParameter("tid");
		String tclass = request.getParameter("tclass");
		String oname = request.getParameter("oname");
		String idcard = request.getParameter("idcard");
		System.out.println(tid);
		System.out.println(fnumber);
		
		System.out.println(startDate);
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
		mv.addObject("tid",tid);
		mv.addObject("tclass",tclass);
		mv.addObject("usts", usts);
		mv.addObject("oname", oname);
		mv.addObject("idcard", idcard);
		return mv;
	}
	//改签查询
	@RequestMapping("/update/userUpdate")
	public ModelAndView updateTickets(HttpServletRequest request, HttpServletResponse response) {
		String fromCity = request.getParameter("fromCity");
		String toCity = request.getParameter("toCity");
		String startDate = request.getParameter("startDate");
		String buff = request.getParameter("buff");
		String tid = request.getParameter("tid");
		String tclass = request.getParameter("tclass");
		String oname = request.getParameter("oname");
		String idcard = request.getParameter("idcard");
		System.out.println(buff);
		System.out.println(fromCity);
		System.out.println(toCity);
		System.out.println(startDate);
		List<UserSelectAll> usts = airService.searchFlight(startDate, fromCity, toCity);
		if(usts.isEmpty()) {
			ModelAndView mv = new ModelAndView("/user/updateFlight");
			String Catch = "1";
			mv.addObject("Catch", Catch);
			return mv;
		}
		ModelAndView mv = new ModelAndView("/user/flightInfo");
		mv.addObject("usts",usts);
		mv.addObject("buff",buff);
		mv.addObject("tid",tid);
		mv.addObject("tclass",tclass);
		mv.addObject("oname", oname);
		mv.addObject("idcard", idcard);
		return mv;
	}
	
	
}
