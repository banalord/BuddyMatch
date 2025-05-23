FROM maven:3.5-jdk-8-alpine as builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

CMD ["java","-jar","/app/target/BuddyMatch-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]
