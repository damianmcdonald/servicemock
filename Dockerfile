FROM openjdk:8-jdk-alpine
COPY src/main/resources/entrypoint.sh /app/entrypoint.sh
COPY target/servicemock-1.0.0.jar /app/servicemock-1.0.0.jar
RUN ["chmod", "+x", "/app/entrypoint.sh"]
ENTRYPOINT ["sh", "/app/entrypoint.sh"]
