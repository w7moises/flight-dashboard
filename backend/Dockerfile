FROM eclipse-temurin:17

LABEL mentainer="w7moises@gmail.com"

WORKDIR /app

COPY target/backend-0.0.1-SNAPSHOT.jar /app/byte.jar

ENTRYPOINT ["java", "-jar", "byte.jar"]