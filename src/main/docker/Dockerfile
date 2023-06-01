FROM williamyeh/java8:latest
VOLUME /tmp
EXPOSE 8080
ADD target/MyWeb-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
