#!/bin/sh
set -e
export SERVICEMOCK_NAME=servicemock-$HOSTNAME
java -jar /app/servicemock-1.0.0.jar
