package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Airport;
import entity.PlaceNotes;
import service.prototy.IPlaceNotesService;

@Controller
@RequestMapping("/placeNote")
public class PlaceNotesController {
	@Autowired
	private IPlaceNotesService placeNotesService;
	

	@RequestMapping("/placeNotesinfo")
	public ModelAndView getPlaceNotes() {
		ModelAndView mv = new ModelAndView("placeNotes/main");
		List<PlaceNotes> findAll = placeNotesService.findAll();
		mv.addObject("placeNote", findAll);
		return mv;
	}
	@RequestMapping("/show/{oid}")
	public ModelAndView show(@PathVariable("oid")int oid) {
		ModelAndView mv = new ModelAndView("placeNotes/show");
		PlaceNotes findByOid = placeNotesService.findByOid(oid);
		mv.addObject("Note", findByOid);
		return mv;
	}
	@RequestMapping("/back")
	public ModelAndView back() {
		ModelAndView mv = new ModelAndView("placeNotes/main");
		mv.setViewName("redirect:/placeNote/placeNotesinfo");
		return mv;
	}


}
