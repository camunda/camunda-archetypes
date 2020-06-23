#!/bin/sh
mvn clean install --projects camunda-archetype-demo
cd camunda-archetype-demo/target/test-classes/projects/basic/project/basic-servlet-jar/
chromium-browser --incognito http://localhost:8080/camunda
mvn wildfly:deploy
