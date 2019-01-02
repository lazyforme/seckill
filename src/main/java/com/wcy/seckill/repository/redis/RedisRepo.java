package com.wcy.seckill.repository.redis;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @description: redis 各种操作接口
 * @author: wcy
 * @createdTime: 2018-12-29 15:42
 */

public interface RedisRepo {

    /**
     * get object from redis by key
     * @param key
     * @return Object
     */
    public Object getObject(String key);

    /**
     * get class from redis by key
     * @param key
     * @param requiredType
     * @param <T>
     * @return class
     */
    public <T> T get(String key, Class<? extends Serializable> requiredType);

    /**
     * remvoe key
     * @param key
     * @return
     */
    public boolean remove(String key);

    /**
     * save object
     * @param key
     * @param object
     */
    public void saveObject(String key, Serializable object);

    /**
     * save object that is not exists
     * @param key
     * @param object
     */
    public void saveIfAbsent(String key, Serializable object);

    /**
     * save object with expire time
     * @param key
     * @param object
     * @param timeout
     * @param unit
     */
    public void saveObjectWithExpireTime(String key, Serializable object, long timeout, TimeUnit unit);

    /**
     * whether the key exists
     * @param key
     * @return
     */
    public boolean hasKey(String key);

    /**
     * 自增count
     * @param key
     * @param count
     * @return
     */
    public long increment(String key, int count);

    /**
     * get and set object
     * @param key
     * @param object
     */
    public void getAndSet(String key, Serializable object);
}
