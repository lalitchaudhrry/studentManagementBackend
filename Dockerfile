# ---------- BUILD STAGE ----------
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml from inner project folder
COPY studentManagement/pom.xml ./pom.xml
RUN mvn dependency:go-offline

# Copy source code
COPY studentManagement/src ./src
RUN mvn clean package -DskipTests

# ---------- RUN STAGE ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 9000

ENTRYPOINT ["java", "-jar", "app.jar"]
