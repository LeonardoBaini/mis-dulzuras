DROP SCHEMA IF EXISTS `misdulzuras`;
CREATE DATABASE   `misdulzuras` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `misdulzuras`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: misdulzuras
-- ------------------------------------------------------
-- Server version	5.5.19

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
-- Table structure for table `materia_prima`
--

DROP TABLE IF EXISTS `materia_prima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia_prima` (
  `nombre` varchar(45) NOT NULL,
  `unidadMedida` varchar(45) DEFAULT NULL,
  `cantidad` float DEFAULT NULL,
  `precioXumedida` float DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia_prima`
--

LOCK TABLES `materia_prima` WRITE;
/*!40000 ALTER TABLE `materia_prima` DISABLE KEYS */;
INSERT INTO `materia_prima` VALUES ('ALMIBAR','LT',10,15),('AZUCAR','KG',15,10.2),('CHOCOLATE','KG',10,50),('DULCE DE LECHE','KG',5,10.21),('HARINA','KG',50,8),('HUEVOS','KG',50,0.5),('LECHE','LT',10,12),('MAIZENA','KG',10,36),('POLVO DE HORNEAR','KG',1,100);
/*!40000 ALTER TABLE `materia_prima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `idcaja` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `concepto` varchar(100) DEFAULT NULL,
  `dinero` float DEFAULT NULL,
  `producto` varchar(100) DEFAULT NULL,
  `porcentaje_ganancia_estipulado` float DEFAULT NULL,
  PRIMARY KEY (`idcaja`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mostrador`
--

DROP TABLE IF EXISTS `mostrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mostrador` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `fecha_elaboracion` varchar(45) DEFAULT NULL,
  `precioVentaXunidad` float DEFAULT NULL,
  `dinero_a_reponer` float DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mostrador`
--

LOCK TABLES `mostrador` WRITE;
/*!40000 ALTER TABLE `mostrador` DISABLE KEYS */;
INSERT INTO `mostrador` VALUES (23,'Almibar','2014-05-03',60,15),(24,'Almibar','2014-05-03',60,15),(25,'Almibar','2014-05-03',60,15),(26,'Almibar','2014-05-03',60,15),(27,'Almibar','2014-05-03',60,15),(28,'Almibar','2014-05-03',60,15),(29,'Almibar','2014-05-03',60,15),(30,'Almibar','2014-05-03',60,15),(31,'Almibar','2014-05-03',60,15),(32,'Almibar','2014-05-03',60,15);
/*!40000 ALTER TABLE `mostrador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-03  2:38:40
