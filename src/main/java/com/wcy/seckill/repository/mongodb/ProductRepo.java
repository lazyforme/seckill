package com.wcy.seckill.repository.mongodb;

import com.wcy.seckill.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @description: product
 * @author: wcy
 * @createdTime: 2019-01-02 10:57
 */
public interface ProductRepo extends MongoRepository<Product, String> {
}
