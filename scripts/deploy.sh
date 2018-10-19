#!/bin/bash
# Deployment script for TBME Labs Actuator Endpoints Security Utils
# https://github.com/tbmelabs/actuator-endpoints-security-utils

if [[ $TRAVIS_BRANCH == "master" && $TRAVIS_PULL_REQUEST == "false" ]] ; then
  mvn deploy -Psign,build-extras -DskipTests
fi

