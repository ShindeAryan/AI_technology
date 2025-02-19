FROM maven:3.8.6-openjdk-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package


FROM openjdk:21
WORKDIR /app
COPY --from=build /app/target/AI_technology-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]