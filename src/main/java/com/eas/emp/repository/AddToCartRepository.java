package com.eas.emp.repository;

import com.eas.emp.model.AddToCartModel;
import com.eas.emp.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddToCartRepository extends JpaRepository<AddToCartModel,Integer> {
    @Query(value = "SELECT u FROM AddToCartModel u WHERE u.product.product_no =:productId")
    AddToCartModel findByProduct(int productId);


    void deleteAddToCartModelByProduct(ProductModel productModel);
}
