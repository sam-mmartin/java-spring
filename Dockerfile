FROM maven:3.9.6-amazoncorretto-17
WORKDIR /app
COPY . .
RUN mvn package
ENV DATASOURCE_URL=mysql://localhost:8080/project_general
ENV DATASOURCE_USERNAME=root
ENV DATASOURCE_PASSWORD=123456
EXPOSE 8080
CMD ["java", "-jar", "target/project-general-1.0.0-SNAPSHOT.jar", "--spring.profiles.active=des"]