-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema drogaria
--

CREATE DATABASE IF NOT EXISTS drogaria;
USE drogaria;

--
-- Definition of table `fabricante`
--

DROP TABLE IF EXISTS `fabricante`;
CREATE TABLE `fabricante` (
  `fabcodigo` int(11) NOT NULL auto_increment,
  `fabdescricao` varchar(50) NOT NULL,
  PRIMARY KEY  (`fabcodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fabricante`
--

/*!40000 ALTER TABLE `fabricante` DISABLE KEYS */;
INSERT INTO `fabricante` (`fabcodigo`,`fabdescricao`) VALUES 
 (1,'Unileve'),
 (2,'Homo');
/*!40000 ALTER TABLE `fabricante` ENABLE KEYS */;


--
-- Definition of table `produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE `produto` (
  `procodigo` int(11) NOT NULL auto_increment,
  `prodescricao` varchar(50) NOT NULL,
  `proquantidade` int(11) NOT NULL,
  `provalor` decimal(5,2) NOT NULL,
  `profab_codigo` int(11) default NULL,
  PRIMARY KEY  (`procodigo`),
  KEY `profab_codigo` (`profab_codigo`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`profab_codigo`) REFERENCES `fabricante` (`fabcodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produto`
--

/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`procodigo`,`prodescricao`,`proquantidade`,`provalor`,`profab_codigo`) VALUES 
 (1,'Sabonete',1,'3.50',1),
 (2,'Dorflex',5,'4.00',1),
 (3,'Shampoo',1,'2.75',1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
