FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springBootRabbitMq.jar

# Expose port (adjust based on application.properties server.port)
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/springBootRabbitMq.jar"]

# docker build -t sachinextgen/springbootrabbitmq:0.0.1 .
