# Use an official OpenJDK runtime as a parent image
FROM openjdk:18-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container at /app
COPY target/spring-boot-todoo-app-0.0.1-SNAPSHOT.jar /app/spring-boot-todoo-app.jar

# Copy the downloaded Lumigo OpenTelemetry JAR into the container at /app
#COPY lumigo-opentelemetry-0.7.0.jar /app/lumigo-opentelemetry-0.7.0.jar

# Set JAVA_TOOL_OPTIONS for the Lumigo OpenTelmetry JAR
#ENV JAVA_TOOL_OPTIONS="-javaagent:/app/lumigo-opentelemetry-0.7.0.jar"

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "spring-boot-todoo-app.jar"]
