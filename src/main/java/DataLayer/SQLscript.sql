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
-- Schema legohus
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carport` DEFAULT CHARACTER SET latin1 ;
USE `carport` ;

-- -----------------------------------------------------
-- Table `carport`.`standard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`standard` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `details` VARCHAR(245) NOT NULL,
  `price` INT(11) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `legohus`.`house_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` INT(11) NULL NULL,
  PRIMARY KEY (`id`)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO 'standard' ('id', 'details', 'price') VALUES 
('Enkelt 390x780 høj rejsning med skur 240x330', '18798.40')
('Enkelt 360x720 høj rejsning med skur 320x220', '17198.40')
('Enkelt 360x540 høj rejsning uden skur', '11198.40')
('Dobbelt 600x780 høj rejsning med skur 210x510', '25598.40')
('Dobbelt 600x870 høj rejsning med skur 530x300', '27198.40')
('Dobbelt 600x540 fladt tag med midterstolpe og skur 260x185', '9438.40');

INSERT INTO `employee`
VALUES
('admin','1234');

