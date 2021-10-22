FROM openjdk:8-jre-alpine
ENV APP_HOME /opt/java/
COPY deployjar/CityRestCrudService-v1.0.jar $APP_HOME/app.jar
WORKDIR $APP_HOME
EXPOSE 8080
CMD java -jar app.jar