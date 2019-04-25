/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ndupo
 * Created: Apr 24, 2019
 */

-- MySQL Workbench Forward Engineering

DROP SCHEMA IF EXISTS carport;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema carport
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carport` DEFAULT CHARACTER SET latin1 ;
USE `carport` ;

-- -----------------------------------------------------
-- Table `carport`.`standard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`standard` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `toolshed` BOOLEAN,
  `details` VARCHAR(245) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB

DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `carport`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` INT(11) NULL NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `standard` (`details`, `price`) VALUES 
('Enkelt b 300 l 480 h 225 fladt tag uden skur', '3795.00'),
('Enkelt b 390 l 720 h 310 høj rejsning med skur b 330 l 240', '22495.00'),
('Dobbelt b 600 l 480 h 225 fladt tag', '9995.00'),
('Dobbelt b 600 l 870 h 380 høj rejsning med skur b 530 l 310', '31995.00'),

INSERT INTO `employee`
VALUES
('1','admin','1234');

