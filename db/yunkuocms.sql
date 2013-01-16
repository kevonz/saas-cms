SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `yunkuocms`.`yk_user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `yunkuocms`.`yk_user` (
  `user_id` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(100) NOT NULL ,
  `mobile` VARCHAR(20) NULL ,
  `email` VARCHAR(100) NULL ,
  `password` VARCHAR(100) NULL ,
  `register_time` DATETIME NULL ,
  `register_ip` VARCHAR(45) NULL ,
  `last_login_ip` VARCHAR(45) NULL ,
  `last_login_time` VARCHAR(45) NULL ,
  `login_count` INT NULL ,
  `error_count` INT NULL ,
  `error_time` DATETIME NULL ,
  `status` INT NULL ,
  PRIMARY KEY (`user_id`) ,
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yunkuocms`.`yk_user_ext`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `yunkuocms`.`yk_user_ext` (
  `ext_id` INT NOT NULL AUTO_INCREMENT ,
  `realname` VARCHAR(45) NULL ,
  `gender` INT NULL ,
  `yk_user_user_id` INT NOT NULL ,
  PRIMARY KEY (`ext_id`) ,
  INDEX `fk_yk_user_ext_yk_user` (`yk_user_user_id` ASC) ,
  CONSTRAINT `fk_yk_user_ext_yk_user`
    FOREIGN KEY (`yk_user_user_id` )
    REFERENCES `yunkuocms`.`yk_user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
