#FROM java:8-jdk-alpine
FROM openjdk:8-alpine
WORKDIR /app
ADD target/account-service.jar account-service.jar
ENTRYPOINT ["java","-jar","account-service.jar"]