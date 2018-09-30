package org.sid.shopFrontEnd.controller;

import java.util.List;

import org.sid.shopBackEnd.dao.ProductRepository;
import org.sid.shopBackEnd.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//@ComponentScan({"org.sid.shopBackEnd.dao","org.sid.shopBackEnd"})
@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productRepository.findByIs_active(true);
	}
	@GetMapping("admin/all/products")
	@ResponseBody
	public List<Product> getAdminAllProducts() {
		return productRepository.findAll();
	}
	@GetMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllProductsByCategory(@PathVariable Long id) {
		return productRepository.findByCategory_id(id,true);
	}
}
