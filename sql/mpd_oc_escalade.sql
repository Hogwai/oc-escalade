-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema 
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mpd_oc_escalade`;

-- -----------------------------------------------------
-- Schema 
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mpd_oc_escalade` DEFAULT CHARACTER SET utf8 ;
USE `mpd_oc_escalade` ;

-- -----------------------------------------------------
-- Table `mpd_oc_escalade`.`site`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mpd_oc_escalade`.`site` ;

CREATE TABLE IF NOT EXISTS `mpd_oc_escalade`.`site` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(45) NULL,
  `hauteur` FLOAT NULL,
  `tagY_N` TINYINT NULL,
  `ville` VARCHAR(100) NULL,
  `pays` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mpd_oc_escalade`.`utilisateur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mpd_oc_escalade`.`utilisateur` ;

CREATE TABLE IF NOT EXISTS `mpd_oc_escalade`.`utilisateur` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  `numeroTel` VARCHAR(20) NULL,
  `adresse` VARCHAR(45) NULL,
  `codePostal` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `pseudo` VARCHAR(45) NULL,
  `motDePasse` VARCHAR(45) NULL,
  `membreAssoY_N` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mpd_oc_escalade`.`secteur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mpd_oc_escalade`.`secteur` ;

CREATE TABLE IF NOT EXISTS `mpd_oc_escalade`.`secteur` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(255) NULL,
  `site_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Secteur_Site1_idx` (`site_id` ASC) ,
  CONSTRAINT `fk_Secteur_Site1`
    FOREIGN KEY (`site_id`)
    REFERENCES `mpd_oc_escalade`.`site` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mpd_oc_escalade`.`cotation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mpd_oc_escalade`.`cotation` ;

CREATE TABLE IF NOT EXISTS `mpd_oc_escalade`.`cotation` (
  `id` INT NOT NULL,
  `libelle` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mpd_oc_escalade`.`voie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mpd_oc_escalade`.`voie` ;

CREATE TABLE IF NOT EXISTS `mpd_oc_escalade`.`voie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `equipeeY_N` TINYINT NOT NULL,
  `cotation_id` INT NOT NULL,
  `secteur_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Voie_Cotation1_idx` (`cotation_id` ASC),
  INDEX `fk_Voie_Secteur1_idx` (`secteur_id` ASC),
  CONSTRAINT `fk_Voie_Cotation1`
    FOREIGN KEY (`cotation_id`)
    REFERENCES `mpd_oc_escalade`.`cotation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Voie_Secteur1`
    FOREIGN KEY (`secteur_id`)
    REFERENCES `mpd_oc_escalade`.`secteur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mpd_oc_escalade`.`longueur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mpd_oc_escalade`.`longueur` ;

CREATE TABLE IF NOT EXISTS `mpd_oc_escalade`.`longueur` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `relaiY_N` TINYINT NOT NULL,
  `cotation_id` INT NOT NULL,
  `voie_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Longueur_Cotation1_idx` (`cotation_id` ASC),
  INDEX `fk_Longueur_Voie1_idx` (`voie_id` ASC),
  CONSTRAINT `fk_Longueur_Cotation1`
    FOREIGN KEY (`cotation_id`)
    REFERENCES `mpd_oc_escalade`.`cotation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Longueur_Voie1`
    FOREIGN KEY (`voie_id`)
    REFERENCES `mpd_oc_escalade`.`voie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mpd_oc_escalade`.`commentaire`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mpd_oc_escalade`.`commentaire` ;

CREATE TABLE IF NOT EXISTS `mpd_oc_escalade`.`commentaire` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contenu` VARCHAR(255) NULL,
  `utilisateur_id` INT NOT NULL,
  `site_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Commentaire_Utilisateur1_idx` (`utilisateur_id` ASC) ,
  INDEX `fk_Commentaire_Site1_idx` (`site_id` ASC) ,
  CONSTRAINT `fk_Commentaire_Utilisateur1`
    FOREIGN KEY (`utilisateur_id`)
    REFERENCES `mpd_oc_escalade`.`utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Commentaire_Site1`
    FOREIGN KEY (`site_id`)
    REFERENCES `mpd_oc_escalade`.`site` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mpd_oc_escalade`.`statut_topo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mpd_oc_escalade`.`statut_topo` ;

CREATE TABLE IF NOT EXISTS `mpd_oc_escalade`.`statut_topo` (
  `id` INT NOT NULL,
  `libelle` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mpd_oc_escalade`.`topo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mpd_oc_escalade`.`topo` ;

CREATE TABLE IF NOT EXISTS `mpd_oc_escalade`.`topo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(50) NULL,
  `description` VARCHAR(250) NULL,
  `date_parution` DATE NULL,
  `statut_topo_id` INT NOT NULL,
  `proprietaire_id` INT NOT NULL,
  `emprunteur_id` INT NULL,
  `site_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Topo_StatutTopo1_idx` (`statut_topo_id` ASC) ,
  INDEX `fk_Topo_Utilisateur1_idx` (`proprietaire_id` ASC) ,
  INDEX `fk_Topo_Utilisateur2_idx` (`emprunteur_id` ASC) ,
  INDEX `fk_Topo_Site1_idx` (`site_id` ASC) ,
  CONSTRAINT `fk_Topo_StatutTopo1`
    FOREIGN KEY (`statut_topo_id`)
    REFERENCES `mpd_oc_escalade`.`statut_topo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Topo_Utilisateur1`
    FOREIGN KEY (`proprietaire_id`)
    REFERENCES `mpd_oc_escalade`.`utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Topo_Utilisateur2`
    FOREIGN KEY (`emprunteur_id`)
    REFERENCES `mpd_oc_escalade`.`utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Topo_Site1`
    FOREIGN KEY (`site_id`)
    REFERENCES `mpd_oc_escalade`.`site` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
