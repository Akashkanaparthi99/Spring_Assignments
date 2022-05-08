package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;


public interface IProductService {

	 void addProduct(Product product);
	    void updateProduct(Product product);
	    void deleteProduct(int productId);
	    List<Product> getAll();
	    Product getById(int productId);
	    List<Product> getByCategory(String category) throws ProductNotFoundException;
	    List<Product> getByBrand(String brand) throws ProductNotFoundException;
	    List<Product> getByLesserPrice(double price) throws ProductNotFoundException;
	    List<Product> getByBrandStarting(String brand) throws ProductNotFoundException;
	    List<Product> getByChoice(String choice);
//
//	    // custom Query
//	    List<Product> getByNewBrands(String brand);
//	    List<Product> getByNewBrandshow(String brand,double cost);
//	    List<Product> getByCatBrand(String category,String brand);
//	    List<Product> getByBrandName(String brand,String name);
//	    // native query
//	    List<Product> findByBetweenPrice(double minPrice,double maxPrice);
//	    // modifing NQ
//	    void updateProductCost(int productId, double price);

}
