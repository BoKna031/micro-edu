FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/auth-service-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]