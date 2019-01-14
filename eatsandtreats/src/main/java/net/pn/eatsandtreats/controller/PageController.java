package net.pn.eatsandtreats.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.pn.eatsandtreats.exception.ItemNotFoundException;
import net.pn.entbackend.dao.CategoryDAO;
import net.pn.entbackend.dao.ItemDAO;
import net.pn.entbackend.dao.UserDAO;
import net.pn.entbackend.dto.Cart;
import net.pn.entbackend.dto.Category;
import net.pn.entbackend.dto.Item;
import net.pn.entbackend.dto.User;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	UserDAO userDAO;

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
	
	//============================== OFFERS ===============================================////////////////

	@RequestMapping(value = "/Offers")
	public ModelAndView appetizers() {
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		mv.addObject("title", "Offers");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryItems", true);
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("title", "Login");
		if (error != null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if (logout != null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}

	// ======== LOGIN ACCESS DENIED
	// =========================================================//
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		mv.addObject("title", "403 Access Denied");
		return mv;
	}

	// ======== LOGOUT
		// =========================================================//
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "redirect:/login?logout";
	}	
	

	// ===================== REGISTER
	// =============================================================//
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam(name = "status", required = false) String status) {

		ModelAndView mv = new ModelAndView("register");
		mv.addObject("title","Register");
		User user = new User();
		mv.addObject("user", user);
		if (status != null) {
			if (status.equals("success")) {
				mv.addObject("message", "Registered successfully.");
				mv.addObject("msg","registered");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("user") User nUser, BindingResult results, Model model,
			HttpServletRequest request) {

		logger.info(results.toString());
		if (results.hasErrors()) {
			model.addAttribute("title", "Register");
			model.addAttribute("message", " Registeration failed! Please check the details and try again.");
			return "register";
		}
		
		if(userDAO.getByEmail(nUser.getEmail())!=null)
		{
			model.addAttribute("message", "Email is already registered");
			return "register";
		}
		
		Cart cart = new Cart();
		
		cart.setUser(nUser);
		nUser.setCart(cart);
		userDAO.add(nUser);
		
		return "redirect:/register?status=success";
	}
	
	//==============================================================================


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
	public ModelAndView showCategoryItems(@PathVariable("id") int id){
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
	public ModelAndView showSingleItem(@PathVariable int id) throws ItemNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		
		Item item = itemDAO.get(id);
		
		if(item == null) throw new ItemNotFoundException();
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
