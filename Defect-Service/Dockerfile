FROM openjdk:17
EXPOSE 8082
ADD target/defects-0.0.1-SNAPSHOT.jar defect-service.jar
ENTRYPOINT ["java","-jar","/defect-service.jar"]