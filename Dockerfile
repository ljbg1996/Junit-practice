
FROM openjdk:17-jdk-alpine

ADD target/unittest-practice-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/myapp.jar"]
