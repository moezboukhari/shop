package org.sid.shopBackEnd.dao;

import java.util.List;

import org.sid.shopBackEnd.dto.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.Long;

public interface ProductRepository extends JpaRepository<Product, Long> {
	 @Query("select p from product p where p.category_id = :category_id")
	List<Product> findByCategory_id(@Param(value="category_id") Long category_id);
	
    @Query("select p from product p where p.active = :active")
	List<Product> findByIs_active(@Param(value = "active") boolean active);
    
    @Query("select p from product p where p.active = :active order by id")
    Page<Product> getLatestActiveProduct(@Param(value = "active") boolean active,Pageable pageable );
    
}
