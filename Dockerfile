# Use a lightweight JRE base image (Match this with your Java version, e.g., 17, 21)
FROM eclipse-temurin:17-jre-alpine

# Set the internal working directory
WORKDIR /app

# Copy the built JAR file into the container (Adjust 'target/*.jar' to 'build/libs/*.jar' for Gradle)
COPY target/*.jar app.jar

COPY /var/projects/textr-backend/application.properties /config/application.properties

COPY src/main/resources/db/changelog/ /app/changelog/

# Inform Docker that the container listens on port 8080 at runtime
EXPOSE 5001

# Execute the application
ENTRYPOINT ["java", "-jar", "app.jar"]
