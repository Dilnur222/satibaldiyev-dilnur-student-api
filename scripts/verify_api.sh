#!/usr/bin/env bash
set -euo pipefail

BASE="${BASE_URL:-http://localhost:8080/api/students}"
TMP="$(mktemp)"
trap 'rm -f "$TMP"' EXIT

echo "DevOps Midterm API verification — Dilnur Satibaldiyev (38036)"
echo "Target: $BASE"

code="$(curl -sS -o "$TMP" -w '%{http_code}' -X POST "$BASE" \
    -H 'Content-Type: application/json' \
    -d '{"name":"Dilnur","surname":"Satibaldiyev","groupName":"IT2-2304","studentId":38036}')"
echo "CREATE HTTP $code: $(cat "$TMP")"
[[ "$code" == 201 ]] || exit 1
ID="$(python3 -c 'import json,sys;print(json.load(open(sys.argv[1]))["id"])' "$TMP")"

code="$(curl -sS -o "$TMP" -w '%{http_code}' "$BASE")"
echo "LIST HTTP $code: $(cat "$TMP")"
[[ "$code" == 200 ]] || exit 1

code="$(curl -sS -o "$TMP" -w '%{http_code}' "$BASE/$ID")"
echo "READ HTTP $code: $(cat "$TMP")"
[[ "$code" == 200 ]] || exit 1

code="$(curl -sS -o "$TMP" -w '%{http_code}' -X PUT "$BASE/$ID" \
    -H 'Content-Type: application/json' \
    -d '{"name":"Dilnur","surname":"Satibaldiyev","groupName":"IT2-2304-Updated","studentId":38036}')"
echo "UPDATE HTTP $code: $(cat "$TMP")"
[[ "$code" == 200 ]] || exit 1

code="$(curl -sS -o "$TMP" -w '%{http_code}' "$BASE/999999")"
echo "MISSING HTTP $code: $(cat "$TMP")"
[[ "$code" == 404 ]] || exit 1

code="$(curl -sS -o "$TMP" -w '%{http_code}' -X DELETE "$BASE/$ID")"
echo "DELETE HTTP $code: $(cat "$TMP")"
[[ "$code" == 204 ]] || exit 1

code="$(curl -sS -o "$TMP" -w '%{http_code}' "$BASE/$ID")"
echo "VERIFY DELETION HTTP $code: $(cat "$TMP")"
[[ "$code" == 404 ]] || exit 1

echo 'All API checks passed on the running application.'
