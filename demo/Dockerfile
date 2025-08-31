# Stage 1: Build the Spring Boot application
# Use Eclipse Temurin with Maven (more reliable for JDK 21)
FROM eclipse-temurin:21-jdk AS build

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files to the container
COPY pom.xml .
COPY src ./src

# Build the project, skipping tests
RUN mvn clean package -DskipTests

# Stage 2: Create a minimal runtime image
# Use Eclipse Temurin JRE 21 for runtime
FROM eclipse-temurin:21-jre

# Create a non-root user for security
RUN groupadd -r spring && useradd -r -g spring spring

# Set the working directory for the application
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/*.jar demo-0.0.1-SNAPSHOT.jar

# Change ownership to the spring user
RUN chown spring:spring demo-0.0.1-SNAPSHOT.jar

# Switch to the spring user
USER spring

# Expose the port that Spring Boot listens on
EXPOSE 8080

# Add JVM optimization flags and environment variable support
CMD ["java", "-Xmx512m", "-Xms256m", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:prod}", "demo-0.0.1-SNAPSHOT.jar"]