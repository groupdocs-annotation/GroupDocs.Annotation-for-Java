FROM openjdk:18-jdk-bullseye
RUN mkdir -p /app

RUN apt-get update && \
    apt-get install -y fontconfig && \
    fc-cache -f

WORKDIR /app
COPY /DocumentSamples /app
COPY /Licenses /app
COPY target/annotation-spring-*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT java -jar /app/app.jar configuration.yml