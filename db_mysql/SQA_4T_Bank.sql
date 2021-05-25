-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: sqa
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cmnd`
--

DROP TABLE IF EXISTS `cmnd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cmnd` (
  `SoCMND` varchar(255) NOT NULL,
  `ngaycap` varchar(255) DEFAULT NULL,
  `noicap` varchar(255) DEFAULT NULL,
  `DCthuongtru` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SoCMND`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmnd`
--

LOCK TABLES `cmnd` WRITE;
/*!40000 ALTER TABLE `cmnd` DISABLE KEYS */;
INSERT INTO `cmnd` VALUES ('001088011195','2012-02-05','Ha noi','Long bien Ha noi'),('001099011185','2012-02-05','Ha noi','Long bien Ha noi');
/*!40000 ALTER TABLE `cmnd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goivay`
--

DROP TABLE IF EXISTS `goivay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goivay` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `loaigoivayID` int NOT NULL,
  `Tengoi` varchar(255) DEFAULT NULL,
  `Laisuat` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKgoivayAndLoaigoivay` (`loaigoivayID`),
  CONSTRAINT `FKgoivayAndLoaigoivay` FOREIGN KEY (`loaigoivayID`) REFERENCES `loaigoivay` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goivay`
--

LOCK TABLES `goivay` WRITE;
/*!40000 ALTER TABLE `goivay` DISABLE KEYS */;
INSERT INTO `goivay` VALUES (1,1,'lai suat du no',0.06),(2,1,'lai suat co dinh',0.08);
/*!40000 ALTER TABLE `goivay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hopdongvay`
--

DROP TABLE IF EXISTS `hopdongvay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hopdongvay` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `goivayID` int NOT NULL,
  `userID` int NOT NULL,
  `tokhaiID` int NOT NULL,
  `Ngayvay` date DEFAULT NULL,
  `kiHan` varchar(255) DEFAULT NULL,
  `Trangthai` varchar(255) DEFAULT NULL,
  `TienVay` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKhopdongvayAndGoivay` (`goivayID`),
  KEY `FKhopdongvayAndUser` (`userID`),
  KEY `FKhopdongvayAndTokhai` (`tokhaiID`),
  CONSTRAINT `FKhopdongvayAndGoivay` FOREIGN KEY (`goivayID`) REFERENCES `goivay` (`ID`),
  CONSTRAINT `FKhopdongvayAndTokhai` FOREIGN KEY (`tokhaiID`) REFERENCES `tokhai` (`ID`),
  CONSTRAINT `FKhopdongvayAndUser` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hopdongvay`
--

LOCK TABLES `hopdongvay` WRITE;
/*!40000 ALTER TABLE `hopdongvay` DISABLE KEYS */;
INSERT INTO `hopdongvay` VALUES (10,1,2,1,'2021-04-13','3 thang','da duyet',41414),(14,1,2,2,'2021-05-05','3 thang','chua duyet',2331),(22,1,2,3,'2021-05-13','6 thang','chua duyet',22111),(23,2,2,4,'2021-04-23','3 thang','chua duyet',56677),(26,2,2,6,'2021-05-22','3 thang','chua duyet',555),(27,2,2,7,'2021-05-08','3 thang','chua duyet',222);
/*!40000 ALTER TABLE `hopdongvay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaigoivay`
--

DROP TABLE IF EXISTS `loaigoivay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaigoivay` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaigoivay`
--

LOCK TABLES `loaigoivay` WRITE;
/*!40000 ALTER TABLE `loaigoivay` DISABLE KEYS */;
INSERT INTO `loaigoivay` VALUES (1,'vay tin chap');
/*!40000 ALTER TABLE `loaigoivay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieunoptien`
--

DROP TABLE IF EXISTS `phieunoptien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunoptien` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `hopdongvayID` int NOT NULL,
  `ngaydong` date DEFAULT NULL,
  `tienlai` float DEFAULT NULL,
  `tiengoc` float DEFAULT NULL,
  `timeid` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKphieunoptienAndHopdongvay` (`hopdongvayID`),
  CONSTRAINT `FKphieunoptienAndHopdongvay` FOREIGN KEY (`hopdongvayID`) REFERENCES `hopdongvay` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunoptien`
--

LOCK TABLES `phieunoptien` WRITE;
/*!40000 ALTER TABLE `phieunoptien` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieunoptien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokhai`
--

DROP TABLE IF EXISTS `tokhai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokhai` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `Nghenghiep` varchar(255) DEFAULT NULL,
  `Chucvu` varchar(255) DEFAULT NULL,
  `Diachicongty` varchar(255) DEFAULT NULL,
  `Tencongty` varchar(255) DEFAULT NULL,
  `Mucluong` varchar(255) DEFAULT NULL,
  `Chitieuhangthang` varchar(255) DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ID`),
  KEY `FKtokhaiAndUser` (`userID`),
  CONSTRAINT `FKtokhaiAndUser` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokhai`
--

LOCK TABLES `tokhai` WRITE;
/*!40000 ALTER TABLE `tokhai` DISABLE KEYS */;
INSERT INTO `tokhai` VALUES (1,2,'hoc sinh','sinh vien','thanh xuan','PTIT','1 trieu den 5 trieu','1 Trieu den 5 trieu','2021-05-16 14:36:23',1),(2,2,'hoc sinh','sinh vien','thanh xuan','PTIT','1 trieu den 5 trieu','1 Trieu den 5 trieu','2021-05-16 14:36:23',1),(3,2,'hoc sinh','sinh vien','thanh xuan','PTIT','1 trieu den 5 trieu','1 Trieu den 5 trieu','2021-05-16 14:36:23',1),(4,2,'hoc sinh','sinh vien','thanh xuan','PTIT','1 trieu den 5 trieu','1 Trieu den 5 trieu','2021-05-16 14:36:23',1),(5,2,'hoc sinh','sinh vien','thanh xuan','PTIT','1 trieu den 5 trieu','1 Trieu den 5 trieu','2021-05-16 14:36:23',1),(6,2,'hoc sinh','sinh vien','thanh xuan','PTIT','1 trieu den 5 trieu','1 Trieu den 5 trieu','2021-05-16 14:36:23',1),(7,2,'hoc sinh','sinh vien','thanh xuan','PTIT','1 trieu den 5 trieu','1 Trieu den 5 trieu','2021-05-16 14:36:23',1);
/*!40000 ALTER TABLE `tokhai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Sdt` varchar(255) DEFAULT NULL,
  `Cmnd` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Diachi` varchar(255) DEFAULT NULL,
  `Hoten` varchar(255) DEFAULT NULL,
  `Ngaysinh` varchar(255) DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKUserAndCMND` (`Cmnd`),
  CONSTRAINT `FKUserAndCMND` FOREIGN KEY (`Cmnd`) REFERENCES `cmnd` (`SoCMND`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'0978878439','001099011185','sainttroll99@gmail.com','Soc Son - Ha Noi','Vu Chien Thang','1999-02-05','thangvu99','thang12345','customer'),(2,'0382999209','001088011195','toanta@gmail.com','Doi Can - Ha Noi','Ta Xuan Toan','1999-02-24','toanta99','toan12345','customer'),(3,'0988944109','00102345034','tuyentran@gmail.com','My Loc - Nam Dinh','Tran Sy Tuyen','1999-05-30','tuyentran99','tuyen12345','customer'),(4,'0328761111','098766888555','thinhme@gmail.com','Hoai Duc - Ha Noi','Me Duc Thinh','1999-10-06','thinhme99','thinh12345','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25 14:38:32
