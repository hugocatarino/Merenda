USE `Merenda`;

INSERT INTO `Merenda`.`Escola` (nome) VALUES (Escola Municipal Grande Vale);
INSERT INTO `Merenda`.`Remessa` (Escola_idEscola, nome, date) VALUES (1, "infantil", "01/03/2016");
INSERT INTO `Merenda`.`Alimento` (nome, Remessa_idRemessa, tipo, peso_liq, quantidade,falta, recebido)
	VALUES ("Açafrão", 1, 2, 100, 03, 2, 300);
INSERT INTO `Merenda`.`Mapa_Merenda` (Remessa_idRemessa, cardapio, turno, numero_Alunos, date) 
	VALUES (1, "Arroz com frango", "Primeiro", 40, "05/03/2016");
INSERT INTO `Merenda`.`Gasto` (Alimento_idAlimento, Mapa_Merenda_idMapa_Merenda, peso) 
	VALUES (1,1,50);