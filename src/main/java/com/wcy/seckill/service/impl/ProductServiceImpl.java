package com.wcy.seckill.service.impl;

import com.wcy.seckill.model.Product;
import com.wcy.seckill.repository.kafka.KafkaSender;
import com.wcy.seckill.repository.mongodb.ProductRepo;
import com.wcy.seckill.repository.redis.RedisRepo;
import com.wcy.seckill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: product service 接口的实现
 * @author: wcy
 * @createdTime: 2018-12-29 17:22
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RedisRepo redisRepo;

    @Autowired
    private ProductRepo mongoProductRepo;

    @Autowired
    private KafkaSender kafkaSender;

    @Override
    public Product createProduct(Product product) {
        String key = product.getId();
        int count = product.getInventory();
        redisRepo.saveIfAbsent(key, count);
        Product result = mongoProductRepo.insert(product);
        return result;
    }

    @Override
    public int getProductInventoryById(String id) {
        boolean flag = redisRepo.hasKey(id);
        if (!flag) {
            return -1;
        }
        return (int)redisRepo.getObject(id);
    }

    @Override
    public Product updateProductInventoryById(String id, int count) {
        boolean flag = redisRepo.hasKey(id);
        if (!flag) {
            return null;
        }
        int inventory = (int)redisRepo.getObject(id);
        if (inventory - count < 0) {
            return null;
        }
        redisRepo.getAndSet(id, inventory-count);
        //TODO 连接kafka，发送消息，库存减去count，有一个消费端去消费该消息，操作数据库进行库存实际的增减
        kafkaSender.send(id, count);
        return new Product(id, null, inventory-count);
    }
}
