package com.eas.emp.repository;

import com.eas.emp.model.AddToFavoriteModel;
import com.eas.emp.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddToFavoriteRepository extends JpaRepository<AddToFavoriteModel,Integer> {
    @Query(value = "SELECT u FROM AddToFavoriteModel u WHERE u.product.product_no =:productId")
    AddToFavoriteModel findByProduct(int productId);

    void deleteAddToCartModelByProduct(ProductModel productModel);
}
