package com.wcy.seckill.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;

/**
 * @description: product model
 * @author: wcy
 * @createdTime: 2018-12-29 16:14
 */

@Document(collection = "ec.product")
public class Product {

    @NotNull
    @Id
    private String id;

    @NotNull
    private String name = null;

    @NotNull
    @Min(1)
    private int inventory = 0;

    public Product() {
    }

    public Product(String id) {
        this.id = id;
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String id, String name, int inventory) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getInventory() {
        return inventory;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Product {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
