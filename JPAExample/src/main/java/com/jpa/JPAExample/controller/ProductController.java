package com.jpa.JPAExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.JPAExample.entity.Product;
import com.jpa.JPAExample.service.ProductService;


@RestController
public class ProductController {
	
	private ProductService product_service ;

	@Autowired
	public ProductController(ProductService e) {
		this.product_service = e;
	}

	@PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return product_service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return product_service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return product_service.getProducts();
    }

    @GetMapping("/productId/{id}")
    public Product findProductById(@PathVariable int id) {
        return product_service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return product_service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return product_service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return product_service.deleteProduct(id);
    }

}
