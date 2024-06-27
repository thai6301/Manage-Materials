-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: newdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'Author 1','2024-06-20',_binary '\0','2023-01-01','Copper','Note 1','Publisher 1',1,NULL,1,'Copper is a soft, malleable, and ductile metal with very high thermal and electrical conductivity. It is used in electrical wiring, plumbing, and industrial machinery.'),(2,'Author 2','2024-06-20',_binary '\0','2023-02-01','Aluminum','Note 2','Publisher 2',2,NULL,2,'Aluminum is a lightweight, silvery-white metal known for its resistance to corrosion and its ability to form alloys with many other metals. Commonly used in aircraft, automotive parts, and packaging.'),(3,'Author 3','2024-06-20',_binary '\0','2023-03-01','Stainless','Note 3','Publisher 3',3,NULL,3,'Stainless steel is an alloy of iron that is resistant to rust, staining, and corrosion. It is widely used in kitchen utensils, medical instruments, and construction.'),(4,'Author 4','2024-06-20',_binary '\0','2023-04-01','Concrete','Note 4','Publisher 4',1,NULL,4,'Concrete is a composite material composed of fine and coarse aggregate bonded together with a fluid cement that hardens over time. It is used extensively in construction for buildings, bridges, and roads.'),(5,'Author 5','2024-06-20',_binary '\0','2023-05-01','Glassco','Note 5','Publisher 5',2,NULL,5,'Glass is a non-crystalline, often transparent amorphous solid that has widespread practical, technological, and decorative uses, such as in windows, tableware, and optoelectronics.'),(6,'Thaivid','2024-06-27',_binary '',NULL,'Gold',NULL,NULL,1,NULL,NULL,NULL),(7,'Thaivid2','2024-06-27',_binary '',NULL,'Gold 2',NULL,NULL,2,NULL,NULL,NULL),(8,'Thaivid','2024-06-27',_binary '',NULL,'Gold',NULL,NULL,1,NULL,NULL,NULL),(9,'Thaivid','2024-06-27',_binary '',NULL,'Gold',NULL,NULL,1,NULL,NULL,NULL),(10,'Author 6','2024-06-27',_binary '',NULL,'Gold',NULL,NULL,1,NULL,NULL,'Gold is a best metal ca ascasc ascacsa c'),(11,'Thai','2024-06-27',_binary '',NULL,'Gold',NULL,NULL,2,NULL,NULL,'Gold is a chemical element with the symbol Au (from the Latin word aurum) and the atomic number 79. In its pure form, it is a bright, slightly orange-yellow, dense, soft, malleable, and ductile metal.'),(12,'Thai02','2024-06-27',_binary '',NULL,'Diamond',NULL,NULL,2,NULL,NULL,'Diamond is a solid form of the element carbon with its atoms arranged in a crystal structure called diamond cubic. Another solid form of carbon known as graphite is the chemically stable form of carbon at room temperature and pressure'),(13,'Thaivid','2024-06-27',_binary '',NULL,'DiamondDash',NULL,NULL,2,NULL,NULL,'Diamond is a solid form of the element carbon with its atoms arranged in a crystal structure called diamond cubic. Another solid form of carbon known as graphite is the chemically stable form of carbon at room temperature and pressure'),(14,'Thaivid','2024-06-27',_binary '',NULL,'DiamondDashBig',NULL,NULL,2,NULL,NULL,'Gold is a chemical element with the symbol Au (from the Latin word aurum) and the atomic number 79. In its pure form, it is a bright, slightly orange-yellow, dense, soft, malleable, and ductile metal.'),(15,'Thaivid','2024-06-27',_binary '',NULL,'DiamondDashBig',NULL,NULL,5,NULL,NULL,'Gold is a best metal'),(16,'Thaivid','2024-06-27',_binary '',NULL,'DiamondDashbigbig',NULL,NULL,1,NULL,NULL,'Gold is a best metalGold is a best metalGold is a best metal'),(17,'Thaivid','2024-06-27',_binary '',NULL,'Gold',NULL,NULL,1,NULL,NULL,'Diamond is a solid form of the element carbon with its atoms arranged in a crystal structure called diamond cubic. Another solid form of carbon known as graphite is the chemically stable form of carbon at room temperature and pressure'),(18,'Thaivid','2024-06-27',_binary '',NULL,'Gold',NULL,NULL,1,NULL,NULL,'Gold is a best metal'),(19,'Thai02','2024-06-27',_binary '',NULL,'Diamond',NULL,NULL,2,NULL,NULL,'Diamond is a solid form of the element carbon with its atoms arranged in a crystal structure called diamond cubic. Another solid form of carbon known as graphite is the chemically stable form of carbon at room temperature and pressure');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `material_category`
--

LOCK TABLES `material_category` WRITE;
/*!40000 ALTER TABLE `material_category` DISABLE KEYS */;
INSERT INTO `material_category` VALUES (1,'Category1'),(2,'Category2'),(3,'Category3'),(4,'Category4'),(5,'Category5');
/*!40000 ALTER TABLE `material_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `material_item`
--

LOCK TABLES `material_item` WRITE;
/*!40000 ALTER TABLE `material_item` DISABLE KEYS */;
INSERT INTO `material_item` VALUES (1,'2024-06-20 05:42:45.000000',NULL,'user1',1,1,1,1,100,500,'Version 1',NULL),(2,'2024-06-20 05:42:45.000000',NULL,'user2',1,1,2,2,200,1000,'Version 2',NULL),(3,'2024-06-20 05:42:45.000000',NULL,'user3',1,1,3,3,300,1500,'Version 3',NULL),(4,'2024-06-20 05:42:45.000000',NULL,'user4',1,1,4,1,400,2000,'Version 4',NULL),(5,'2024-06-20 05:42:45.000000',NULL,'user5',1,1,5,2,500,2500,'Version 5',NULL);
/*!40000 ALTER TABLE `material_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `material_type`
--

LOCK TABLES `material_type` WRITE;
/*!40000 ALTER TABLE `material_type` DISABLE KEYS */;
INSERT INTO `material_type` VALUES (1,'Type 1'),(2,'Type 2'),(3,'Type 3'),(4,'Type 4'),(5,'Type 5');
/*!40000 ALTER TABLE `material_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rel_material_cat`
--

LOCK TABLES `rel_material_cat` WRITE;
/*!40000 ALTER TABLE `rel_material_cat` DISABLE KEYS */;
INSERT INTO `rel_material_cat` VALUES (1,1,1),(2,2,1),(3,3,2),(4,1,3),(5,2,3),(6,4,4),(7,3,4),(8,5,5),(9,1,5),(10,2,5),(11,10,0),(12,2,7),(13,1,8),(14,1,9),(15,1,10),(16,1,11),(17,3,12),(18,1,13),(19,1,14),(20,5,15),(21,1,16),(22,1,17),(23,1,18),(24,2,18),(25,1,19),(26,2,19);
/*!40000 ALTER TABLE `rel_material_cat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-27 20:50:52
