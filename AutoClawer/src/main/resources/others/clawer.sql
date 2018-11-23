CREATE DATABASE `clawer` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `clawer`.`gushi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` text,
  `age` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FULLTEXT KEY `content` (`content`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clawer`.`dictionary` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `english` VARCHAR(45) NULL,
  `chinese` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
