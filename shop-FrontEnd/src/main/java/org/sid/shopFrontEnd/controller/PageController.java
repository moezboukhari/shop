package org.sid.shopFrontEnd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/","/index","/home"},method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("title", "Home Shop");
		model.addAttribute("userClickHome", "true");
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
		model.addAttribute("title", "contact Shop");
		model.addAttribute("userClickContact", "true");
		return "index";
		
	}

}
