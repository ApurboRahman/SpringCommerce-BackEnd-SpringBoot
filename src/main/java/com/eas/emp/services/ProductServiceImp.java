package com.eas.emp.services;

import com.eas.emp.dto.AddToCartDTO;
import com.eas.emp.model.AddToCartModel;
import com.eas.emp.model.ProductModel;
import com.eas.emp.repository.AddToCartRepository;
import com.eas.emp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    AddToCartRepository addToCartRepository;

    @Override
    public List<ProductModel> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel getSingleProduct(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public void addToCart(AddToCartDTO addToCartDTO) {

        AddToCartModel cartModel = addToCartRepository.findByProduct(addToCartDTO.getProduct_id());
        if (cartModel != null) {
            cartModel.setQuantity(cartModel.getQuantity() + addToCartDTO.getQuantity());
        } else {
            cartModel = new AddToCartModel();
            cartModel.setAmount(addToCartDTO.getAmount());
            cartModel.setUserTrackId(addToCartDTO.getUserTrackId());
            cartModel.setProduct(productRepository.getOne(addToCartDTO.getProduct_id()));
            cartModel.setQuantity(addToCartDTO.getQuantity());
        }
        addToCartRepository.save(cartModel);
    }

    @Override
    public List<AddToCartModel> getAllFromCart() {
        return addToCartRepository.findAll();
    }

    @Override
    public List<ProductModel> getAllProductByGender(Integer genderType) {
        if (genderType == 1) {
            return productRepository.findByProduct_gender("Men");
        } else if (genderType == 2) {
            return productRepository.findByProduct_gender("Ladies");
        } else {
            return productRepository.findAll();
        }

    }

    @Override
    public void deleteFromCart(int id) {
        addToCartRepository.deleteById(id);
    }
}
