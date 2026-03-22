package com.assessment.github_access_report_service.demo;

import java.util.Map;

public record GitHubUser(String login, Map<String, Boolean> permissions) {}