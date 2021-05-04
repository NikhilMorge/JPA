package com.jpa.JPAExample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_data")
public class Product {

	@Id	
	@GeneratedValue
	private int id;
	private String name;
	private int quantity;
	private int price;
	
}
