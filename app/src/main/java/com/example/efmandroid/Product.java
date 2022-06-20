package com.example.efmandroid;

import java.io.Serializable;

public class Product implements Serializable {
    private String title;
    private String description;
    private String brand;
    private String category;
    private String pic1;
    private String pic2;
    private String pic3;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public Product() {
    }

    public Product(String title, String description, String brand, String category, String pic1, String pic2, String pic3) {
        this.title = title;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
    }

}
