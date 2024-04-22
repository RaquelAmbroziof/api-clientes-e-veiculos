# API Cadastro de Clientes e Veiculos

Esse projeto é uma API construída usando **Java 17, Spring Boot, Hibernate e MySQL.**

## Índice

- [Configurações](#confi)
- [Endpoints](#endpoints)

## Configurações

1. Clone o respositório: `git clone https://github.com/RaquelAmbroziof/api-clientes-e-veiculos.git`
2. Navegue até o diretório do projeto: `cd api-clientes-e-veiculos`
3. Atualize as configurações do banco de dados no arquivo `application.properties`. (Altere para as suas credenciais do MySQL).
4. Inicie o aplicativo: botão direito no projeto > Run As > Spring Boot App.
5. A API estará acessível em http://localhost:8080

## Endpoints

- `POST /usuarios`: Registra um novo usuario.
- `GET /usuarios`: Recupera todos os usuários cadastrados.
- `GET /usuarios/id`: Recupera um usuário correspondente ao id.
- `PUT /usuarios/id`: Atualiza um usuário correspondente ao id.
- `DELETE /usuarios/id`: Deleta um usuário correspondente ao id.

- `POST /veiculos/cliente/id`: Registra um novo veiculo e relaciona ao cliente do id correspondente.
- `GET /veiculos`: Recupera todos os veiculos cadastrados.
- `GET /veiculos/id`: Recupera um veiculo correspondente ao id.

