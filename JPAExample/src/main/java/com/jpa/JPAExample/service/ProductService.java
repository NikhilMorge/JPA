package com.jpa.JPAExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.JPAExample.entity.Product;
import com.jpa.JPAExample.repository.ProductRepository;

@Service
@Transactional
public class ProductService  {
	
    @Autowired
	private ProductRepository product_repository;
    
    public Product saveProduct(Product product) {
		return product_repository.save(product);
	}
	
  
	public List<Product> saveProducts(List<Product> products) {
		return product_repository.saveAll(products);
	}
	
 
	public List<Product> getProducts() {
		return product_repository.findAll();
	}
	
 
	public Product getProductById(int id) {
		return product_repository.findById(id).orElse(null);
	}


    public Product getProductByName(String name) {
        return product_repository.findByName(name);
    }


    public String deleteProduct(int id) {
    	product_repository.deleteById(id);
        return "product removed !! " + id;
    }


    public Product updateProduct(Product product) {
        Product existingProduct = product_repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return product_repository.save(existingProduct);
    }

}
