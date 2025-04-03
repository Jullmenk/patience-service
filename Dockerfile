# Use uma imagem base com o OpenJDK
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo JAR da aplicação para dentro do container
COPY target/patient-service-0.0.1-SNAPSHOT.jar /app/patient-service.jar


# Exponha a porta que a aplicação Spring Boot vai rodar
EXPOSE 4000

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "patient-service.jar"]
