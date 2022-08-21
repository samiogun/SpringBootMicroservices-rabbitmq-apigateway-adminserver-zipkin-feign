package org.ersun.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "org.ersun.feign")
public class NotificationServieApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServieApplication.class, args);
    }
}
