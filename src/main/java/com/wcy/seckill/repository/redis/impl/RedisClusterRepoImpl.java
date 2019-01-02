package com.wcy.seckill.repository.redis.impl;

import com.wcy.seckill.repository.redis.RedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @description: redis cluster service implement
 * @author: wcy
 * @createdTime: 2018-12-29 15:52
 */

@Service
public class RedisClusterRepoImpl implements RedisRepo {

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    @Override
    public Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String key, Class<? extends Serializable> requiredType) {
        Serializable val = redisTemplate.opsForValue().get(key);
        if (val == null) {
            return null;
        }
        return ((T)val);
    }

    @Override
    public boolean remove(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public void saveObject(String key, Serializable object) {
        redisTemplate.opsForValue().set(key, object);
    }

    @Override
    public void saveIfAbsent(String key, Serializable object) {
        redisTemplate.opsForValue().setIfAbsent(key, object);
    }

    @Override
    public void saveObjectWithExpireTime(String key, Serializable object, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, object, timeout, unit);
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public long increment(String key, int count) {
        return redisTemplate.opsForValue().increment(key, count);
    }

    @Override
    public void getAndSet(String key, Serializable object) {
        redisTemplate.opsForValue().getAndSet(key, object);
    }
}
