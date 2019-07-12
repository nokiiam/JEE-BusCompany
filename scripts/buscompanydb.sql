-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema buscompanydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema buscompanydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `buscompanydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `buscompanydb` ;

-- -----------------------------------------------------
-- Table `buscompanydb`.`bus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `buscompanydb`.`bus` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `registration` VARCHAR(9) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `capacity` INT(11) NOT NULL,
  `release_year` DATETIME NOT NULL,
  `kilometers` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `registration_UNIQUE` (`registration` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `buscompanydb`.`bus_line`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `buscompanydb`.`bus_line` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `number_UNIQUE` (`number` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `buscompanydb`.`bus_stop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `buscompanydb`.`bus_stop` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `buscompanydb`.`bus_line_stop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `buscompanydb`.`bus_line_stop` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `bus_line_id` INT(11) NOT NULL,
  `bus_stop_id` INT(11) NOT NULL,
  `order` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `bus_stop_id_idx` (`bus_stop_id` ASC) VISIBLE,
  INDEX `bus_line_id_idx` (`bus_line_id` ASC) VISIBLE,
  CONSTRAINT `fk_bus_line_stop_bus_line_idx`
    FOREIGN KEY (`bus_line_id`)
    REFERENCES `buscompanydb`.`bus_line` (`id`),
  CONSTRAINT `fk_bus_line_stop_bus_stop_idx`
    FOREIGN KEY (`bus_stop_id`)
    REFERENCES `buscompanydb`.`bus_stop` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `buscompanydb`.`driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `buscompanydb`.`driver` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(6) NOT NULL,
  `birth_date` DATETIME NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `status` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `buscompanydb`.`slot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `buscompanydb`.`slot` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `is_morning` TINYINT(4) NOT NULL,
  `driver_id` INT(11) NOT NULL,
  `bus_id` INT(11) NOT NULL,
  `bus_line_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `driver_id_idx` (`driver_id` ASC) VISIBLE,
  INDEX `bus_id_idx` (`bus_id` ASC) VISIBLE,
  INDEX `bus_line_id_idx` (`bus_line_id` ASC) VISIBLE,
  CONSTRAINT `bus_id`
    FOREIGN KEY (`bus_id`)
    REFERENCES `buscompanydb`.`bus` (`id`),
  CONSTRAINT `bus_line_id`
    FOREIGN KEY (`bus_line_id`)
    REFERENCES `buscompanydb`.`bus_line` (`id`),
  CONSTRAINT `driver_id`
    FOREIGN KEY (`driver_id`)
    REFERENCES `buscompanydb`.`driver` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `buscompanydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `buscompanydb`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `driver_code` VARCHAR(45) NULL DEFAULT NULL,
  `profile` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  INDEX `fk_user_driver_idx_idx` (`driver_code` ASC) VISIBLE,
  CONSTRAINT `fk_user_driver_codex`
    FOREIGN KEY (`driver_code`)
    REFERENCES `buscompanydb`.`driver` (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
