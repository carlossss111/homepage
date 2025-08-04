#!/bin/bash
set -e

if [ "$EUID" -ne 0 ]; then
    echo 'Please run as root.'
    exit 1
fi
if [ -z "$1" ]; then
    echo 'USAGE: ./scripts/install-as-service.sh <path-to-jar-file>'
    exit 1
fi
JAR_FILEPATH="$1"

cp springhomepage.service /etc/systemd/system/springhomepage.service

sed -i "s|<JAVA_HOME>|${JAVA_HOME}|" /etc/systemd/system/springhomepage.service
sed -i "s|<JAR_FILEPATH>|${JAR_FILEPATH}|" /etc/systemd/system/springhomepage.service
sed -i "s|<API_KEY>|${API_KEY}|" /etc/systemd/system/springhomepage.service
sed -i "s|<LAT>|${LAT}|" /etc/systemd/system/springhomepage.service
sed -i "s|<LON>|${LON}|" /etc/systemd/system/springhomepage.service

systemctl daemon-reload
systemctl enable springhomepage.service
systemctl start springhomepage.service

echo 'Done.'
