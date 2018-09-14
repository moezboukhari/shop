package org.sid.shopBackEnd.dao;

import org.sid.shopBackEnd.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
