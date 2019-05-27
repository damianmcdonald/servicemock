FROM openjdk:8-jdk-alpine
COPY target/servicemock-1.0.4-RELEASE.jar /app/servicemock-1.0.4-RELEASE.jar
ENTRYPOINT ["java","-jar","/app/servicemock-1.0.4-RELEASE.jar", "--spring.config.location=/app/config/application.properties", "--logging.config=/app/config/log4j2.xml"]
