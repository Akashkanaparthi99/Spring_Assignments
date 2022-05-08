package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer>{

	 //derived queries can startwith findBy, readBy, getBy
    List<Product> findByCategory(String category);
    List<Product> getByBrand(String brand);
    List<Product> getByBrandStartingWith(String brand);
    List<Product> readByPriceLessThan(double price);
    
    
    @Query("from Product p where p.category = ?1 or p.brand= ?1")
    List<Product> findByChoice(String choice);

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    // custom query - JPQL = java persistence query language
//    // query should be writen in the terms of java
//    @Query("from Product p where p.brand = ?1")
//    List<Product> getByNewBrands(String brand);
//    @Query("from Product p where p.brand = ?1 and price = ?2")
//    List<Product> getByNewBrandshow(String brand,double cost);
//    @Query("from Product p where p.category = ?1 and p.expiryDate < ?2")
//    List<Product> findByCatExp(String category,LocalDate expirydate);
//    // Named Query
//    @Query(name = "findByBrandExpiry")
//    List<Product> getByBrandExpiry(String brand,LocalDate expirydate);
//    @Query(name = "findByCatBrand")
//    @Query("from Product p where p.category = ?1 OR p.brand = ?2")
//    List<Product> findByCatBrand(String category,String brand);
//    @Query(name = "findByBrandName")
//    List<Product> findByBrandName(String brand,String name);
//    // Native Query
//    @Query(value = "select * from newproduct where cost between ?1 and ?2" ,nativeQuery = true)
//    List<Product> findByBetweenPrice(double minPrice,double maxPrice);
//    // modifying inbulit query
//    @Modifying
//    @Query(value = "update newproduct set cost = ?2 where product_id =?1",nativeQuery = true)
//    void updateProductCost(int productId, double price);


}
