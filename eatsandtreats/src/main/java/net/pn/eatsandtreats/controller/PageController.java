package net.pn.eatsandtreats.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.pn.entbackend.dao.CategoryDAO;
import net.pn.entbackend.dao.ItemDAO;
import net.pn.entbackend.dto.Category;
import net.pn.entbackend.dto.Item;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ItemDAO itemDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		logger.info("INSIDE PAGE CONTROLLER INDEX METHOD - INFO");
		logger.debug("INSIDE PAGE CONTROLLER INDEX METHOD - DEBUG");
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/cakes")
	public ModelAndView cakes() {
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get('1');
		mv.addObject("title", "Cakes");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryItems", true);
		return mv;
	}

	@RequestMapping(value = "/appetizers")
	public ModelAndView appetizers() {
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(3);
		mv.addObject("title", "Appetizers");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryItems", true);
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

	@RequestMapping(value = "/show/category/{id}/items")
	public ModelAndView showCategoryItems(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryItems", true);
		return mv;
	}

	@RequestMapping(value = "/show/all/items")
	public ModelAndView allItems() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Items");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllItems", true);
		return mv;
	}
	
	//show single item
	@RequestMapping(value = "/show/{id}/item")
	public ModelAndView showSingleItem(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Item item = itemDAO.get(id);
		
		//update view count
		item.setViews(item.getViews() + 1);
		itemDAO.update(item);
		//-----
		
		mv.addObject("title",item.getName());
		mv.addObject("item", item);
		mv.addObject("userClickShowItem", true);
		
		
		return mv;
	}

}
