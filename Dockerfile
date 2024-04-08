FROM eclipse-temurin:17-jdk-alpine

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da aplicação para o contêiner
COPY target/frete-service-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponha a porta em que a aplicação vai rodar
EXPOSE 8080

# Comando para iniciar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
