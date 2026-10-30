# Linux administration evidence commands

```bash
mkdir -p scripts logs backups src
ls -la
chmod 744 scripts/Satibaldiyev_Dilnur_system_report.sh
./scripts/Satibaldiyev_Dilnur_system_report.sh
ls -l scripts/Satibaldiyev_Dilnur_system_report.sh
cp README.md backups/Satibaldiyev_Dilnur_README_backup.md
cat backups/Satibaldiyev_Dilnur_README_backup.md
ps aux | head -n 15
ps aux | grep '[j]ava' || true
tail -n 5 logs/Satibaldiyev_Dilnur_system_report.log
grep 'Satibaldiyev' logs/Satibaldiyev_Dilnur_system_report.log > Satibaldiyev_Dilnur_log_analysis.txt
```

`>` replaces the destination file contents, while `>>` appends to it. Logs and backups are generated locally and intentionally not committed to Git.
