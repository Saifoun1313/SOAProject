package com.cloudproject.serviceproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProxyApplication.class, args);
    }

}
