# Jenkins configuration

Job name: `Satibaldiyev_Dilnur_Student_API`.

- Job type: Pipeline
- Definition: Pipeline script from SCM
- SCM: Git
- Repository: https://github.com/Dilnur222/satibaldiyev-dilnur-student-api.git
- Branch: `*/main`
- Script path: `Jenkinsfile`
- Requirements on agent: Java 17, Gradle 8.10.x, Git, Docker build capability

For a local Ubuntu VM, Jenkins Poll SCM trigger can use `H/2 * * * *`.

Never store passwords in Jenkinsfile; use Jenkins Credentials. Do not claim pipeline SUCCESS unless Jenkins has actually run.
