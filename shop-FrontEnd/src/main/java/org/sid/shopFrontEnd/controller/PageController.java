package org.sid.shopFrontEnd.controller;


import java.util.List;

import org.sid.shopBackEnd.dao.CategoryDao;
import org.sid.shopBackEnd.dao.ProductRepository;
import org.sid.shopBackEnd.dto.Category;
import org.sid.shopBackEnd.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@ComponentScan({"org.sid.shopBackEnd.dao","org.sid.shopBackEnd"})
@Controller
public class PageController {
	
	@Autowired
	CategoryDao categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	
	@RequestMapping(value = {"/","/index","/home"},method=RequestMethod.GET)
	public String index(Model model) {
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("title", "Home Shop");
		model.addAttribute("userClickHome", "true");
		model.addAttribute("categories", categories);
		
		return "index";
		
	}
	@RequestMapping(value = {"/show/all/products","/products"},method=RequestMethod.GET)
	public String products(Model model) {
		List<Category> categories = categoryRepository.findAll();
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		model.addAttribute("title", "All Products");
		model.addAttribute("userClickProducts", "true");
		model.addAttribute("categories", categories);
		
		return "index";
		
	}
	@RequestMapping(value = {"/show/category/{id}/products"},method=RequestMethod.GET)
	public String categoryProduct(Model model,@PathVariable("id") Long id) {
		Category category = categoryRepository.findById(id).get();
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("title", category.getName());
		model.addAttribute("categories", categories);
		model.addAttribute("userClickCategProducts", "true");
		model.addAttribute("category", category);
		
		return "index";
		
	}
	
	@RequestMapping(value = {"/about"},method=RequestMethod.GET)
	public String about(Model model) {
		model.addAttribute("title", "About Shop");
		model.addAttribute("userClickAbout", "true");
		return "index";
		
	}

	@RequestMapping(value = {"/contact"},method=RequestMethod.GET)
	public String contact(Model model) {
		model.addAttribute("title", "Contact Shop");
		model.addAttribute("userClickContact", "true");
		return "index";
		
	}

}
