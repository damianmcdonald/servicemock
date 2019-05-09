FROM openjdk:8-jdk-alpine
COPY target/servicemock-1.0.2-RELEASE.jar /app/servicemock-1.0.2-RELEASE.jar
ENTRYPOINT ["java","-jar","/app/servicemock-1.0.2-RELEASE.jar"]
