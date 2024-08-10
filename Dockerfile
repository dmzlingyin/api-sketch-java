FROM maven:latest as builder
WORKDIR /app
COPY . .
RUN mvn -B clean package -Dmaven.test.skip=true -Dautoconfig.skip

FROM openjdk:20
LABEL maintainer="dmzlingyin@163.com"
WORKDIR /app
COPY --from=builder /app/target/ .
CMD ["java", "-jar", "api-sketch-java-0.0.1-SNAPSHOT.jar"]