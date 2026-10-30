# Additional CI verification

GitHub Actions is configured in `.github/workflows/gradle-ci.yml` to compile and test the Spring Boot application on Java 17 and Gradle 8.10.2.

The job is distinct from the required Jenkins Pipeline, which must run on the student's authorized Ubuntu/Jenkins environment.

The verification PR is meant to trigger a real GitHub Actions test run. Screenshots of a passing job should be taken only after GitHub reports success.
