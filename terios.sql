-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema TED
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TED
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TED` DEFAULT CHARACTER SET latin1 ;
USE `TED` ;

-- -----------------------------------------------------
-- Table `TED`.`AD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TED`.`AD` (
  `HOST_NAME` VARCHAR(50) NULL DEFAULT NULL,
  `ID` VARCHAR(50) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `TED`.`MESSAGE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TED`.`MESSAGE` (
  `SENDER` VARCHAR(50) NULL DEFAULT NULL,
  `CONTENT` TEXT NULL DEFAULT NULL,
  `RECEIVER` VARCHAR(50) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `TED`.`RESERVATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TED`.`RESERVATION` (
  `USER_NAME` VARCHAR(50) NULL DEFAULT NULL,
  `AD_ID` VARCHAR(50) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `TED`.`ROOM`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TED`.`ROOM` (
  `ID` VARCHAR(50) NOT NULL,
  `NAME` VARCHAR(100) NULL DEFAULT NULL,
  `DESCRIPTION` TEXT NULL DEFAULT NULL,
  `CITY` VARCHAR(50) NULL DEFAULT NULL,
  `STATE` VARCHAR(50) NULL DEFAULT NULL,
  `COUNTRY` VARCHAR(50) NULL DEFAULT NULL,
  `PIC` VARCHAR(2083) NULL DEFAULT NULL,
  `PRICE` VARCHAR(10) NULL DEFAULT NULL,
  `PRICE_PER_PERSON` FLOAT NULL DEFAULT NULL,
  `MAX_PEOPLE` FLOAT NULL DEFAULT NULL,
  `TYPE` VARCHAR(25) NULL DEFAULT NULL,
  `BEDS` INT(11) NULL DEFAULT NULL,
  `WCS` INT(11) NULL DEFAULT NULL,
  `BEDROOMS` INT(11) NULL DEFAULT NULL,
  `LIVING_ROOMS` INT(11) NULL DEFAULT NULL,
  `AREA` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `TED`.`USER_ACCOUNT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TED`.`USER_ACCOUNT` (
  `USER_NAME` VARCHAR(50) NOT NULL,
  `GENDER` CHAR(1) NULL DEFAULT NULL,
  `PASSWORD` VARCHAR(50) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(50) NULL DEFAULT NULL,
  `PHONE` VARCHAR(12) NULL DEFAULT NULL,
  `ROLE` CHAR(1) NOT NULL,
  `IMAGE` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`USER_NAME`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `TED`.`calendar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TED`.`calendar` (
  `listing_id` INT(11) NOT NULL,
  `date` VARCHAR(11) NOT NULL,
  `available` CHAR(1) NULL DEFAULT NULL,
  `price` VARCHAR(10) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
