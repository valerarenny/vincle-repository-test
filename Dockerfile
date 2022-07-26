FROM adoptopenjdk/openjdk11:alpine-jre
COPY "./target/rest-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]