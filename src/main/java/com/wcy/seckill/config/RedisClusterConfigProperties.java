package com.wcy.seckill.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 获取redis cluster配置项
 * @author: wcy
 * @createdTime: 2018-12-28 16:18
 */

@Component
@ConfigurationProperties("spring.redis.cluster")
public class RedisClusterConfigProperties {

    private List<String> nodes;

    private Integer maxRedirects = 3;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public Integer getMaxRedirects() {
        return maxRedirects;
    }

    public void setMaxRedirects(Integer maxRedirects) {
        this.maxRedirects = maxRedirects;
    }
}