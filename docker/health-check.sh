#!/usr/bin/env bash
STATUS=$(wget --no-check-certificate --spider -S "${HEALTH_CHECK_URL}" 2>&1 | grep "HTTP/" | awk '{print $2}')
if [[ ${STATUS} -eq 200 ]]; then
    echo "0"
else
    exit "1"
fi