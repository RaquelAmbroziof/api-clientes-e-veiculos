# API Cadastro de Clientes e Veiculos

Esse projeto é uma API construída usando **Java 17, Spring Boot, Hibernate e MySQL.**

## Instruções Para Execução do Projeto

1. Clone o respositório: `git clone https://github.com/RaquelAmbroziof/api-clientes-e-veiculos.git`
2. Navegue até o diretório do projeto: `cd api-clientes-e-veiculos`
3. Atualize as configurações do banco de dados no arquivo `application.properties`. (Altere para as suas credenciais do MySQL).
4. Inicie o aplicativo: botão direito no projeto > Run As > Spring Boot App.
5. A API estará acessível em http://localhost:8080

Se preferir collection no Postman com todas as requisições necessárias para você poder testar os endpoints que você irá criar. Basta fazer o download e importar no seu postman:

## Endpoints

- `POST /usuarios/cadastrar`: Registra um novo usuario.
- `POST /usuarios/login`: Realiza autenticação de um usuario. 
- `POST /usuarios`: Registra um novo usuario. **(Acesso de ADMIN necessário)**.
- `GET /usuarios`: Recupera todos os usuários cadastrados.
- `GET /usuarios/id`: Recupera um usuário correspondente ao id.
- `PUT /usuarios/id`: Atualiza um usuário correspondente ao id. **(Acesso de ADMIN necessário)**.
- `DELETE /usuarios/id`: Deleta um usuário correspondente ao id. **(Acesso de ADMIN necessário)**.

- `POST /veiculos/cliente/id`: Registra um novo veiculo e relaciona ao cliente do id correspondente. **(Acesso de ADMIN necessário)**.
- `GET /veiculos`: Recupera todos os veiculos cadastrados.
- `GET /veiculos/id`: Recupera um veiculo correspondente ao id.

 
Na raiz do repositório está disponível uma collection criada no Postman com todas as requisições necessárias para testar os endpoints. Basta fazer o download e importar no seu postman: https://github.com/RaquelAmbroziof/api-clientes-e-veiculos/blob/main/teste.postman_collection.json

  

