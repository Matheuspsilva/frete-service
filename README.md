# frete-service

## Visão Geral
O `frete-service` é um microserviço Spring Boot desenvolvido para gerenciar serviços de frete. Ele permite operações como criar e recuperar informações de fretes, integrando-se com outros microserviços para gerenciamento de motoristas e veículos.

## Pré-requisitos
- Java 17
- Maven
- PostgreSQL
- Eureka Server
- Zipkin (para rastreamento distribuído)

## Configuração
1. **Banco de Dados**: Configure um banco de dados PostgreSQL. As credenciais e URL do banco devem ser configuradas no arquivo `application.yaml`.
2. **Eureka Server**: Certifique-se de que o Eureka Server está em execução e acessível.
3. **Zipkin**: Para rastreamento distribuído, configure e execute um servidor Zipkin.

## Instalação e Execução
1. Clone o repositório:

2. Navegue até a pasta do projeto e execute:

```bash
mvn clean install
```

3. Para iniciar a aplicação, execute:
    
    ```bash
    mvn spring-boot:run
    ```

## Swagger UI
A documentação da API REST está disponível através do Swagger UI. Após iniciar a aplicação, acesse `http://localhost:8082/swagger-ui.html` para visualizar e interagir com os endpoints da API.

## Monitoramento e Rastreamento
- **Spring Boot Actuator**: Fornece informações de saúde e métricas da aplicação. Acesse endpoints como `/actuator/health` para verificar o status da aplicação.
- **Micrometer**: Integrado para coleta de métricas. Configure destinos de exportação de métricas conforme necessário.
- **Sleuth**: Adiciona IDs de rastreamento em logs para facilitar o rastreamento de chamadas entre microserviços.
- **Zipkin**: Utilizado em conjunto com o Sleuth para visualizar rastreamentos.

## Endpoints da API
- **GET** `/fretes/{id}`: Retorna informações detalhadas de um frete específico.
- **POST** `/fretes`: Cria um novo frete.

