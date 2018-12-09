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

CREATE TABLE `filesystem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(100) DEFAULT NULL,
  `real_path` varchar(200) DEFAULT NULL,
  `relative_path` varchar(200) DEFAULT NULL,
  `content` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `xwlbo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` mediumtext,
  `location` varchar(100) DEFAULT NULL,
  `real_path` varchar(100) DEFAULT NULL,
  `relative_path` varchar(100) DEFAULT NULL,
  `news_date` date DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FULLTEXT KEY `content` (`content`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `english` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lv` int(11) DEFAULT NULL,
  `property` varchar(100) DEFAULT NULL,
  `english` varchar(100) DEFAULT NULL,
  `chinese` varchar(100) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `prononce` blob,
  `sentence` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

