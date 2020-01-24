package com.eas.emp.dto;

public class AddToCartDTO {
    private int product_id;
    private int amount;
    private String userTrackId;
    private int quantity;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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
}
