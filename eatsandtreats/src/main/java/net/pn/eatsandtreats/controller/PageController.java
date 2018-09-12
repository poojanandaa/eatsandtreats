package net.pn.eatsandtreats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.pn.entbackend.dao.CategoryDAO;
import net.pn.entbackend.dao.ItemDAO;

@Controller
public class PageController {

	@Autowired
	CategoryDAO categoryDAO;
	ItemDAO itemDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring web mvc");
		mv.addObject("title", "Home");
		mv.addObject("items", itemDAO.listActiveItems());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/cakesAndPasteries")
	public ModelAndView cakes() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring web mvc");
		mv.addObject("title", "Cakes and Pasteries");
		mv.addObject("userClickCakes", true);
		return mv;
	}

	@RequestMapping(value = "/appetizers")
	public ModelAndView appetizers() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring web mvc");
		mv.addObject("title", "Appetizers");
		mv.addObject("userClickAppetizers", true);
		return mv;
	}

	@RequestMapping(value = "/allItems")
	public ModelAndView allItems() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring web mvc");
		mv.addObject("title", "All Items");
		mv.addObject("userClickAllItems", true);
		return mv;
	}

	@RequestMapping(value = "/contactUs")
	public ModelAndView contactUs() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring web mvc");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContactUs", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring web mvc");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

}
