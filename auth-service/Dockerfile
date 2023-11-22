FROM eclipse-temurin:17.0.4.1_1-jre

WORKDIR /app

COPY target/auth-service-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]