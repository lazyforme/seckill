package com.wcy.seckill.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisClusterConfigTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static Logger logger = LoggerFactory.getLogger(RedisClusterConfigTest.class);

    @Test
    public void redisTest() {
        String key = "p1";
        int value = 100;

        ValueOperations opsForValue = redisTemplate.opsForValue();

        //数据插入测试：
        opsForValue.set(key, value);
        int valueFromRedis = (int) opsForValue.get(key);
        logger.info("redis value after set: {}", valueFromRedis);

        opsForValue.increment(key, (long)10);
        valueFromRedis = (int) opsForValue.get(key);
        logger.info("redis value after increment -10: {}", valueFromRedis);

        //数据删除测试：
//        redisTemplate.delete(key);
//        valueFromRedis = (String) opsForValue.get(key);
//        logger.info("redis value after delete: {}", valueFromRedis);
//        assertThat(valueFromRedis, equalTo(null));

    }
}