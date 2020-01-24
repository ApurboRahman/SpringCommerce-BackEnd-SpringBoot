package com.eas.emp.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue
    private int id;
    private int product_no;
    private String product_name;
    private String product_gender;
    private String product_category;
    private String product_color;
    private String product_size;
    private String product_tag;
    private String product_price;
    private String product_image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_no() {
        return product_no;
    }

    public void setProduct_no(int product_no) {
        this.product_no = product_no;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_gender() {
        return product_gender;
    }

    public void setProduct_gender(String product_gender) {
        this.product_gender = product_gender;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getProduct_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    public String getProduct_size() {
        return product_size;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    public String getProduct_tag() {
        return product_tag;
    }

    public void setProduct_tag(String product_tag) {
        this.product_tag = product_tag;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
    //getter setter
}
