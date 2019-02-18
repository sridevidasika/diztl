FROM maven:3.5-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM gcr.io/distroless/java
COPY --from=build /usr/src/app/target/diztl-1.0-jar-with-dependencies.jar /usr/app/diztl-1.0-jar-with-dependencies.jar
EXPOSE 50051 50051

ENTRYPOINT ["java", "-cp", "/usr/app/diztl-1.0-jar-with-dependencies.jar", "io.github.gravetii.node.NodeServer"]