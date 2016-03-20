USE `Merenda`;

INSERT INTO `Merenda`.`Escola` (nome) VALUES ("Escola Municipal Grande Vale");
INSERT INTO `Merenda`.`Estoque` (Escola_idEscola, nome) VALUES (1, "infantil");
INSERT INTO `Merenda`.`Remessa` (Estoque_idEstoque, nome, date) VALUES (1, "infantil", "01/03/2016");
INSERT INTO `Merenda`.`Alimento` (nome, Estoque_idEstoque, tipo, peso_liq, quantidade,falta, recebido)
	VALUES ("A�afr�o", 1, 2, 100, 03, 2, 300);
INSERT INTO `Merenda`.`Mapa_Merenda` (Estoque_idEstoque, cardapio, turno, numero_Alunos, date) 
	VALUES (1, "Arroz com frango", "Primeiro", 40, "05/03/2016");
INSERT INTO `Merenda`.`Gasto` (Alimento_idAlimento, Mapa_Merenda_idMapa_Merenda, peso) 
	VALUES (1,1,50);