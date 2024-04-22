CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i068p2cyc5fi4d8j8ago5s6y5` (`cnpj`)
)