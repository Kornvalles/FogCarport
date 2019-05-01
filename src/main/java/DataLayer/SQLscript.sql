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
`id` INT(11) NOT NULL auto_increment,
`name` VARCHAR(16) NOT NULL,
`email` VARCHAR(255) NOT NULL,
`address` VARCHAR(255),
`zipcode` INT(4),
`phoneNumber` VARCHAR(15),
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `FogCarport`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`material` (
  `materialID` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `MSRP` DOUBLE NOT NULL,
  `costPrice` DOUBLE NOT NULL,
  `quantity` DOUBLE NOT NULL,
  PRIMARY KEY (`materialID`));

INSERT INTO FogCarport.material (`materialID`,`name`,`MSRP`, `costPrice`,`quantity`) VALUES 
("1000","post","240.95","90.50","9999"), 
("1010","wood board 10x100cm","45.50","15.50","9999"), 
("1020","roof battens", "90.95","30.50","9999"), 
("1030","side battens","90.95","30.50","9999"), 
("2000","screw","0.10","0.01","9999");


-- -----------------------------------------------------
-- Table `FogCarport`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FogCarport`.`order` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `employeeId` INT NOT NULL,
  `customerId` INT NOT NULL,
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
