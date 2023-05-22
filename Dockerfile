FROM maven:3.9-amazoncorretto-17 as builder
WORKDIR /app
COPY . .
RUN mvn clean package

FROM amazoncorretto:17
WORKDIR /app
COPY --from=builder /app/target/app.jar /app/app.jar
EXPOSE 8080
CMD java -Dspring.profiles.active=prod -jar app.jar
