package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.CountData;
import service.prototy.IDataService;

@Controller
@RequestMapping("/data")
public class DataController {
	@Autowired
	private IDataService dataService;
	
	@RequestMapping("/main")
	public ModelAndView getAirport() {
		ModelAndView mv = new ModelAndView("data/main");
		return mv;
	}

	
	@RequestMapping(value="/datainfo",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getdata() {
		List<CountData> findData = dataService.findData();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		for (CountData countData : findData) {
			list1.add(countData.getAllPrice());
			list2.add(countData.getCount());
			list3.add(countData.getPname());
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("allPrice",list1);
		map.put("count",list2);
		map.put("pname",list3);
		
		return JSON.toJSONString(map);
	}
}
