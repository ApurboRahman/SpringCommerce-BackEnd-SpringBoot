package com.eas.emp.controllers;

import com.eas.emp.dto.AddToCartDTO;
import com.eas.emp.model.AddToCartModel;
import com.eas.emp.model.ProductModel;
import com.eas.emp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productList")
    public List<ProductModel> getProductList() {
        return productService.getAllProduct();
    }

    @GetMapping("/productList/{genderType}")
    public List<ProductModel> getProductListByGender(@PathVariable Integer genderType) {
        return productService.getAllProductByGender(genderType);
    }

    @GetMapping("/singleProduct/{productId}")
    public ProductModel getSingleProduct(@PathVariable Integer productId) {
        return productService.getSingleProduct(productId);
    }

    @PostMapping("/addToCart")
    public void addToCart(@RequestBody AddToCartDTO addToCartDTO) {
        productService.addToCart(addToCartDTO);
    }

    @GetMapping("/cart")
    public List<AddToCartModel> getAllFromCart() {
        return productService.getAllFromCart();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteFromCart(@PathVariable int id){
        productService.deleteFromCart(id);
    }

}
