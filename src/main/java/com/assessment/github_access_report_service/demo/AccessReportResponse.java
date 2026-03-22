package com.assessment.github_access_report_service.demo;

import java.util.List;

public record AccessReportResponse(
    String username,
    List<RepoAccessDetail> repositories // Check that this name is exactly RepoAccessDetail
) {}