# Build
FROM maven:3.6.0-jdk-11-slim AS build
COPY ./kong-integration/src /home/app/src
COPY ./kong-integration/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/kong-integration-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]