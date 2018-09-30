package org.sid.shopFrontEnd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.sid.shopBackEnd.dao.CategoryDao;
import org.sid.shopBackEnd.dao.ProductRepository;
import org.sid.shopBackEnd.dto.Category;
import org.sid.shopBackEnd.dto.Product;
import org.sid.shopFrontEnd.util.FileUploadUtility;
import org.sid.shopFrontEnd.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {

	    binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));

	}
	private static Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	private CategoryDao categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@GetMapping("/products")
	public String showManageProducts(Model model,@RequestParam(name="operation",required=false) String operation) {
		List<Category> categories = categoryRepository.findAll();
		
		model.addAttribute("title", "Manage Products");
		model.addAttribute("userClickManageProducts", "true");
		model.addAttribute("categories", categories);
		model.addAttribute("product", new Product());
		if (operation!=null) {
			if(operation.equals("product")) {
				model.addAttribute("message", "Saving Product successfully !!");
			}
			if(operation.equals("category")) {
				model.addAttribute("message", "Saving Category successfully !!");
			}
		}
		return "index";
	}
	@PostMapping("/products")
	public String addNewProduct(Model model, @Valid Product product, BindingResult br,HttpServletRequest request) {
List<Category> categories = categoryRepository.findAll();

if (product.getId()==null) {
	new ProductValidator().validate(product, br);
}
else {
	if (!product.getFile().getOriginalFilename().equals("")) {
		new ProductValidator().validate(product, br);
	}
}
logger.debug(product.toString());
		model.addAttribute("title", "Manage Products");
		model.addAttribute("userClickManageProducts", "true");
		model.addAttribute("categories", categories);
		model.addAttribute("product", product);
		
		
		if (br.hasErrors()) {
			return "index";
		}
		
			
		if(!product.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, product.getFile(), product.getCode());
		}
		productRepository.saveAndFlush(product);
		return "redirect:/manage/products?operation=product";
		
	}
	@PostMapping("/product/{id}/activation")
	@ResponseBody
	public String	activateProduct(@PathVariable(name="id") Long id) {
		
		Product product = productRepository.getOne(id);
		boolean isActive = product.isActive();
		product.setActive(!product.isActive());
		productRepository.saveAndFlush(product);
		return (isActive) ? "you are successfully to deactivate product id :" +id :
			"you are successfully to activate product id :" +id;
	}
	@GetMapping("/{id}/product")
	public String showEditProducts(Model model,@PathVariable Long id) {
		
		List<Category> categories = categoryRepository.findAll();
		Product product = productRepository.getOne(id);
		logger.info(product.toString());
		model.addAttribute("title", "Manage Products");
		model.addAttribute("userClickManageProducts", "true");
		model.addAttribute("categories", categories);
		model.addAttribute("product", product);
		return "index";
	}
	@PostMapping("/category")
	public String addNewCategory(Category category) {
		
		categoryRepository.save(category);
		return "redirect:/manage/products?operation=category";
	}
//@ModelAttribute("category") 
//public Category getCategory () {
//	return new Category();
//}
}
