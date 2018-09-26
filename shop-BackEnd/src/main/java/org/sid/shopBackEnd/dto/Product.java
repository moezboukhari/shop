package org.sid.shopBackEnd.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name="product")
@Data @AllArgsConstructor
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private String brand;
	@JsonIgnore 
	private String description;
	@Column(name = "unit_price")
	private double unitPrice;
	private int quantity;
	@JsonIgnore
	@Column(name = "is_active")
	private boolean active;
	@JsonIgnore
	private Long category_id;
	@JsonIgnore
	private Long supplier_id;
	private int purchases;
	private int views;
	
	
	
	public Product() {
		this.code = "PROD"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}

}
