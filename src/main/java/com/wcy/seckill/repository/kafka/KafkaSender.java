package com.wcy.seckill.repository.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcy.seckill.model.Message;
import com.wcy.seckill.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: kafka producer
 * @author: wcy
 * @createdTime: 2019-01-02 15:44
 */

@Component
public class KafkaSender {

    private static Logger logger = LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send(String pId, int count) {
        Message msg = new Message();
        msg.setId(System.currentTimeMillis());
        msg.setpId(pId);
        msg.setCount(count);
        logger.info("======= message: ", msg.toString());
        kafkaTemplate.send("seckill", gson.toJson(msg));
    }

}
