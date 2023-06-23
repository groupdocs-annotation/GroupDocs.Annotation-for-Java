FROM openjdk:8-jre-alpine
RUN mkdir -p /app && apk add fontconfig && apk add msttcorefonts-installer && update-ms-fonts && fc-cache -f
WORKDIR /app
COPY /DocumentSamples /app
COPY /Licenses /app
COPY /target/annotation-*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT java -jar /app/app.jar configuration.yml