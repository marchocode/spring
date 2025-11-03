FROM amazoncorretto:11-alpine-jdk

WORKDIR /app

COPY target/spring-demo-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
