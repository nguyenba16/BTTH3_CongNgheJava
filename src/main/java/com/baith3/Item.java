package com.baith3;

public class Item {
    private String name;
    private String brand;
    private double price;
    private String imagePath;
    private String desc;
   

    public Item(String name, String brand, double price, String desc, String imagePath) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.imagePath = imagePath;
        this.desc = desc;
    }
 
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
