# Challenge Diagiage Task 4

API em Spring boot, com banco de dados H2.
Essa API pega dados a partir do retorno da API("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda") 
passada, e salva no banco de dados H2 como entidade Client.

Podendo retornar todos os clientes e a quantidade de clientes por gênero, 
além de salvar um aquivo "result.json" no path "src/main/java/com/digiage/projectTask4/files/".

Vale ressaltar que a implemtação do envio para o Amazon S3 foi feita, porém ao tentar enviar o arquivo para o bucket,
o retorno é um erro 403, Access Denied, mesmo com as credenciais corretas.

Erro Amazon S3:  com.amazonaws.services.s3.model.AmazonS3Exception: Access Denied (Service: Amazon S3; Status Code: 403;
Error Code: AccessDenied; Request ID: 66CBFKZYK51MK3Q6; 
S3 Extended Request ID: YbqN7O87Tjt1cPVR3VaS145TsWOOShTWghu3m4T2VgBZIJtb3PTjJHcnIul4J6TP5A9YVRsRvhUP+QtHubtbAg==; Proxy: null)

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


