package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Airport;
import entity.Place;
import service.prototy.IPlaceService;

@Controller
@RequestMapping("/place")
public class PlaceController {
	@Autowired
	private IPlaceService placeService;
	
	@RequestMapping("/placeinfo")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("place/main");
		List<Place> place = placeService.findAll();
		mv.addObject("place",place);
		return mv;
	}
	@RequestMapping("/delete/{pid}")
	public ModelAndView delete(@PathVariable("pid") int id) {
		ModelAndView mv = new ModelAndView();
		placeService.Detele(id);
		mv.setViewName("redirect:/place/placeinfo");
		return mv;
	}

	@RequestMapping("/back")
	public ModelAndView back() {
		ModelAndView mv = new ModelAndView("place/main");
		// airService.AirSaveorUpdate(new Airport(id,name,city));
		return mv;
	}
	@RequestMapping("/update/{pid}")
	public ModelAndView update(@PathVariable("pid") int id) {
		ModelAndView mv = new ModelAndView("place/placeupdate");
		List<Place> find = placeService.find(id);
		// mv.setViewName("redirect:/air/airinfo");
		mv.addObject("place", find);
		return mv;
	}
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ModelAndView data(int id,String name, String phone, String site,String province) {
		ModelAndView mv = new ModelAndView();
		placeService.SaveOrUpdate(new Place(id,name,phone,site,province));
		mv.setViewName("redirect:/place/placeinfo");
		return mv;
	}
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("place/add");
		return mv;
	}
	@RequestMapping(value = "/adds", method = RequestMethod.POST)
	public ModelAndView adds(String name, String phone, String site,String province) {
		ModelAndView mv = new ModelAndView();
		placeService.SaveOrUpdate(new Place(0,name,phone,site,province));
		mv.setViewName("redirect:/place/placeinfo");
		return mv;
	}
}
