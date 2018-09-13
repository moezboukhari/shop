package org.sid.shopFrontEnd.controller;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/","/home","/index"},method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("greeting", "Welcom to shop on line");
		return "index";
		
	}
	

}
