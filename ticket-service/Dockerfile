FROM openjdk:8-alpine
WORKDIR /app
COPY target/ticket-service-10.0.1.jar ticket-service-10.0.1.jar
ENTRYPOINT ["java","-jar","ticket-service-10.0.1.jar"]