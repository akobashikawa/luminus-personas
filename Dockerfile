FROM openjdk:8-alpine

COPY target/uberjar/luminus-personas.jar /luminus-personas/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/luminus-personas/app.jar"]
