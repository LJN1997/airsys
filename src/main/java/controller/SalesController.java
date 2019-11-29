package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import config.AlipayConfig1;
import entity.Info;
import entity.Order;
import entity.Sales;
import entity.Ticket;
import entity.aa;
import service.prototy.ISalesService;

/**
 * 
 * 营业员管理Controller类
 * 
 * @author DanyangLi
 */
@Controller
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	private ISalesService salesService;

	// 1、查票 在主界面index左边查票加链接，跳转到查票界面query.jsp
	@RequestMapping("/query")
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("/sales/query");
		return mv;
	}

	// 2、接收查票界面的值,表单提交到queryCon.jsp,以表格的形式展示出来查询结果
	@RequestMapping("/queryCon")
	public ModelAndView querycon(HttpServletRequest request, HttpServletResponse response) {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String startTime = request.getParameter("starttime");
		ModelAndView mv = new ModelAndView("/sales/queryCon");
		List<Info> info = salesService.find(from, to, startTime);
		mv.addObject("info", info);
		return mv;
	}

	// 3、预定票，从queryCon.jsp页面跳转到reserve.jsp，预定票的界面
	// 然后将参数信息存起来，使reserve.jsp能获取到这些参数
	@RequestMapping("/reserve/{from}/{to}/{expStartTime}/{expEndTime}/{price}/{fnumber}/{planId}")
	public ModelAndView reserve(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("expStartTime") String expStartTime, @PathVariable("expEndTime") String expEndTime, @PathVariable("price") double price,
			@PathVariable("fnumber") String fnumber, @PathVariable("planId") int planId) {
		String starttime = expStartTime.replaceAll("\\s*|\t|\r|\n", "");
		String endtime = expEndTime.replaceAll("\\s*|\t|\r|\n", "");
		ModelAndView mv = new ModelAndView("/sales/reserve");
		mv.addObject("fnumber", fnumber);
		mv.addObject("from", from);
		mv.addObject("to", to);
		mv.addObject("expStartTime", starttime);
		mv.addObject("expEndTime", endtime);
		mv.addObject("price", price);
		mv.addObject("planId", planId);
		return mv;
	}

	// 4、机票购买 获取reserve.jsp中的参数 执行买票的三个方法
	@RequestMapping("/buy")
	public ModelAndView buy(HttpServletRequest request) {
		String expStartTime = request.getParameter("starttime");
		int sid = Integer.parseInt(request.getParameter("sid"));
		double price = Double.parseDouble(request.getParameter("price"));
		int planId = Integer.parseInt(request.getParameter("planId"));
		String fnumber = request.getParameter("fnumber");
		String people = request.getParameter("people");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String seat = request.getParameter("grade");
		String tclass = "";
		if (seat.equals("business_class_remain_seats")) {
			tclass = "商务舱";
		} else if (seat.equals("first_class_remain_seats")) {
			tclass = "头等舱";
		} else if (seat.equals("economy_class_remain_seats")) {
			tclass = "经济舱";
		}
		String idcard = request.getParameter("idcard");
		// 先根据用户的身份证判断下order表里有没有这个用户，如果有的话，就不用再往order表里增加一条信息了
		int findIdcard = salesService.findIdcard(idcard);
		if (findIdcard > 0) {
			salesService.updateFightSeat(fnumber, seat);
			salesService.addTicket(new Ticket(planId, 0, sid, tclass, people, price, 1, idcard));
			// 点击下一步购买票跳转到沙箱支付主界面
			ModelAndView mv = new ModelAndView("/sales/payIndex");
			mv.addObject("price", price);
			return mv;
		} else {
			// 否则的话就要改三个表的内容了
			salesService.addTicket(new Ticket(planId, 0, sid, tclass, people, price, 1, idcard));
			salesService.addOrder(new Order(sid, 0, idcard, phone, name));
			salesService.updateFightSeat(fnumber, seat);
			// 点击下一步购买票跳转到沙箱支付主界面
			ModelAndView mv = new ModelAndView("/sales/payIndex");
			mv.addObject("price", price);
			return mv;
		}
	}

	// 5、payIndex.jsp界面，当点击付款时，会接收界面的参数表单提交到topay，也就是alipay.trade.page.pay.jsp二维码付款的界面
	@RequestMapping("/toplay")
	public ModelAndView toplay() {
		ModelAndView mv = new ModelAndView("/sales/alipay.trade.page.pay");
		return mv;
	}

	// 支付测试，没用到这个controller
	@RequestMapping(value = "/go", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String goAlipay(HttpServletRequest request, HttpServletRequest response) throws Exception {

		// Orders order = orderService.getOrderById(orderId);

		// Product product =
		// productService.getProductById(order.getProductId());

		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig1.gatewayUrl, AlipayConfig1.app_id,
				AlipayConfig1.merchant_private_key, "json", AlipayConfig1.charset, AlipayConfig1.alipay_public_key,
				AlipayConfig1.sign_type);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig1.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig1.notify_url);

		// 商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = "11";
		// 付款金额，必填
		String total_amount = "200.00";
		// 订单名称，必填
		String subject = "机票";
		// 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
		// 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
		String timeout_express = "15分钟之内支付有效";

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"timeout_express\":\"" + timeout_express + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		// 请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		System.out.println(result);
		return result;
	}

	// 6、退票 主界面点击退票跳转到delete.jsp界面
	@RequestMapping("/quitTicket")
	public ModelAndView quitTicket() {
		ModelAndView mv = new ModelAndView("/sales/delete");
		return mv;
	}
	/*
	 * @RequestMapping(value="/selectOid" ,method = RequestMethod.POST, produces
	 * = "application/json;charset=UTF-8")
	 * 
	 * @ResponseBody public String selectOid(@RequestBody Map<String,Object>
	 * map){ String oname = (String)map.get("oname"); String idcard =
	 * (String)map.get("idcard"); System.out.println(oname);
	 * System.out.println(idcard); List<Ticket> t =salesService.findBy(oname,
	 * idcard); System.out.println(t); String a = JSON.toJSONString(t); return
	 * a; }
	 */

	// 6.1、ajax传数据，先接收界面 的姓名和身份证号，查到这个票，返回json再到该界面
	@RequestMapping(value = "/selectOid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectOid(HttpServletRequest request) {
		String oname = request.getParameter("oname");
		String idcard = request.getParameter("idcard");
			List<Ticket> t = salesService.findBy(oname, idcard);
			String a = JSON.toJSONString(t);
			return a;
	}

	// 6.2、点击查到的数据后面的退票按钮，ajax传数据到controller层，执行两个方法更新状态为0，座位+1
	@RequestMapping(value = "/delTicket", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String delTicket(HttpServletRequest request) {
		int tid = Integer.parseInt(request.getParameter("tid"));
		String fnumber = request.getParameter("fnumber");
		
		String seat = request.getParameter("tclass");
		String tclass = "";
		if (seat.equals("商务舱")) {
			tclass = "business_class_remain_seats";
		} else if (seat.equals("头等舱")) {
			tclass = "first_class_remain_seats";
		} else if (seat.equals("经济舱")) {
			tclass = "economy_class_remain_seats";
		}
		salesService.addFightSeat(fnumber, tclass);
		salesService.updateTicketStatus(tid);
		return "ok";
	}

	// 7、改签 主界面点击改签跳转至改签界面
	@RequestMapping("/change")
	public ModelAndView getUsers4() {
		ModelAndView mv = new ModelAndView("/sales/change");
		return mv;
	}
	
	// 7.1、ajax传数据，先接收界面 的姓名和身份证号，查到这个票，返回json再到该界面
	@RequestMapping(value = "/findByUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String findByUser(HttpServletRequest request) {
		String oname = request.getParameter("oname");
		String idcard = request.getParameter("idcard");
	
			List<Ticket> t = salesService.findByUser(oname, idcard);
			String a = JSON.toJSONString(t);
			return a;
	}

	
	

	// 7.1、先根据姓名和身份证查到票，和退票查询一样，这个是接收查到票的信息，进行改签，更新状态为2，座位+1
	@RequestMapping(value = "/changeTicket", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String changeTicket(HttpServletRequest request) {
		int tid = Integer.parseInt(request.getParameter("tid"));
		String fnumber = request.getParameter("fnumber");
		String seat = request.getParameter("tclass");
		String tclass = "";
		if (seat.equals("商务舱")) {
			tclass = "business_class_remain_seats";
		} else if (seat.equals("头等舱")) {
			tclass = "first_class_remain_seats";
		} else if (seat.equals("经济舱")) {
			tclass = "economy_class_remain_seats";
		}
		salesService.changeTicketStatus(tid);
		salesService.addFightSeat(fnumber, tclass);
		return "ok";
	}

	// 8、查询自己买票的历史记录
	@RequestMapping("/history/{num}")
	public ModelAndView history(@PathVariable("num") String num) {
		ModelAndView mv = new ModelAndView("/sales/history");
		List<Ticket> history = salesService.history(num);
		mv.addObject("history", history);
		return mv;
	}

	// 9、查询营业员个人信息
	@RequestMapping("/saleinfo/{num}")
	@ResponseBody
	public ModelAndView saleinfo(@PathVariable("num") String num) {
		ModelAndView mv = new ModelAndView("/sales/selfinfo");
		// String sale = JSON.toJSONString(salesService.saleinfo(1));
		List<Sales> sale = salesService.saleinfo(num);
		mv.addObject("sale", sale);
		return mv;
	}

	//10、编辑营业员信息
	@RequestMapping(value = "/editCon", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String edit(HttpServletRequest request) {
		String snumber = request.getParameter("snumber");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String province = request.getParameter("province");
		String psite = request.getParameter("psite");
		String pname = request.getParameter("pname");
		System.out.println(snumber+name+phone+province+psite+pname);
		return null;
	}
	
	//11、修改营业员密码
	// 9、查询营业员个人信息
	@RequestMapping("/reset/{num}")
	@ResponseBody
	public ModelAndView reset(@PathVariable("num") String num) {
		ModelAndView mv = new ModelAndView("/sales/reset");
		// String sale = JSON.toJSONString(salesService.saleinfo(1));
		return mv;
	}
	
	
	// 自己写的营业员登录，这个不用，我营业员再主界面登录
	@RequestMapping("/loginCon")
	public ModelAndView loginCon(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		String pwd = request.getParameter("pwd");
		int sale = salesService.login(num, pwd);
		int sid = salesService.findSid(num, pwd);
		if (sale > 0) {
			List<Sales> saleInfo = salesService.saleinfo(num);
			ModelAndView mv = new ModelAndView("/sales/index");
			HttpSession session = request.getSession(true);
			session.setAttribute("sid", sid);
			mv.addObject("saleInfo", saleInfo);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("/sales/login");
			return mv;
		}
	}

}
