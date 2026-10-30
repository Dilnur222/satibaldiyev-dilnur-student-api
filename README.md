# Satibaldiyev Dilnur — Student API

**DevOps Midterm Project**

- Student: Dilnur Satibaldiyev
- Group: IT2-2304
- Student ID: 38036
- GitHub: [Dilnur222](https://github.com/Dilnur222)
- Technology: Java 17, Spring Boot, Gradle, PostgreSQL, Docker Compose and Jenkins

## CRUD operations

| Method | URL | Purpose |
|---|---|---|
| POST | `/api/students` | Create a student |
| GET | `/api/students` | List all students |
| GET | `/api/students/{id}` | Get a student by ID |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |

Missing student IDs result in HTTP 404.

## Local development

Requires Java 17 and Gradle 8.10.x:

```bash
gradle clean test
gradle bootRun
```

The local default is an in-memory H2 database. Run requests against
`http://localhost:8080/api/students`.

## Docker Compose

```bash
cp .env.example .env
# Set a random private password in .env
docker compose up -d --build
docker compose ps
```

The application connects to PostgreSQL via hostname `database` on the Compose network. The named PostgreSQL volume preserves records between restarts.

## Jenkins

Create a Pipeline job called `Satibaldiyev_Dilnur_Student_API` and use `Jenkinsfile` from branch `main`. The stages are Checkout, Build, Test, Docker Build and Verify.

**Note:** Source publication and commits do not by themselves prove that Gradle, Docker or Jenkins ran successfully on Ubuntu.

Documentation status: Feature branch CRUD documentation.
