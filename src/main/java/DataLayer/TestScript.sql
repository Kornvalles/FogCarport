/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ndupo
 * Created: May 24, 2019
 */

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema FogCarport
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `FogCarport`;

-- -----------------------------------------------------
-- Schema FogCarport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FogCarport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `FogCarport` ;

-- -----------------------------------------------------
-- Table `FogCarport`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`customer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `zipcode` INT(11) NOT NULL,
  `phoneNumber` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 50
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `FogCarport`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `employee` (`id`,`name`,`password`) VALUES (1,'Admin', '1234');

-- -----------------------------------------------------
-- Table `FogCarport`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`material` (
  `materialID` INT(11) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `MSRP` DOUBLE NOT NULL,
  `costPrice` DOUBLE NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`materialID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

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
  `orderId` INT(11) NOT NULL AUTO_INCREMENT,
  `employeeId` INT(11) NOT NULL,
  `customerId` INT(11) NOT NULL,
  `carportHeight` INT(11) NOT NULL,
  `carportLength` INT(11) NOT NULL,
  `carportWidth` INT(11) NOT NULL,
  `hasShed` TINYINT(1) NULL DEFAULT NULL,
  `shedWidth` INT(11) NULL DEFAULT NULL,
  `hasRoof` TINYINT(1) NULL DEFAULT NULL,
  `roofType` TINYINT(1) NULL DEFAULT NULL,
  `roofAngle` INT(11) NULL DEFAULT NULL,
  `hasWall` TINYINT(1) NULL DEFAULT NULL,
  `details` VARCHAR(255) NULL DEFAULT NULL,
  `totalPrice` DOUBLE NOT NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE INDEX `orderId` (`orderId` ASC) VISIBLE,
  INDEX `Customer_id_idx` (`customerId` ASC) VISIBLE,
  INDEX `Employee_id_idx` (`employeeId` ASC) VISIBLE,
  CONSTRAINT `Customer_id`
    FOREIGN KEY (`customerId`)
    REFERENCES `FogCarport`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Employee_id`
    FOREIGN KEY (`employeeId`)
    REFERENCES `FogCarport`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


