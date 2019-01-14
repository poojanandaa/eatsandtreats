package net.pn.eatsandtreats.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.pn.eatsandtreats.util.FileUploadUtility;
import net.pn.entbackend.dao.CategoryDAO;
import net.pn.entbackend.dao.ItemDAO;
import net.pn.entbackend.dto.Category;
import net.pn.entbackend.dto.Item;


@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ItemDAO itemDAO;
	private static Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public ModelAndView showManageItems(@RequestParam(name = "operation", required = false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageItems", true);
		mv.addObject("title", "Manage Items");

		Item nItem = new Item();
		nItem.setActive(true);
		mv.addObject("item", nItem);

		if (operation != null) {
			if (operation.equals("item")) {
				mv.addObject("message", "Item submitted succesfully");
			}
			if (operation.equals("category")) {
				mv.addObject("message", "Category added succesfully");
			}
		}
		return mv;
		
	}

	// handling item submission
		@RequestMapping(value = "/items", method = RequestMethod.POST)
		public String handleItemSubmission(@Valid @ModelAttribute("item") Item mItem, BindingResult results,
				Model model, HttpServletRequest request) {
			logger.info(results.toString());

			if (results.hasErrors())
			{
				model.addAttribute("userClickManageItems", true);
				model.addAttribute("title", "Manage Items");
				model.addAttribute("message","Item validation failed for item submission");
				return "page";	
			}
		    logger.info(mItem.toString());
			if(mItem.getId()==0){
			itemDAO.add(mItem);
			}
			else{
				itemDAO.update(mItem);
			}
			
			if(!mItem.getFile().getOriginalFilename().equals(""))
			{
				FileUploadUtility.uploadFile(request, mItem.getFile(), mItem.getCode());
			}
				
			return "redirect:/manage/items?operation=item";
		}
	
	@RequestMapping(value = "/{id}/item", method = RequestMethod.GET)
	public ModelAndView showEditItems(@PathVariable int id)  {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageItems", true);
		mv.addObject("title", "Manage Items");

		Item nItem = itemDAO.get(id);
		mv.addObject("item", nItem);
		return mv;
	}
	
	// to handle category submission
		@RequestMapping(value = "/category", method = RequestMethod.POST)
		public String handleCategorySubmission(@ModelAttribute Category category)  {
			
			categoryDAO.add(category);
			return "redirect:/manage/items/?operation=category";
			 
		}
		
		
		
		@ModelAttribute("category")
		public Category getCategory() {
			return new Category();
		}
		
		@ModelAttribute("categories")
		public List<Category> getCategories() {
			return categoryDAO.list();
		}
}
