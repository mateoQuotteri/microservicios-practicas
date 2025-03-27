FROM openjdk:17
ARG JAR_FILE=target/eureka.war
COPY ${JAR_FILE} app.war
ENTRYPOINT ["java", "-jar","app.war"]
EXPOSE 8761

