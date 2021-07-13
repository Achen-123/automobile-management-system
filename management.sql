/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.20 : Database - management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`management` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `management`;

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `cid` int(8) NOT NULL AUTO_INCREMENT,
  `carname` varchar(12) NOT NULL,
  `carnumber` varchar(12) NOT NULL,
  `carcolor` varchar(12) DEFAULT NULL,
  `carorder` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `carnumber` (`carnumber`),
  UNIQUE KEY `carorder` (`carorder`),
  CONSTRAINT `car_fk1` FOREIGN KEY (`carorder`) REFERENCES `orders` (`carorder`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `car_fk2` FOREIGN KEY (`carorder`) REFERENCES `orders` (`carorder`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

/*Data for the table `car` */

insert  into `car`(`cid`,`carname`,`carnumber`,`carcolor`,`carorder`) values (1,'迈腾','浙A*00000','黑色',NULL),(2,'高尔夫','浙C*00000','蓝色',NULL),(3,'速腾','浙A*12345','蓝色',NULL),(4,'速腾','浙B*00000','白色',NULL),(5,'捷达','浙A*10000','红色',NULL);

/*Table structure for table `carstate` */

DROP TABLE IF EXISTS `carstate`;

CREATE TABLE `carstate` (
  `sid` int(8) NOT NULL AUTO_INCREMENT,
  `located` varchar(12) NOT NULL,
  `carcond` varchar(12) NOT NULL,
  `carnumber` varchar(12) NOT NULL,
  `carorder` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `carstate_fk1` (`carnumber`),
  KEY `carstate_fk2` (`carorder`),
  CONSTRAINT `carstate_fk1` FOREIGN KEY (`carnumber`) REFERENCES `car` (`carnumber`) ON UPDATE CASCADE,
  CONSTRAINT `carstate_fk2` FOREIGN KEY (`carorder`) REFERENCES `orders` (`carorder`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

/*Data for the table `carstate` */

insert  into `carstate`(`sid`,`located`,`carcond`,`carnumber`,`carorder`) values (3,'入店','待维修','浙C*00000',NULL),(4,'入店','已维修','浙A*00000',NULL),(5,'入店','维修中','浙B*00000',NULL),(6,'入店','已维修','浙A*12345',NULL);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` int(8) NOT NULL AUTO_INCREMENT,
  `carorder` varchar(16) NOT NULL,
  `memberid` varchar(12) NOT NULL,
  PRIMARY KEY (`oid`),
  UNIQUE KEY `carorder` (`carorder`),
  KEY `orders_fk2` (`memberid`),
  CONSTRAINT `orders_fk2` FOREIGN KEY (`memberid`) REFERENCES `owners` (`memberid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`carorder`,`memberid`) values (1,'00002','001'),(2,'212121','001'),(4,'012000','003'),(5,'122255','003'),(6,'000000023','002');

/*Table structure for table `owners` */

DROP TABLE IF EXISTS `owners`;

CREATE TABLE `owners` (
  `ownerid` int(8) NOT NULL AUTO_INCREMENT,
  `carowner` char(12) NOT NULL,
  `carnumber` varchar(12) NOT NULL,
  `phonenum` varchar(12) NOT NULL,
  `ownersex` varchar(12) NOT NULL,
  `memberid` varchar(12) DEFAULT NULL,
  `carorder` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`ownerid`),
  UNIQUE KEY `memberid` (`memberid`),
  UNIQUE KEY `carorder` (`carorder`),
  KEY `owners_fk1` (`carnumber`),
  CONSTRAINT `owners_fk1` FOREIGN KEY (`carnumber`) REFERENCES `car` (`carnumber`) ON UPDATE CASCADE,
  CONSTRAINT `owners_fk2` FOREIGN KEY (`carorder`) REFERENCES `orders` (`carorder`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

/*Data for the table `owners` */

insert  into `owners`(`ownerid`,`carowner`,`carnumber`,`phonenum`,`ownersex`,`memberid`,`carorder`) values (1,'小明','浙A*00000','1382045362','woman','001',NULL),(3,'池的','浙C*00000','1187125423','man','002',NULL),(4,'小陈','浙B*00000','13757728350','man','003',NULL),(5,'花花','浙A*12345','1370256412','man','004',NULL);

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `snum` int(8) NOT NULL AUTO_INCREMENT,
  `scondition` varchar(12) NOT NULL,
  `number` varchar(12) NOT NULL,
  PRIMARY KEY (`snum`),
  UNIQUE KEY `uindex` (`number`),
  CONSTRAINT `state_fk1` FOREIGN KEY (`number`) REFERENCES `userinfo` (`number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

/*Data for the table `state` */

insert  into `state`(`snum`,`scondition`,`number`) values (3,'离职','003'),(8,'离职','001'),(9,'离职','006');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `number` varchar(12) NOT NULL,
  `pwd` varchar(12) NOT NULL,
  `sex` varchar(12) NOT NULL,
  `department` varchar(12) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`username`,`number`,`pwd`,`sex`,`department`) values (1,'xiaoming','001','000000','man','aftermarket'),(3,'小陈','003','2','man','aftermarket'),(4,'root','1','1','man','management'),(5,'小王','004','004','man','management'),(6,'小陈','005','005','man','aftermarket'),(7,'小李','006','006','woman','aftermarket'),(8,'哈哈','007','007','woman','group');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
