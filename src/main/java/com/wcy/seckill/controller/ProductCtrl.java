package com.wcy.seckill.controller;

import com.wcy.seckill.model.Product;
import com.wcy.seckill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @description: 商品相关API
 * @author: wcy
 * @createdTime: 2018-12-29 16:03
 */

@RequestMapping("api/v1.0/products")
@RestController
public class ProductCtrl {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/inventory/{id}")
    public int getProductById(@NotNull(message = "invalid id") @PathVariable String id) {
        return productService.getProductInventoryById(id);
    }

    @PutMapping("/seckill/{id}")
    public Product decreaseProInventoryById(@NotNull(message = "invalid id") @PathVariable String id) {
        return productService.updateProductInventoryById(id, 1);
    }
}
