package org.sid.shopBackEnd.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name="product")
@Data @AllArgsConstructor
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	@NotBlank(message="Please enter the name of product !")
	@Size(min=2,max=60,message="name size between 2 and 60 !")
	private String name;
	@NotBlank(message="Please enter the Brand of product !")
	private String brand;
	@JsonIgnore 
	@NotBlank(message="Please enter the description of product !")
	private String description;
	@Column(name = "unit_price")
	@NotNull(message="Please enter the description of product !")
	@Min(value=1,message="Please enter a valid price !")
	private double unitPrice;
	@Min(value=1,message="Please enter a valid quantity !")
	private int quantity;
	@Column(name = "is_active")
	private boolean active;
	@JsonIgnore
	private Long category_id;
	@JsonIgnore
	private Long supplier_id;
	private int purchases;
	private int views;
	@Transient
	private MultipartFile file;
	
	public Product() {
		this.code = "PROD"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}
}
