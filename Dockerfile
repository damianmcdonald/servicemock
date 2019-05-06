FROM openjdk:8-jdk-alpine
ENV SERVICEMOCK_LOGS /app/logs
ENV SERVICEMOCK_NAME sp-frontoffice-mock1
COPY target/servicemock-1.0.0.jar /app/servicemock-1.0.0.jar
ENTRYPOINT ["java","-jar","/app/servicemock-1.0.0.jar","--spring.config.location=/app/conf/application.properties"]