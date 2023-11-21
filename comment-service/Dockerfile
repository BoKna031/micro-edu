FROM openjdk:17-slim

WORKDIR /app

COPY target/comment-service-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]