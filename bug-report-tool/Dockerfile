# Dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/bug-report-tool-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
