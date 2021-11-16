CREATE TABLE `categoria` (
  `id` bigint(20) AUTO_INCREMENT PRIMARY KEY,
  `nome_categoria` varchar(255) NOT NULL
);

CREATE TABLE `produto` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `estoque` integer NOT NULL,
  `preco_venda` double(10,4) NOT NULL,
  `status` varchar(10) NOT NULL,
  `categoria_id` bigint(20) NOT NULL
) ;

ALTER TABLE `produto`
  ADD CONSTRAINT `FK4cm1kg523jlopyexjbmi6y54j` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`);
