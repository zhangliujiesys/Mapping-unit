package com.aaa.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer6082 {
    public static void main(String[] args) {
            SpringApplication.run(EurekaServer6082.class,args);
    }
}
