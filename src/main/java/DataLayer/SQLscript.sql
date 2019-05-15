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
`name` VARCHAR(16) NOT NULL,
`email` VARCHAR(255) NOT NULL,
`address` VARCHAR(255),
`zipcode` INT NOT NULL,
`phoneNumber` INT NOT NULL,
  PRIMARY KEY (`email`));


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
(2000,'skruer 200 stk',50,20.50,9999,'Staal. Kan iskrues uden forboring. Til planker og til montering af laegter.'), 
(3000,'tagsten',29.95,9.95,9999,'Aegte tegl. Klassisk tagsten med engobe. Moerkegraa.'), 
(3010,'tagplade(r)',9.95,3.50,9999,'Fibercement. Boelgeplade model A1. Klar farve.');


-- -----------------------------------------------------
-- Table `FogCarport`.`standard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`standard` (
  `standardID` INT NOT NULL,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `toolshed` BOOLEAN, 
  `pointyRoof` BOOLEAN,
  `roofAngle` INT,
  `wall` BOOLEAN,
  PRIMARY KEY (`standardID`));

INSERT INTO FogCarport.standard (`standardID`,`length`,`width`,`toolshed`,`pointyRoof`,`roofAngle`,`wall`) VALUES 
(001,720,360,true,true,30,false),
(002,540,360,false,true,30,false),
(003,780,390,true,true,30,false),
(004,810,360,true,true,30,false),
(005,480,300,false,false,0,false),
(006,600,300,true,false,30,false);


-- -----------------------------------------------------
-- Table `FogCarport`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`order` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `employeeId` INT NOT NULL,
  `customerEmail` VARCHAR(255) NOT NULL,
  `customerName` VARCHAR(255) NOT NULL,
  `carportHeight` INT NOT NULL,
  `carportWidth` INT NOT NULL,
  `carportLength` INT NOT NULL,
  `hasRoof` BOOLEAN,
  `hasShed` BOOLEAN,
  `hasWall` BOOLEAN,
  `totalPrice` DOUBLE NOT NULL,
  PRIMARY KEY (`orderID`));


-- -----------------------------------------------------
-- Table `fog`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`employee` (
  `id` VARCHAR(16) NOT NULL,
  `name` VARCHAR(255) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `employee` (`id`,`name`,`password`) VALUES (1,'Martin', '1234');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
