FROM eclipse-temurin:17.0.4.1_1-jre

WORKDIR /app
EXPOSE 8761
COPY ./target/discovery-server-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]