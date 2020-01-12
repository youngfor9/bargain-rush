package com.yang.controller;
import com.yang.config.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    RedisClient redisClient;

    @RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/index")
    public String setKey(String key,String value) {
        boolean res = redisClient.setString(key, value, 5, TimeUnit.MINUTES);
        return null;
    }
}
