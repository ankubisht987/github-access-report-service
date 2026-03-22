package com.assessment.github_access_report_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.github_access_report_service.demo.AccessReportResponse;
import com.assessment.github_access_report_service.service.GitHubService;

@RestController
@RequestMapping("/api/v1/report")
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/{orgName}")
    public List<AccessReportResponse> getReport(@PathVariable String orgName) {
        return gitHubService.getOrganizationAccessReport(orgName);
    }
}