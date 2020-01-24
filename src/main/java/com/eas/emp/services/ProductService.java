package com.eas.emp.services;

import com.eas.emp.dto.AddToCartDTO;
import com.eas.emp.model.AddToCartModel;
import com.eas.emp.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel>getAllProduct();

    ProductModel getSingleProduct(Integer productId);

    void addToCart(AddToCartDTO addToCartDTO);

    List<AddToCartModel> getAllFromCart();

    List<ProductModel> getAllProductByGender(Integer genderType);

    void deleteFromCart(int id);
}
