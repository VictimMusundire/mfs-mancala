FROM eclipse-temurin:17

LABEL maintainer = "mvpvictim@gmail.com"

WORKDIR /app

COPY target/*.jar /app/java_springboot_app.jar

ENTRYPOINT ["java", "-jar", "java_springboot_app.jar"]