-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: userinfo
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `userbasicinfo`
--

DROP TABLE IF EXISTS `userbasicinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userbasicinfo` (
  `user_name` varchar(45) NOT NULL,
  `id` bigint NOT NULL,
  `email` varchar(30) NOT NULL,
  `user_password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userbasicinfo`
--

LOCK TABLES `userbasicinfo` WRITE;
/*!40000 ALTER TABLE `userbasicinfo` DISABLE KEYS */;
INSERT INTO `userbasicinfo` VALUES ('sasaki',0,'sasaki@a.jp','$2a$10$5KQDtI322AG7WqGT3ogdD.h066Qea4XhosAHEDF.KaM4GluuTlSmK'),('tanaka',0,'tanaka@a.jp','$2a$10$GExzHaMcUZ1oizCnXevWu.nv7LVKFjojN9vVS16V.87mKiDaikgNm'),('yamada',0,'yamada@a.jp','$2a$10$owVxq.JUM/M/yG16x3Y05uvA7H1/S/UM7byVxoS8G3wUeP8s0YYE2'),('a',0,'a','$2a$10$uRysGx/D0L32TYTayT/SH.baRM9k515UK5oYbbXheo493YWK0GG5u');
/*!40000 ALTER TABLE `userbasicinfo` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-16 21:02:11
