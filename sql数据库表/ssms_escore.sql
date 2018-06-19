CREATE DATABASE  IF NOT EXISTS `ssms` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ssms`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ssms
-- ------------------------------------------------------
-- Server version	5.1.49-community

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
-- Table structure for table `escore`
--

DROP TABLE IF EXISTS `escore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examid` int(11) DEFAULT NULL,
  `clazzid` int(11) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  `courseid` int(11) DEFAULT NULL,
  `score` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `eid_escore_FK` (`examid`),
  KEY `sid_escore_FK` (`studentid`),
  KEY `clazzid_escore_FK` (`clazzid`),
  KEY `courseid_escore_FK` (`courseid`),
  KEY `gradeid_escore_FK` (`gradeid`),
  CONSTRAINT `clazzid_escore_FK` FOREIGN KEY (`clazzid`) REFERENCES `clazz` (`id`),
  CONSTRAINT `courseid_escore_FK` FOREIGN KEY (`courseid`) REFERENCES `grade_course` (`courseid`),
  CONSTRAINT `examid_escore_FK` FOREIGN KEY (`examid`) REFERENCES `exam` (`id`),
  CONSTRAINT `gradeid_escore_FK` FOREIGN KEY (`gradeid`) REFERENCES `grade_course` (`gradeid`),
  CONSTRAINT `studentid_escore_FK` FOREIGN KEY (`studentid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escore`
--

LOCK TABLES `escore` WRITE;
/*!40000 ALTER TABLE `escore` DISABLE KEYS */;
INSERT INTO `escore` VALUES (224,3,10,71,3,2,100),(225,3,10,71,3,5,NULL),(226,3,10,71,3,7,NULL),(227,3,10,71,3,8,NULL),(228,3,10,72,3,2,100),(229,3,10,72,3,5,NULL),(230,3,10,72,3,7,NULL),(231,3,10,72,3,8,NULL),(232,3,9,73,3,2,99),(233,3,9,73,3,5,NULL),(234,3,9,73,3,7,NULL),(235,3,9,73,3,8,NULL),(236,3,9,74,3,2,100),(237,3,9,74,3,5,NULL),(238,3,9,74,3,7,NULL),(239,3,9,74,3,8,NULL),(240,4,10,71,3,2,NULL),(241,4,10,71,3,5,NULL),(242,4,10,71,3,7,NULL),(243,4,10,71,3,8,NULL),(244,4,10,72,3,2,NULL),(245,4,10,72,3,5,NULL),(246,4,10,72,3,7,NULL),(247,4,10,72,3,8,NULL),(248,4,9,73,3,2,99),(249,4,9,73,3,5,NULL),(250,4,9,73,3,7,NULL),(251,4,9,73,3,8,NULL),(252,4,9,74,3,2,100),(253,4,9,74,3,5,NULL),(254,4,9,74,3,7,NULL),(255,4,9,74,3,8,NULL),(256,4,9,77,3,2,10),(257,4,9,77,3,5,NULL),(258,4,9,77,3,7,NULL),(259,4,9,77,3,8,NULL);
/*!40000 ALTER TABLE `escore` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-15 15:34:08
