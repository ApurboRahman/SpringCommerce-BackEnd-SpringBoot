package com.eas.emp.repository;

import com.eas.emp.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {

    @Query("SELECT r FROM ProductModel r where r.product_gender = :name")
    List<ProductModel> findByProduct_gender(@Param("name") String name);

}
