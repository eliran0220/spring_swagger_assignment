FROM openjdk:11.0.8-slim
ADD target/swagger-api-exposer.jar swagger-api-exposer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "swagger-api-exposer.jar"]