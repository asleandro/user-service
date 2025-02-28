FROM openjdk:11
LABEL authors="Leandro"
WORKDIR /app
COPY target/user-service.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

ENTRYPOINT ["top", "-b"]