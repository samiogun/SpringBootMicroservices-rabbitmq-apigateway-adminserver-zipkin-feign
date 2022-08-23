FROM openjdk:8-alpine
WORKDIR /app
COPY target/eureka-server-10.0.1.jar eureka-server-10.0.1.jar
ENTRYPOINT ["java","-jar","eureka-server-10.0.1.jar"]