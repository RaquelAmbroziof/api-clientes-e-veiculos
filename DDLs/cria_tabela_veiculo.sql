CREATE TABLE `veiculo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `modelo` varchar(255) NOT NULL,
  `placa` varchar(255) NOT NULL,
  `serial_rastreador` varchar(255) NOT NULL,
  `cliente_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_luoyk9d8idgi0wif7bxtefsr5` (`placa`),
  UNIQUE KEY `UK_r9ri9xre4n8bix2klqvkmkw68` (`serial_rastreador`),
  KEY `FKepidt6ge9jf6907k1dd2w0k0k` (`cliente_id`),
  CONSTRAINT `FKepidt6ge9jf6907k1dd2w0k0k` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`id`)
)