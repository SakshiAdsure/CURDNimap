package com.nimap.curd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private int prod_id;

    @Column(name = "prod_name", nullable = false)
    private String prod_name;

    @Column(name = "prod_price")
    private int prod_price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_id")
    @JsonBackReference 
    private Category category;

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public int getProd_price() {
        return prod_price;
    }

    public void setProd_price(int prod_price) {
        this.prod_price = prod_price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {  
        this.category = category;
    }
}