FROM adoptopenjdk/openjdk11:alpine-jre
COPY "./target/app-items-vincle.jar" "app.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app-items-vincle.jar"]