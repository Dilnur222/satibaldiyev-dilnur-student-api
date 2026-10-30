# Evidence checklist — DevOps Midterm

Capture **actual screenshots on your own Ubuntu VM**. These commands are prepared but remote Ubuntu execution was not performed merely by publishing to GitHub.

## Linux
- Project directory: `ls -la` and `find . -maxdepth 2 -type f`
- Monitoring: `./scripts/Satibaldiyev_Dilnur_system_report.sh`
- Permissions: `ls -l scripts/Satibaldiyev_Dilnur_system_report.sh`
- Backup: `cp README.md backups/Satibaldiyev_Dilnur_README_backup.md`, then `cat backups/Satibaldiyev_Dilnur_README_backup.md`
- Logs: `tail -n 5 logs/Satibaldiyev_Dilnur_system_report.log`
- Analysis: `grep Satibaldiyev logs/Satibaldiyev_Dilnur_system_report.log`

## Git and GitHub
- Remote repository branches, meaningful commits, and merge commits (view online)
- `git log --oneline --graph --all`
- `git branch -a` and `git tag`
- Create the required `v1.0-38036` tag **from the latest main commit** if not present (GitHub Releases UI can create a tag)

## Docker
- `docker compose up -d --build`
- `docker compose ps` (PostgreSQL healthy and API running)
- `docker compose logs student-api`
- `docker exec satibaldiyev-dilnur-api java -version`
- Run `./scripts/verify_api.sh` while the API is running
- `docker compose restart` and check PostgreSQL data persistence before deleting the test record

## Jenkins
- Configure job `Satibaldiyev_Dilnur_Student_API`, SCM Git branch `main`, Pipeline path `Jenkinsfile`
- Screenshot real stages Checkout, Build, Test, Docker Build, Verify
- Demonstrate controlled error from the test-failure branch before its fix and subsequent green build
- Enable Poll SCM (e.g. `H/2 * * * *`); after a new commit, show the automated build

## Important
Do not present illustrations, Git commits, or GitHub Actions as proof of Jenkins execution. CI result, container logs and screenshot evidence must come from actual runs.
