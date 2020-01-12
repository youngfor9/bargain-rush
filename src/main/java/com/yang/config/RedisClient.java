package com.yang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RedisClient {
    @Autowired
    RedisConfig redisConfig ;
    StringRedisTemplate template=redisConfig.getTemplate();

    public <T> T getString(String key,Class<T> clazz) {
        return (T) template.opsForValue().get(key);
    }
    public boolean setString(String key,String value,long time,TimeUnit unit){
        try {
            Duration duration =null;
            template.opsForValue().set(key,value,time,unit);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
    public boolean delString(String key){
        try {
           template.delete(key);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}
