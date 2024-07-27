# Use the official Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS build

COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.12-jdk-slim
#COPY --from=build /target/the-shawarma-hub.jar the-shawarma-hub.jar
#EXPOSE 8080
ENTRYPOINT ["java","-jar","the-shawarma-hub.jar"]
# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/the-shawarma-hub.jar the-shawarma-hub.jar

# Expose port 9090
EXPOSE 9090

# Run the application
#ENTRYPOINT ["java", "-jar", "/the-shawarma-hub.jar"]
