package com.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Program startup class
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.api.*"})
@EnableConfigurationProperties
public class MerchantApplication {

    public static void main(String[] args) {
        try {
            log.info("MerchantApplication Starting");
            SpringApplication.run(MerchantApplication.class, args);
            log.info("MerchantApplication Started");
        } catch (Exception e) {
            log.info("MerchantApplication startup failed, e:{}", e);
        }
    }
}
