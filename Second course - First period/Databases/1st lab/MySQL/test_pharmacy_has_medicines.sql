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
-- Table structure for table `pharmacy_has_medicines`
--

DROP TABLE IF EXISTS `pharmacy_has_medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pharmacy_has_medicines` (
  `pharmacy_name` varchar(100) NOT NULL,
  `medicines_name` varchar(150) NOT NULL,
  PRIMARY KEY (`pharmacy_name`,`medicines_name`),
  KEY `fk_pharmacy_has_medicines_medicines1_idx` (`medicines_name`),
  KEY `fk_pharmacy_has_medicines_pharmacy1_idx` (`pharmacy_name`),
  CONSTRAINT `fk_pharmacy_has_medicines_medicines1` FOREIGN KEY (`medicines_name`) REFERENCES `medicines` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pharmacy_has_medicines_pharmacy1` FOREIGN KEY (`pharmacy_name`) REFERENCES `pharmacy` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy_has_medicines`
--

LOCK TABLES `pharmacy_has_medicines` WRITE;
/*!40000 ALTER TABLE `pharmacy_has_medicines` DISABLE KEYS */;
INSERT INTO `pharmacy_has_medicines` VALUES ('аптека 1','ношпа'),('аптека 1','парацитамол'),('аптека 101','грипекс'),('аптека 101','парацитамол'),('аптека 2','грипекс');
/*!40000 ALTER TABLE `pharmacy_has_medicines` ENABLE KEYS */;
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
