FROM openjdk:8-jdk-alpine

RUN mkdir /app
WORKDIR /app

COPY ./ /app/

RUN ./mvnw clean package

EXPOSE 8080

ENTRYPOINT [ "java","-jar","/app/target/desafio-0.0.1-SNAPSHOT.war" ]