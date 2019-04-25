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
-- Table `fog`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`order` (
  `orderID` INT NOT NULL,
  `employeeID` VARCHAR(255) NOT NULL,
  `customerEmail` VARCHAR(255) NOT NULL,
  `carportHeight` VARCHAR(45) NOT NULL,
  `carportWidth` VARCHAR(45) NOT NULL,
  `carportLength` VARCHAR(45) NOT NULL,
  `rooftopType` VARCHAR(45) NOT NULL,
  `shedLength` VARCHAR(45) NULL,
  `shedWidth` VARCHAR(45) NULL,
  `totalPrice` DOUBLE NOT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `employeeID_idx` (`employeeID` ASC) VISIBLE,
  INDEX `customerEmail_idx` (`customerEmail` ASC) VISIBLE,
  CONSTRAINT `employeeID`
    FOREIGN KEY (`employeeID`)
    REFERENCES `fog`.`employee` (`employeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customerEmail`
    FOREIGN KEY (`customerEmail`)
    REFERENCES `fog`.`customer` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


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
-- Table `fog`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`carport` (
  `carportWS` INT NOT NULL AUTO_INCREMENT,
  `materialID` INT NOT NULL,
  `orderID` INT NOT NULL,
  `quantity` INT NOT NULL,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  `comment` VARCHAR(45) NULL,
  PRIMARY KEY (`carportWS`),
  INDEX `materialID_idx` (`materialID` ASC) VISIBLE,
  INDEX `orderID_idx` (`orderID` ASC) VISIBLE,
  CONSTRAINT `materialID`
    FOREIGN KEY (`materialID`)
    REFERENCES `fog`.`material` (`materialID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orderID`
    FOREIGN KEY (`orderID`)
    REFERENCES `fog`.`order` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
