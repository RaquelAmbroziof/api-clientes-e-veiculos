-- Host: localhost    Database: db_teste
-- ------------------------------------------------------

CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `perfil` enum('ROLE_ADMINISTRADOR','ROLE_CLIENTE') DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i068p2cyc5fi4d8j8ago5s6y5` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci