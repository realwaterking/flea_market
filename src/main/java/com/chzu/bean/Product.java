package com.chzu.bean;

public class Product {

    private int product_id;
    private String product_name;
    private String product_price;
    private String product_description;
    private int product_quantity;

    public Product() {
    }

    public Product(int product_id, String product_name, String product_price
            , String product_description, int product_quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.product_quantity = product_quantity;
    }

    public Product(String product_name, String product_price
            , String product_description, int product_quantity) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.product_quantity = product_quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name=" + product_name +
                ", product_price=" + product_price +
                ", product_description=" + product_description +
                ", product_quantity=" + product_quantity +
                '}';
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }
}
