FROM adoptopenjdk/openjdk11:alpine
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
EXPOSE 8080
WORKDIR /opt/app
ARG JAR_FILE=target/app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]