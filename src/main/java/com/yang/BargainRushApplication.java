package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.yang.controller")
public class BargainRushApplication {

    public static void main(String[] args) {
        SpringApplication.run(BargainRushApplication.class, args);
    }

}
