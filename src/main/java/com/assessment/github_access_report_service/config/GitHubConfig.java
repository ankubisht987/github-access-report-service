package com.assessment.github_access_report_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GitHubConfig {

    @Value("${github.api.token}")
    private String token;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + token);
            request.getHeaders().add("Accept", "application/vnd.github+json");
            return execution.execute(request, body);
        });

        return restTemplate;
    }
}