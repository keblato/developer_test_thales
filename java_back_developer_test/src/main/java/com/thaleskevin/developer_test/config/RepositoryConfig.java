package com.thaleskevin.developer_test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "employee-repository")
public class RepositoryConfig {
    private String api;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
