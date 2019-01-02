package com.wcy.seckill.service;

import com.wcy.seckill.model.Product;

/**
 * @description: product 相关操作
 * @author: wcy
 * @createdTime: 2018-12-29 17:10
 */
public interface ProductService {

    /**
     * 创建商品
     * @param product
     * @return Product
     */
    public Product createProduct(Product product);

    /**
     * 通过id获取商品库存
     * @param id
     * @return int
     */
    public int getProductInventoryById(String id);

    /**
     * 通过id更新商品的库存
     * @param id, 商品id
     * @param count, 为需要减去的库存数量
     * @return Product
     */
    public Product updateProductInventoryById(String id, int count);
}
