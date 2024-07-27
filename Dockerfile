# Use the official Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download the dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Use the official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/shawarmaHouse-0.0.1-SNAPSHOT.jar app.jar

# Expose port 9090
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "shawarmaHouse-0.0.1-SNAPSHOT.jar app.jar"]
