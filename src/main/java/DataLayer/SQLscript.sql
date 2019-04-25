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

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fog
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fog` DEFAULT CHARACTER SET utf8 ;
USE `fog` ;

-- -----------------------------------------------------
-- Table `fog`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`employee` (
  `employeeID` VARCHAR(16) NOT NULL,
  `name` VARCHAR(255) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`employeeID`));


-- -----------------------------------------------------
-- Table `fog`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`customer` (
  `name` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`email`));


-- -----------------------------------------------------
-- Table `fog`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`material` (
  `materialID` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `MSRP` DOUBLE NOT NULL,
  `costPrice` DOUBLE NOT NULL,
  `quantity` DOUBLE NOT NULL,
  PRIMARY KEY (`materialID`));


-- -----------------------------------------------------
-- Table `fog`.`carport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`carport` (
  `carportID` INT NOT NULL AUTO_INCREMENT,
  `carportWS` TINYINT NOT NULL,
  `materialID` INT NOT NULL,
  `orderID` INT NOT NULL,
  `quantity` INT NOT NULL,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  `comment` VARCHAR(45) NULL,
  PRIMARY KEY (`carportID`),
  INDEX `material_ID_idx` (`materialID` ASC) VISIBLE,
  INDEX `order_ID_idx` (`orderID` ASC) VISIBLE,
  CONSTRAINT `material_ID`
    FOREIGN KEY (`materialID`)
    REFERENCES `fog`.`material` (`materialID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_ID`
    FOREIGN KEY (`orderID`)
    REFERENCES `fog`.`order` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `fog`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`order` (
  `orderID` INT NOT NULL AUTO_INCREMENT,
  `carportID` INT NOT NULL,
  `employeeID` INT NOT NULL,
  `customerEmail` VARCHAR(255) NOT NULL,
  `carportHeight` INT NOT NULL,
  `carportWidth` INT NOT NULL,
  `carportLength` INT NOT NULL,
  `rooftopType` VARCHAR(45) NOT NULL,
  `shedLength` INT NULL,
  `shedWidth` INT NULL,
  `totalPrice` DOUBLE NOT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `employeeID_idx` (`employeeID` ASC) VISIBLE,
  INDEX `customerEmail_idx` (`customerEmail` ASC) VISIBLE,
  INDEX `carportID_idx` (`carportID` ASC) VISIBLE,
  CONSTRAINT `employeeID`
    FOREIGN KEY (`employeeID`)
    REFERENCES `fog`.`employee` (`employeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customerEmail`
    FOREIGN KEY (`customerEmail`)
    REFERENCES `fog`.`customer` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `carportID`
    FOREIGN KEY (`carportID`)
    REFERENCES `fog`.`carport` (`carportID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
