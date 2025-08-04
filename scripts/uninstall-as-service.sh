#!/bin/bash
set -e

if [ "$EUID" -ne 0 ]; then
    echo 'Please run as root.'
    exit 1
fi

systemctl disable springhomepage.service
rm /etc/systemd/system/springhomepage.service

echo 'Done.'
