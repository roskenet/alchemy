#!/bin/bash

/opt/init-db.sh

# Starte Supervisor – es verwaltet alle Dienste (Postgres, Kafka, Zookeeper, Nakadi)
exec /usr/bin/supervisord -n -c /etc/supervisor/conf.d/supervisord.conf

