-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: inventario_db
-- ------------------------------------------------------
-- Server version	9.7.0

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '0497ec70-3e81-11f1-9ab2-00e04ca610ee:1-73';

--
-- Table structure for table `herramientas`
--

DROP TABLE IF EXISTS `herramientas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `herramientas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) NOT NULL,
  `codigo` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `stockActual` int NOT NULL,
  `stockMinimo` int NOT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKs49lsh1ltkvyr4i7waaclb2in` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `herramientas`
--

LOCK TABLES `herramientas` WRITE;
/*!40000 ALTER TABLE `herramientas` DISABLE KEYS */;
INSERT INTO `herramientas` VALUES (1,'Llaves','HER-001','Juego de llaves mixtas','DISPONIBLE','Juego de llaves mixtas (2 juegos)',2,1,'Estante A1'),(2,'Llaves','HER-002','Juego de llaves Allen métricas','DISPONIBLE','Juego de llaves Allen métricas',3,1,'Estante A1'),(3,'Llaves','HER-003','Juego de dados y matraca','DISPONIBLE','Juego de dados y matraca',2,1,'Estante A2'),(4,'Llaves','HER-004','Llaves ajustables tipo francesa','DISPONIBLE','Llaves ajustables (francesas)',4,1,'Estante A2'),(5,'Llaves','HER-005','Llaves Stilson','DISPONIBLE','Llaves Stilson',3,1,'Estante A2'),(6,'Llaves','HER-006','Llaves de impacto','DISPONIBLE','Llaves de impacto neumáticas o eléctricas',2,1,'Estante A3'),(7,'Llaves','HER-007','Torquímetro de precisión','DISPONIBLE','Torquímetro',1,1,'Estante A3'),(8,'Herramientas Especiales','HER-008','Extractor de rodamientos','DISPONIBLE','Extractor de rodamientos',1,1,'Estante A4'),(9,'Percusión','HER-009','Martillo de bola','DISPONIBLE','Martillo de bola',5,2,'Estante B1'),(10,'Percusión','HER-010','Comba o mazo','DISPONIBLE','Comba o mazo',3,1,'Estante B1'),(11,'Percusión','HER-011','Juego de cinceles','DISPONIBLE','Cinceles',6,2,'Estante B1'),(12,'Percusión','HER-012','Juego de botadores','DISPONIBLE','Botadores',4,2,'Estante B2'),(13,'Percusión','HER-013','Palancas o barretas','DISPONIBLE','Palancas o barretas',3,1,'Estante B2'),(14,'Alicates','HER-014','Alicates universales','DISPONIBLE','Alicates universales',6,2,'Estante B3'),(15,'Alicates','HER-015','Alicates de presión','DISPONIBLE','Alicates de presión',4,2,'Estante B3'),(16,'Alicates','HER-016','Alicates de punta','DISPONIBLE','Alicates de punta',4,2,'Estante B3'),(17,'Alicates','HER-017','Juego de cortafríos','DISPONIBLE','Cortafríos',3,1,'Estante B4'),(18,'Manual','HER-018','Juego de destornilladores','DISPONIBLE','Destornilladores planos y estrella',8,3,'Estante B4'),(19,'Medición','HER-019','Calibrador Vernier','DISPONIBLE','Calibrador Vernier (pie de rey)',3,1,'Estante C1'),(20,'Medición','HER-020','Micrómetro de precisión','DISPONIBLE','Micrómetro',2,1,'Estante C1'),(21,'Medición','HER-021','Juego de galgas','DISPONIBLE','Galgas de espesores',2,1,'Estante C1'),(22,'Herramientas Especiales','HER-022','Prensa portátil','DISPONIBLE','Prensa portátil',1,1,'Estante C2'),(23,'Eléctrico','HER-023','Esmeril angular eléctrico','DISPONIBLE','Esmeril angular',2,1,'Estante C2'),(24,'Eléctrico','HER-024','Taladro industrial','DISPONIBLE','Taladro industrial',2,1,'Estante C2'),(25,'Eléctrico','HER-025','Juego de brocas','DISPONIBLE','Juego de brocas para metal',3,1,'Estante C3'),(26,'Corte','HER-026','Sierra manual','DISPONIBLE','Sierra manual para metal',3,1,'Estante C3'),(27,'Corte','HER-027','Sierra sable eléctrica','DISPONIBLE','Sierra sable',1,1,'Estante C3'),(28,'Herramientas Especiales','HER-028','Pistola de grasa','DISPONIBLE','Lubricadora o pistola de grasa',2,1,'Estante C4'),(29,'Eléctrico','HER-029','Multímetro digital','DISPONIBLE','Multímetro digital',3,1,'Estante D1'),(30,'Eléctrico','HER-030','Pinza amperimétrica','DISPONIBLE','Pinza amperimétrica',2,1,'Estante D1'),(31,'Eléctrico','HER-031','Megóhmetro Megger','DISPONIBLE','Megóhmetro (Megger)',1,1,'Estante D1'),(32,'Eléctrico','HER-032','Detector de tensión','DISPONIBLE','Detector de tensión',2,1,'Estante D2'),(33,'Eléctrico','HER-033','Probador de continuidad','DISPONIBLE','Probador de continuidad',2,1,'Estante D2'),(34,'Eléctrico','HER-034','Destornilladores aislados','DISPONIBLE','Juego de destornilladores aislados',3,1,'Estante D2'),(35,'Eléctrico','HER-035','Alicates aislados','DISPONIBLE','Alicates aislados',3,1,'Estante D3'),(36,'Izaje','HER-036','Tecle manual','DISPONIBLE','Tecle manual de cadena',1,1,'Estante E1'),(37,'Izaje','HER-037','Tirfor de arrastre','DISPONIBLE','Tirfor',1,1,'Estante E1'),(38,'Izaje','HER-038','Eslingas de poliéster','DISPONIBLE','Eslingas de poliéster',4,2,'Estante E1'),(39,'Izaje','HER-039','Juego de grilletes','DISPONIBLE','Grilletes',6,2,'Estante E2'),(40,'Izaje','HER-040','Gatas hidráulicas','DISPONIBLE','Gatas hidráulicas',2,1,'Estante E2'),(41,'Transporte','HER-041','Carretilla hidráulica','DISPONIBLE','Carretilla hidráulica',2,1,'Estante E3'),(42,'Transporte','HER-042','Rodillos de traslado','DISPONIBLE','Rodillos para traslado de equipos',4,2,'Estante E3'),(43,'Izaje','HER-043','Juego de poleas','DISPONIBLE','Poleas',3,1,'Estante E4'),(44,'Transporte','HER-044','Cintas de amarre','DISPONIBLE','Cintas de amarre',10,3,'Estante E4'),(45,'Limpieza','HER-045','Pala cuadrada','DISPONIBLE','Pala cuadrada',4,2,'Estante F1'),(46,'Limpieza','HER-046','Pala punta','DISPONIBLE','Pala punta',4,2,'Estante F1'),(47,'Limpieza','HER-047','Escobas industriales','DISPONIBLE','Escobas industriales',6,2,'Estante F1'),(48,'Limpieza','HER-048','Recogedor industrial','DISPONIBLE','Recogedor industrial',4,2,'Estante F2'),(49,'Limpieza','HER-049','Cepillos de acero','DISPONIBLE','Cepillos de acero',5,2,'Estante F2'),(50,'Limpieza','HER-050','Juego de espátulas','DISPONIBLE','Espátulas',6,2,'Estante F2'),(51,'Limpieza','HER-051','Trapos industriales','DISPONIBLE','Trapos industriales',20,5,'Estante F3'),(52,'EPP','HER-052','Casco de seguridad','DISPONIBLE','Casco de seguridad',15,5,'Estante G1'),(53,'EPP','HER-053','Lentes de seguridad','DISPONIBLE','Lentes de seguridad',15,5,'Estante G1'),(54,'EPP','HER-054','Protector facial','DISPONIBLE','Protector facial',8,3,'Estante G1'),(55,'EPP','HER-055','Guantes mecánicos','DISPONIBLE','Guantes mecánicos',12,4,'Estante G2'),(56,'EPP','HER-056','Guantes dieléctricos','DISPONIBLE','Guantes dieléctricos',6,2,'Estante G2'),(57,'EPP','HER-057','Respirador industrial','DISPONIBLE','Respirador',8,3,'Estante G2'),(58,'EPP','HER-058','Tapones auditivos','DISPONIBLE','Tapones auditivos',30,10,'Estante G3'),(59,'EPP','HER-059','Arnés de cuerpo completo','DISPONIBLE','Arnés de cuerpo completo',4,2,'Estante G3'),(60,'EPP','HER-060','Línea de vida','DISPONIBLE','Línea de vida',3,1,'Estante G3'),(61,'EPP','HER-061','Chaleco reflectivo','DISPONIBLE','Chaleco reflectivo',10,4,'Estante G4'),(62,'EPP','HER-062','Botas de seguridad','DISPONIBLE','Botas de seguridad',8,3,'Estante G4');
/*!40000 ALTER TABLE `herramientas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) NOT NULL,
  `herramienta_id` bigint NOT NULL,
  `usuario_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgqfjni7la83uc3ayqaogko22a` (`herramienta_id`),
  KEY `FK2ofduyqqwmyyf07vue5g6iv7m` (`usuario_id`),
  CONSTRAINT `FK2ofduyqqwmyyf07vue5g6iv7m` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKgqfjni7la83uc3ayqaogko22a` FOREIGN KEY (`herramienta_id`) REFERENCES `herramientas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,1,'2026-08-24 08:48:08.195691','Mantenimiento','SALIDA',1,2);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` bit(1) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKm2dvbwfge291euvmk6vkkocao` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,_binary '','Administrador','$2a$10$JDqq1etSD8pYA.iR3OYmie0WtHCUxqmvGe4W1zpcV.dKP4vwsJ242','ADMIN','admin'),(2,_binary '','Martin','$2a$10$XMnlfEjx24izO2lspESGuO3df72MtldozGPXG2sptsBOWuy17Fzm.','USER','alm01');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-08-24 13:33:17
