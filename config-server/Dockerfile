FROM openjdk:8-alpine
WORKDIR /app
ADD target/config-server-10.0.1.jar config-server-10.0.1.jar
ENTRYPOINT ["java","-jar","config-server-10.0.1.jar"]