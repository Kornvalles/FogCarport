/**
 * Author:  ndupo
 * Created: Apr 24, 2019
 */
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Drop FogCarport
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `FogCarport`;

-- -----------------------------------------------------
-- Schema FogCarport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FogCarport`;
USE `FogCarport` ;


-- -----------------------------------------------------
-- Table `FogCarport`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`customer` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(16),
`email` VARCHAR(255),
`address` VARCHAR(255),
`zipcode` INT NOT NULL,
`phoneNumber` INT NOT NULL,
  PRIMARY KEY (`id`,`email`));


-- -----------------------------------------------------
-- Table `fog`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `employee` (`id`,`name`,`password`) VALUES (1,'Admin', '1234');


-- -----------------------------------------------------
-- Table `FogCarport`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`material` (
  `materialID` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `MSRP` DOUBLE NOT NULL,
  `costPrice` DOUBLE NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`materialID`));

INSERT INTO FogCarport.material (`materialID`,`name`,`MSRP`, `costPrice`,`quantity`,`description`) VALUES 
(1000,'stolpe(r)',240.95,90.50,9999,'Trykimpraegneret stolpe af trae. 100x100mm.'), 
(1010,'planke(r) 10x100cm',45.50,15.50,9999,'Traeplanke 10x100 cm.'), 
(1020,'taglaegte(r)', 90.95,30.50,9999,'Trykimpraegneret lagte af trae til tag. 38x73mm.'), 
(1030,'sidelaegte(r)',90.95,30.50,9999,'Trykimpraegneret lagte af trae til sider. 38x73mm.'), 
(2000,'skruer 200 stk',50,20.50,9999,'Staal. Kan iskrues uden forboring.'), 
(3000,'tagsten',29.95,9.95,9999,'Aegte tegl. Klassisk tagsten med engobe. Moerkegraa.'), 
(3010,'tagplade(r)',9.95,3.50,9999,'Fibercement. Boelgeplade model A1. Klar farve.');


-- -----------------------------------------------------
-- Table `FogCarport`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`order` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `employeeId` INT NOT NULL,
  `customerId` INT NOT NULL,
  `carportHeight` INT NOT NULL,
  `carportLength` INT NOT NULL,
  `carportWidth` INT NOT NULL,
  `hasShed` BOOLEAN,
  `shedWidth` INT,
  `hasRoof` BOOLEAN,
  `roofType` BOOLEAN,
  `roofAngle` INT,
  `hasWall` BOOLEAN,
  `details` VARCHAR(255),
  `totalPrice` DOUBLE NOT NULL,
  PRIMARY KEY (`orderID`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=1;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
