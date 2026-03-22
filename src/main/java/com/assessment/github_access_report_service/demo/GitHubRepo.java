package com.assessment.github_access_report_service.demo;

public record GitHubRepo(
    String name,
    Owner owner
) {}

record Owner(String login) {}