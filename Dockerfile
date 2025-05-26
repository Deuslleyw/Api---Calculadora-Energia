# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21-alpine as build

# Definir diretório de trabalho e copiar arquivos necessários
WORKDIR /calculadora-energia
COPY pom.xml .
COPY src ./src

# Construção do projeto, gerando o JAR
RUN mvn clean package -DskipTests

# Etapa final (Imagem menor e otimizada)
FROM amazoncorretto:21-alpine3.19

# Definir variáveis de ambiente
ENV PORT=8080
ENV TZ=America/Sao_Paulo

# Criar diretório de trabalho
WORKDIR /energia/src/app

# Copiar o JAR gerado na etapa anterior para dentro do container
COPY --from=build /calculadora-energia/target/calculadora-energia-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta da aplicação
EXPOSE ${PORT}

# Comando de inicialização do container
ENTRYPOINT ["java", "-noverify", "-Dfile.encoding=UTF-8", "-jar", "app.jar", "--server.port=8080"]


