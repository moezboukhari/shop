package org.sid.shopFrontEnd.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.sid.shopBackEnd.dao.CategoryDao;
import org.sid.shopBackEnd.dao.ProductRepository;
import org.sid.shopBackEnd.dto.Category;
import org.sid.shopBackEnd.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@ComponentScan({"org.sid.shopBackEnd","org.sid.shopFrontEnd"})
@Controller
public class PageController {
	private static Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	CategoryDao categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/error")
	public String errPage(Model model) {
		model.addAttribute("errorTitle", "the pag is not constructed");
		model.addAttribute("errorDescription", "the pag you are looking for is not available now !");
		model.addAttribute("title", "404 error page");
		return "error";
	}
	
	
	@RequestMapping(value = {"/","/index","/home"},method=RequestMethod.GET)
	public String index(Model model) {
		logger.info("inside index page index method - INFO");
		logger.debug("inside index page index method- DEBUG");
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
	
	
/*
 * show single page product
 */
	@RequestMapping(value = {"/show/{id}/product"},method=RequestMethod.GET)
	public String product(Model model,@PathVariable Long id) {
		
		Product product = productRepository.getOne(id);
		product.setViews(product.getViews()+1);
		model.addAttribute("title",product.getName());
		model.addAttribute("product", product);
		model.addAttribute("userClickProduct", "true");
		return "index";
	}
}
