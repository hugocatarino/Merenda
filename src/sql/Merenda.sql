-- -----------------------------------------------------
-- SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
-- SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
-- SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_varchar(11)S';
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `Merenda` DEFAULT CHARACTER SET Latin1 COLLATE = latin1_swedish_ci;
USE `Merenda`;

-- -----------------------------------------------------
-- Table `Merenda`.`Escola`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Merenda`.`Escola` (
  idEscola INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NULL,
  PRIMARY KEY(idEscola)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Merenda`.`Remessa`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Merenda`.`Remessa` (
  idRemessa INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Escola_idEscola INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(25) NULL,
  date VARCHAR(10) NULL,
  PRIMARY KEY(idRemessa),
  INDEX Remessa_FKIndex1(Escola_idEscola)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Merenda`.`Alimento`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Merenda`.`Alimento` (
  idAlimento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Remessa_idRemessa INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(20) NULL,
  tipo INTEGER UNSIGNED NULL,
  peso_liq FLOAT NULL,
  quantidade FLOAT NULL,
  falta INTEGER UNSIGNED NULL,
  recebido FLOAT NULL,
  PRIMARY KEY(idAlimento),
  INDEX Alimento_FKIndex1(Remessa_idRemessa)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Merenda`.`Mapa_Merenda`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Merenda`.`Mapa_Merenda` (
  idMapa_Merenda INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Remessa_idRemessa INTEGER UNSIGNED NOT NULL,
  cardapio VARCHAR(40) NULL,
  turno VARCHAR(10) NULL,
  numero_Alunos INTEGER UNSIGNED NULL,
  date VARCHAR(10) NULL,
  PRIMARY KEY(idMapa_Merenda),
  INDEX Mapa_Merenda_FKIndex1(Remessa_idRemessa)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Merenda`.`Gasto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Merenda`.`Gasto` (
  idGasto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Mapa_Merenda_idMapa_Merenda INTEGER UNSIGNED NOT NULL,
  Alimento_idAlimento INTEGER UNSIGNED NOT NULL,
  peso FLOAT NULL,
  PRIMARY KEY(idGasto),
  INDEX Gasto_FKIndex1(Alimento_idAlimento),
  INDEX Gasto_FKIndex2(Mapa_Merenda_idMapa_Merenda)
)ENGINE = InnoDB;
