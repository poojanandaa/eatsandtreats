package net.pn.eatsandtreats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.pn.entbackend.dao.ItemDAO;
import net.pn.entbackend.dto.Item;

@Controller
@RequestMapping("/json/data/")
public class JsonDataController {

	@Autowired
	private ItemDAO itemDAO;

	@ResponseBody
	@RequestMapping("/all/items")
	public List<Item> getAllItems() {
		return itemDAO.listActiveItems();
	}

	@RequestMapping("/category/{id}/items")
	@ResponseBody
	public List<Item> getItemsByCategory(@PathVariable int id) {
		return itemDAO.listActiveItemsByCategory(id);
	}

}
 	