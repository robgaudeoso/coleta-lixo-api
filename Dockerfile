FROM maven:3.9.8-eclipse-temurin-21 AS build
RUN mkdir /opt/app
COPY . /opt/app
WORKDIR /opt/app
RUN mvn clean package -DskipTests
RUN ls -l /opt/app/target
FROM eclipse-temurin:21-jre-alpine
RUN mkdir /opt/app
COPY --from=build  /opt/app/target/coleta-lixo-0.0.1-SNAPSHOT.jar /opt/app/app.jar
WORKDIR /opt/app
ENV PROFILE=dev
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]