# Stage 1: Build the JAR
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/payment-sim-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]