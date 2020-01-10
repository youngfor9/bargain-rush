package com.yang.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;
@Component
public class RedisConfig {
    private StringRedisTemplate template;
    @Autowired
    RedisPoolInfo redisPoolInfo;
    @Autowired
    public RedisConfig() {
        StringRedisTemplate template =new StringRedisTemplate();
        JedisConnectionFactory factory = new JedisConnectionFactory(getConfiguration(), getJedisPoolConfig());
        template.setConnectionFactory(factory);
        this.template = template;
    }
    public JedisClientConfiguration getJedisPoolConfig(){
        JedisClientConfiguration configuration = null;

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisPoolInfo.getMaxIdle());
        jedisPoolConfig.setMaxTotal(redisPoolInfo.getMaxIdle());
        jedisPoolConfig.setMaxTotal(redisPoolInfo.getTotal());
        jedisPoolConfig.setTestOnBorrow(redisPoolInfo.getTestOnBorrow());
        jedisPoolConfig.setTestOnBorrow(redisPoolInfo.getTestOnBorrow());
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder builder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        builder.poolConfig(jedisPoolConfig);
        return  builder.build();
    }
    public RedisStandaloneConfiguration getConfiguration(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisPoolInfo.getHost(), redisPoolInfo.getPort());
        redisStandaloneConfiguration.setPassword(redisPoolInfo.getPass());
        return redisStandaloneConfiguration;
    }

    public StringRedisTemplate getTemplate() {
        return template;
    }
}
