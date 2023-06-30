FROM adoptopenjdk/openjdk11:ubi
MAINTAINER aayush
COPY target/springbootdatabase-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "jar", "/app.jar"]

