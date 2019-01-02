package com.wcy.seckill.repository.kafka;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcy.seckill.model.Message;
import com.wcy.seckill.model.Product;
import com.wcy.seckill.repository.mongodb.ProductRepo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @description: kafka receive
 * @author: wcy
 * @createdTime: 2019-01-02 16:07
 */

@Component
public class KafkaReceiver {

    private static Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);

    @Autowired
    private ProductRepo productRepo;

    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = {"seckill"})
    private void listen(ConsumerRecord<?,?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object obj = kafkaMessage.get();
            logger.info("message = ", obj.toString());
            Message msg = JSON.parseObject(obj.toString(), Message.class);
            String pId = msg.getpId();
            int count = msg.getCount();
            Product product = productRepo.findById(pId).get();
            product.setInventory(product.getInventory()-count);
            productRepo.save(product);
        }

    }

}
