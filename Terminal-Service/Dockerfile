FROM openjdk:17
EXPOSE 8084
ADD target/CVQS-0.0.1-SNAPSHOT.jar terminal-services.jar
ENTRYPOINT ["java","-jar","/terminal-services.jar"]