FROM openjdk:17
EXPOSE 8082
ADD target/auth-0.0.1-SNAPSHOT.jar usermanagement-service.jar
ENTRYPOINT ["java","-jar","/usermanagement-service.jar"]