# Challenge Diagiage Task 4

API em Spring boot, com banco de dados H2.
Essa API pega dados a partir do retorno da API("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda") 
passada, e salva no banco de dados H2 como entidade Client.

Podendo retornar todos os clientes e a quantidade de clientes por gênero.

## Tecnologias Utilizadas

- Java e Spring Boot para a API
- Banco de dados H2
- Lombok para reduzir a verbosidade do código
- Postman para testar a API
- IntelliJ IDEA como IDE

## Configuração

1. **Clonar o repositório:**
    ```bash
    git clone https://github.com/KauaAlmeidaSilveira/taskProject_Digiage.git
    ```
2. **Application.properties:**
    - O banco de dados H2 já está configurado no arquivo `application.properties`.

4. **Executar o projeto:**
    - Execute a classe principal `ProjectTask4Application.java`.

## Rotas da Aplicação

Principais rotas da API e os corpos de requisição esperados.
- **Host**: http://localhost:8080
- **Postman:** Na pasta raiz do projeto, você encontrará dois arquivos Postman, para testar a API.
Faça o import do collection e environment

**Rotas**

| Método HTTP | Rota                      | Descrição                                |
|-------------|---------------------------|------------------------------------------|
| GET         | /clients                  | Obter todos os clients                   |
| GET         | /clients/clientMascAndFem | Obter a quantidade de clients por gênero |
| GET         | /h2-console               | Acessar o banco de dados H2              |


## Exemplo

Aqui estão alguns exemplos de como utilizar a API:

1. **Obter todos os clients:**
    ```http
    GET /clients
    [
       {
           "emp_no": 1,
           "first_name": "Georgie",
           "last_name": "Facello",
           "gender": "M"
       },
       {
           "emp_no": 2,
           "first_name": "Georgie",
           "last_name": "Facello",
           "gender": "M"
       }...
    ```
2. **Obter a quantidade de clients por gênero:**
    ```http
   GET /clients/clientMascAndFem
   {
       "total": 17368,
       "masc": 10346,
       "fem": 7022
   }
    ```


