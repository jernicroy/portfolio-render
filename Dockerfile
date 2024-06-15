FROM ubuntu:latest AS build
RUN apt-get update &&\
    apt-get install -y openjdk-17-jdk maven &&\
    apt-get clean;

COPY . .

# Set environment variables
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

RUN mvn clean install

FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY --from=build /target/portfolio-0.0.1.jar portfolio-0.0.1.jar

ENTRYPOINT ["java","-jar","portfolio-0.0.1.jar"]
