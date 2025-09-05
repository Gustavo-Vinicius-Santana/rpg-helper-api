# Etapa 1: Build
FROM maven:3.9.9-eclipse-temurin-24-alpine AS build

WORKDIR /app

# Copia primeiro o pom.xml para aproveitar cache de dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte
COPY src ./src

# Gera o JAR (sem rodar testes)
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:24-jre-alpine

WORKDIR /app

# Copia o JAR da etapa de build
COPY --from=build /app/target/rpg-helper-api-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta usada pelo Spring Boot
EXPOSE 8080
ENV PORT=8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]