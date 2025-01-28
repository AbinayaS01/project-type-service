package com.ust.capstone.project_type_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class ProjectTypeCategoryConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
