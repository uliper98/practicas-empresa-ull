# Base image
FROM openjdk:8-jdk-alpine

MAINTAINER info@kaizten.com

VOLUME /tmp
EXPOSE 8080

# Copy JAR
COPY target/kaizten-red-task-0.0.1-SNAPSHOT.jar app.jar

# Execution
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
