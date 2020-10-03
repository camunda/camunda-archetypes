#!/bin/sh
mvn clean install --projects camunda-archetype-spring-boot-demo
cd camunda-archetype-spring-boot-demo/target/test-classes/projects/basic/project/spring-boot-jar/
chromium-browser --incognito http://localhost:8080/
mvn spring-boot:run
