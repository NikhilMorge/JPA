package com.jpa.JPAExample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.JPAExample.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);


}
