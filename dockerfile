FROM openjdk:17-jdk-alpine
MAINTAINER Treboder
COPY target/MegaChatApp-0.0.1-SNAPSHOT.jar MegaChatApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/MegaChatApp-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080