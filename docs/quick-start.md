# Quick start on Ubuntu

```bash
git clone https://github.com/Dilnur222/satibaldiyev-dilnur-student-api.git
cd satibaldiyev-dilnur-student-api
git log --oneline --graph --all
chmod 744 scripts/Satibaldiyev_Dilnur_system_report.sh
./scripts/Satibaldiyev_Dilnur_system_report.sh
gradle --no-daemon clean test
gradle --no-daemon bootRun
```

For PostgreSQL / Docker, create a private `.env` from `.env.example` with a strong password:

```bash
cp .env.example .env
nano .env
docker compose up -d --build
docker compose ps
curl -i http://localhost:8080/api/students
```

Run the service only after Docker has been installed and permissions configured. The public GitHub repository demonstrates source and history, not the private execution on your Ubuntu machine.
