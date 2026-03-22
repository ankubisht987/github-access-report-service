package com.assessment.github_access_report_service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assessment.github_access_report_service.demo.AccessReportResponse;
import com.assessment.github_access_report_service.demo.GitHubRepo;
import com.assessment.github_access_report_service.demo.GitHubUser;
import com.assessment.github_access_report_service.demo.RepoAccessDetail;

@Service
public class GitHubService {

     private final RestTemplate restTemplate;

    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<AccessReportResponse> getOrganizationAccessReport(String orgName) {

        // 1. Fetch all repositories
        String repoUrl = "https://api.github.com/orgs/" + orgName + "/repos?per_page=100";
        GitHubRepo[] repos = restTemplate.getForObject(repoUrl, GitHubRepo[].class);

        // 2. Map to store user -> repos
        Map<String, List<RepoAccessDetail>> userMap = new HashMap<>();

        if (repos != null) {
            for (GitHubRepo repo : repos) {

                String repoName = repo.name();

                // 3. Fetch contributors for each repo
                String userUrl = "https://api.github.com/repos/" + orgName + "/" + repoName + "/contributors";
                GitHubUser[] users = restTemplate.getForObject(userUrl, GitHubUser[].class);

                if (users != null) {
                    for (GitHubUser user : users) {

                        String username = user.login();

                        // simple permission (fresher level)
                        String permission = "member";

                        // 4. Add to map
                        userMap.computeIfAbsent(username, k -> new ArrayList<>())
                               .add(new RepoAccessDetail(repoName, permission));
                    }
                }
            }
        }

        // 5. Convert map to response list
        List<AccessReportResponse> result = new ArrayList<>();

        for (Map.Entry<String, List<RepoAccessDetail>> entry : userMap.entrySet()) {
            result.add(new AccessReportResponse(entry.getKey(), entry.getValue()));
        }

        return result;
    }
}