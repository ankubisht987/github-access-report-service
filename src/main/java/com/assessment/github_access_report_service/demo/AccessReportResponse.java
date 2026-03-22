package com.assessment.github_access_report_service.demo;

import java.util.List;

public class AccessReportResponse {

    private String username;
    private List<RepoAccessDetail> repositories;

    // Constructor
    public AccessReportResponse(String username, List<RepoAccessDetail> repositories) {
        this.username = username;
        this.repositories = repositories;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public List<RepoAccessDetail> getRepositories() {
        return repositories;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setRepositories(List<RepoAccessDetail> repositories) {
        this.repositories = repositories;
    }
}