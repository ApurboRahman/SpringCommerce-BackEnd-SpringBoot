package com.eas.emp.model;

import javax.persistence.*;

@Entity
@Table(name = "addtofavorite")
public class AddToFavoriteModel {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="productId", nullable=false)
    private ProductModel product;

    private int amount;
    private String userTrackId;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUserTrackId() {
        return userTrackId;
    }

    public void setUserTrackId(String userTrackId) {
        this.userTrackId = userTrackId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //getter setter
}
