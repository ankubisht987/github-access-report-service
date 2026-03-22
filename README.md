# GitHub Access Report Service

## 📌 Overview

This project is a backend service that integrates with GitHub API to generate an access report for a given organization.

It retrieves all repositories of an organization and maps users to the repositories they have access to.

---

## 🚀 Features

* Fetch repositories of a GitHub organization
* Retrieve users (contributors) for each repository
* Generate user → repository mapping
* Expose REST API endpoint
* Return structured JSON response

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* REST API
* GitHub API
* Maven

---

## ⚙️ How to Run the Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/your-username/github-access-report-service.git
cd github-access-report-service
```

---

### 2️⃣ Configure GitHub Token (Optional)

Open:

```
src/main/resources/application.properties
```

Add:

```properties
github.api.token=********************
```

> Note: Token is optional if using public APIs (contributors). Required for collaborators API.

---

### 3️⃣ Build the project

```bash
mvn clean install
```

---

### 4️⃣ Run the application

```bash
mvn spring-boot:run
```

Server will start on:

```
http://localhost:8080
```

---

## 🌐 API Endpoint

### Get Access Report

```http
GET /api/v1/report/{orgName}
```

### Example:

```http
GET http://localhost:8080/api/v1/report/cli
```

---

## 📊 Sample Response

```json
[
  {
    "username": "jtmcg",
    "repositories": [
      {
        "repoName": "cli",
        "permissions": "member"
      },
      {
        "repoName": "oauth",
        "permissions": "member"
      }
    ]
  },
  {
    "username": "mislav",
    "repositories": [
      {
        "repoName": "cli",
        "permissions": "member"
      }
    ]
  }
]
```

---

## 🧠 How It Works

1. Fetch repositories using GitHub API
2. For each repository, fetch contributors
3. Transform data from:

   * Repository → Users
     to
   * User → Repositories
4. Return aggregated result

---

## ⚠️ Assumptions

* Using contributors API as a proxy for access
* Only public repositories are considered
* Permissions are simplified as "member"

---

## 📈 Scalability Considerations

* Supports organizations with 100+ repositories
* Can handle large user datasets
* Can be optimized further using:

  * Parallel API calls
  * Pagination handling

---

## ❗ Error Handling

* Handles GitHub API errors (4xx, 5xx)
* Returns meaningful error messages

---

## 👨‍💻 Author

Ankush Bisht

---

## 📌 Future Improvements

* Use GitHub collaborators API with authentication
* Add caching
* Implement parallel processing for better performance
* Add UI dashboard
