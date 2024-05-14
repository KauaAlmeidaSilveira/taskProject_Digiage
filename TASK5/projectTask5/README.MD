# Challenge Diagiage

API Rest em Spring boot, com banco de dados H2.
Essa API faz um CRUD de Employees e seu Departments, utilizando 
recursos como authenticação JWT e Spring Security, validação de entrada e tratamento de erros com ExceptionHandler. 
Além de ferramentas auxiliares como Lombok.

Vale lembrar que a API assim que iniciada, já manda um seed de dados para o banco de dados H2, para facilitar os testes.
Você pode encontrar o seed de dados no arquivo `data.sql` na pasta `resources`.

- **Autenticação:** Utiliza JWT para autenticação. Você precisa obter um token de acesso válido para acessar os endpoints protegidos.
- **Validação:** Validação de entrada para garantir a integridade dos dados.
- **Tratamento de Erros:** Respostas HTTP adequadas para diferentes tipos de erros.

## Tecnologias Utilizadas

- Java e Spring Boot para a API
- Banco de dados H2
- JWT para autenticação
- Spring Security para segurança
- Lombok para reduzir a verbosidade do código
- Postman para testar a API
- IntelliJ IDEA como IDE

## Configuração

1. **Clonar o repositório:**
    ```bash
    git clone https://github.com/KauaAlmeidaSilveira/taskProject_Digiage.git
    ```
2. **Application.properties:**
    - O banco de dados H2 já está configurado no arquivo `application-test.properties`.

4. **Executar o projeto:**
    - Execute a classe principal `ProjectTask5Application.java`.

## Rotas da Aplicação

Principais rotas da API e os corpos de requisição esperados.
- **Host**: http://localhost:8080
- **Postman:** Na pasta raiz do projeto, você encontrará dois arquivos Postman, para testar a API.
Faça o import do collection e environment

**Rotas Livres**

| Método HTTP | Rota             | Descrição                          |
|-------------|------------------|------------------------------------|
| POST        | /auth/register   | Obter token de acesso              |
| POST        | /auth/login      | Validar token de acesso            |
| GET         | /employee        | Obter todos os employees paginados |
| GET         | /employee/{id}  | Obter employee por ID              |
| GET         | /department     | Obter todos os departments         |
| GET         | /department/{id} | Obter department por ID            |
| GET         | /h2-console      | Acessar o banco de dados H2        |
**Rotas Protegidas** 

| Método HTTP | Rota             | Descrição                          |
|-------------|------------------|------------------------------------|
| POST        | /employee       | Criar um novo employee             |
| PATCH       | /employee/{id}  | Atualizar employee por ID          |
| DELETE      | /employee/{id}  | Deletar employee por ID            |
| POST        | /department     | Criar um novo department           |
| PATCH         | /department/{id} | Atualizar department por ID        |
| DELETE      | /department/{id} | Deletar department por ID          |

## Exemplo

Aqui estão alguns exemplos de como utilizar a API:

1. **Obter Token de Acesso (ROTA LIVRE):**
    ```http
    POST /auth/register
    {
        "nome":"kaua",
        "email":"kaua@gmail.com",
        "senha":"123456"
    }
    ```
2. **Validar Token de Acesso (ROTA LIVRE):**
    ```http
    POST /auth/login
    {
        "email":"kaua@gmail.com",
        "senha":"123456"
    }
    ```

3. **Criar um novo Employee (ROTA PROTEGIDA):**
    ```http
    POST /employee
    Authorization: Bearer TOKEN
    {
        "nome":"kaua",
        "email":"kaua@gmail.com",
        "telefone":"(11)96368-7845",
        "dataNascimento":"2004-11-20",
        "cargo":"ti"
    }
    ```

4. **Resultado da criação de um Employee (ROTA PROTEGIDA):**
    ```http
    POST /employee
    {
        "id": 29,
        "nome": "kaua",
        "email": "kaua@gmail.com",
        "telefone": "(11)96368-7845",
        "dataNascimento": "2004-11-20",
        "cargo": "ti"
    }
    ```


