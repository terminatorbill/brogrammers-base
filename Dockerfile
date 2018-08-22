FROM openjdk:8u181-jre-slim
MAINTAINER Christidis Nikolaos Bill Soumakis

WORKDIR /var/brogrammers-base

ADD target/base-1.0-jar-with-dependencies.jar /var/brogrammers-base/base.jar

ENTRYPOINT ["java", "-jar", "base.jar"]