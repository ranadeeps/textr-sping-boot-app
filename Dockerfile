
FROM eclipse-temurin:17-jre-alpine

# Set the internal working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Create config directory and copy properties
RUN mkdir -p /config
COPY application.properties /config/application.properties

# Copy liquibase changelog files
COPY src/main/resources/db/changelog/ /app/changelog/

# Inform Docker that the container listens on port 5001 at runtime
EXPOSE 5001

# Execute the application with explicit config path
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=file:/config/application.properties"]
