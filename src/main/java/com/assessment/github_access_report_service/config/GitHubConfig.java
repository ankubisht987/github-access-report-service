package com.assessment.github_access_report_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GitHubConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}