FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq

#Workspace
WORKDIR usr/share/seleniumDesignPattern
#Add .jar in target location from host
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

#Add Test Suitefiles
ADD payment-module.xml payment-module.xml
ADD search-module.xml search-module.xml

#Add Healthcheck
ADD healthcheck.sh healthcheck.sh

#Add browser , hubhost in the run time
ENTRYPOINT sh healthcheck.sh