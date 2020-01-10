package com.yang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisService {
    @Autowired
    RedisConfig redisConfig;
    public <T> T getString(String key,Class clazz) {
        StringRedisTemplate template = redisConfig.getTemplate(key);
        return (T) template.opsForValue().get(key);
    }
    public <T> setString(){
        redisConfig.get
    }
}
