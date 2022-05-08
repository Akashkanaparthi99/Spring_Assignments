package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@Controller
public class ProductController {
	
	private IProductService productService;
	
	
	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}



	@RequestMapping("/")
	public String home(ModelMap map) {
		List<Product> products = productService.getAll();
		map.addAttribute("products",products);
		return "home";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Product product) {
		productService.addProduct(product);
		return "admin";
	}
	@RequestMapping("/search")
	public String searchProduct(@RequestParam("choice") String choice,ModelMap map) {
		List<Product> products = productService.getByChoice(choice);
		map.addAttribute("products", products);
		return "home";
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId")int productId) {
		productService.deleteProduct(productId);
		return "admin";
	}
	
	@RequestMapping("/oneProduct")
	public String updateProductById(@RequestParam("productId")int productId,ModelMap map) {
		Product product = productService.getById(productId);
		map.addAttribute("product", product);
		return "updateProduct";
	}
	
	@RequestMapping("/updateProd")
	public String updateProduct(Product product) {
		System.out.println(product);
		System.out.println(product.getProductId());
		productService.updateProduct(product);
		return"admin";
	}
	
}
