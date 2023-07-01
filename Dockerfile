FROM amazoncorretto:17-alpine3.15-jdk
MAINTAINER juansoria
COPY target/portfolioJCS-0.0.1-SNAPSHOT.jar portfolioJCS-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portfolioJCS-0.0.1-SNAPSHOT.jar"]