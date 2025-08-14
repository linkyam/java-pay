package com.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.api.merchant")
public class PayApiConfig {

    private String apikey;

    private String mchId;

    private String callback;

    private String apiUrl;
}
