#!/usr/bin/env bash
set -euo pipefail
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
LOG_FILE="$SCRIPT_DIR/../logs/Satibaldiyev_Dilnur_system_report.log"
mkdir -p "$(dirname "$LOG_FILE")"
{
  echo '======================================'
  echo 'Student: Dilnur Satibaldiyev'
  echo 'Group: IT2-2304'
  echo 'Student ID: 38036'
  echo "Date: $(date)"
  echo "Username: $(whoami)"
  echo "Operating System: $(. /etc/os-release && echo "$PRETTY_NAME")"
  echo "Kernel: $(uname -r)"
  echo 'CPU:'
  lscpu | grep -E '^Model name:|^CPU\(s\):' || true
  echo 'Memory:'
  free -h
  echo 'Disk space and usage:'
  df -h /
  echo '======================================'
} | tee -a "$LOG_FILE"
