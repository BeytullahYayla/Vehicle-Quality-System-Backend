FROM openjdk:17
EXPOSE 8080
ADD target/spring-boot-docker.jar auth-service.jar
ENTRYPOINT ["java","-jar","/auth-service.jar"]
# PostgreSQL 12 imajını kullanın
