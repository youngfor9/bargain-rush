package com.yang.config;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix="redis")
public class RedisPoolInfo {
    private String host;
    private int port;
    private String pass;
    private int maxIdle;
    private int maxActive;
    private int total;
    private Boolean testOnBorrow;
    private Boolean testOnBeturn;

}
