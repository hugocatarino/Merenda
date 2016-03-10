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
  nome VARCHAR(20) NULL,
  tipo INTEGER UNSIGNED NULL,
  peso_liq FLOAT NULL,
  quantidade INTEGER UNSIGNED NULL,
  falta INTEGER UNSIGNED NULL,
  recebido FLOAT NULL,
  date DATE NULL,
  PRIMARY KEY(idRemessa),
  INDEX Remessa_FKIndex1(Escola_idEscola)
)ENGINE = InnoDB;

