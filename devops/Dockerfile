FROM openjdk:8-alpine

WORKDIR /app

COPY . .

RUN sed -i -e 's/\r$//' ./mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "./target/msvc-customers-0.0.1-SNAPSHOT.jar"]