#!/bin/sh
cd ..
mvn clean install --projects camunda-archetype-servlet-war-demo
cd camunda-archetype-servlet-war-demo/target/test-classes/projects/basic/project/basic-servlet-jar/
chromium-browser --incognito http://localhost:8080/camunda
mvn wildfly:deploy
