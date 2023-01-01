FROM openjdk:11
EXPOSE 9090
ADD target/spring-reactive-mongodb-crud.jar spring-reactive-mongodb-crud.jar
ENTRYPOINT ["java", "-jar", "/spring-reactive-mongodb-crud.jar"]