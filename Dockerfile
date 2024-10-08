# Use an official OpenJDK image
FROM openjdk:23-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file
COPY target/producer-app-v1.jar /app/producer-app-v1.jar

# Expose the port on which the consumer runs
EXPOSE 8090

# Run the consumer application
ENTRYPOINT ["java", "-jar", "/app/producer-app-v1.jar"]