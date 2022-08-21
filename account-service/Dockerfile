FROM openjdk:8
WORKDIR /app
ADD target/account-service.jar account-service.jar
ENTRYPOINT ["java","-jar","account-service.jar"]