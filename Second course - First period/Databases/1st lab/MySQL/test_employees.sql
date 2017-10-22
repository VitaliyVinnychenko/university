-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `fathers_name` varchar(45) NOT NULL,
  `uuid` varchar(45) DEFAULT NULL,
  `passport_id` varchar(8) DEFAULT NULL,
  `pharmacy_name` varchar(100) NOT NULL,
  `full_name` varchar(200) DEFAULT NULL,
  `experience_years` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `login` varchar(150) DEFAULT NULL,
  `job_level_name` varchar(100) NOT NULL,
  PRIMARY KEY (`first_name`,`last_name`,`fathers_name`,`pharmacy_name`,`job_level_name`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  KEY `passport_id` (`passport_id`),
  KEY `fk_employees_pharmacy_idx` (`pharmacy_name`),
  KEY `fk_employees_job_level1_idx` (`job_level_name`),
  CONSTRAINT `fk_employees_job_level1` FOREIGN KEY (`job_level_name`) REFERENCES `job_level` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_pharmacy` FOREIGN KEY (`pharmacy_name`) REFERENCES `pharmacy` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('Віталій','Вінниченко','Вікторович','25234288','вк123456','аптека 1','Віталій Вінниченко Вікторович',4,'1999-10-22 11:06:24','Вінниченко88','leader'),('Микола','Мацях','Ярославович','4325654','вк654321','аптека 101','Микола Мацях Ярославович',3,'2017-10-22 11:32:39','Мацях54','manager');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-22 11:59:46
