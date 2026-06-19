# Build the project
FROM maven:3-eclipse-temurin-8 AS builder
COPY pom.xml /usr/local/build/pom.xml
COPY src /usr/local/build/src
WORKDIR /usr/local/build
RUN mvn clean package -DskipTests -Dskip.npm=true

# Configure Docker Image
FROM eclipse-temurin:21-jre-jammy

RUN apt-get update && \
    apt-get install -y --no-install-recommends fontconfig && \
    fc-cache -f && \
    rm -rf /var/lib/apt/lists/* && \
    mkdir -p /home/groupdocs/app && \
    mkdir -p /home/groupdocs/app/DocumentSamples && \
    mkdir -p /home/groupdocs/app/Licenses

WORKDIR /home/groupdocs/app
COPY /DocumentSamples /home/groupdocs/app/DocumentSamples
COPY /configuration.yml /home/groupdocs/app/configuration.yml
COPY --from=builder /usr/local/build/target/annotation-*.jar /home/groupdocs/app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar", "configuration.yml" ]
