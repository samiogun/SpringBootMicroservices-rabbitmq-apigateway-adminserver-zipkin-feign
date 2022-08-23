FROM openjdk:8-alpine
WORKDIR /app
ADD target/notification-service-10.0.1.jar notification-service-10.0.1.jar
ENTRYPOINT ["java","-jar","notification-service-10.0.1.jar"]