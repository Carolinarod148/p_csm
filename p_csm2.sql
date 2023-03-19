CREATE DATABASE  IF NOT EXISTS `p_csm2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `p_csm2`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: p_csm2
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `cartera`
--

DROP TABLE IF EXISTS `cartera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartera` (
  `cod_cartera` int NOT NULL,
  `num_orden_cartera` int NOT NULL,
  `fec_ini` date NOT NULL,
  `fec_fin` date NOT NULL,
  `estado_pago` tinyint DEFAULT NULL,
  PRIMARY KEY (`cod_cartera`),
  KEY `num_orden_cartera_idx` (`num_orden_cartera`),
  CONSTRAINT `num_orden_cartera` FOREIGN KEY (`num_orden_cartera`) REFERENCES `orden_entrada` (`num_ord_ent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartera`
--

LOCK TABLES `cartera` WRITE;
/*!40000 ALTER TABLE `cartera` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_cat` int NOT NULL AUTO_INCREMENT,
  `nombre_cat` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'herramienta manual'),(3,'EPP');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_entrada`
--

DROP TABLE IF EXISTS `detalle_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_entrada` (
  `id_det_ent` int NOT NULL,
  `num_ordent` int NOT NULL,
  `cod_prod_entrada` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`id_det_ent`),
  KEY `num_ordent_idx` (`num_ordent`),
  KEY `cod_prod_idx` (`cod_prod_entrada`),
  CONSTRAINT `cod_prod_entrada` FOREIGN KEY (`cod_prod_entrada`) REFERENCES `producto` (`cod_prod`),
  CONSTRAINT `num_ordent` FOREIGN KEY (`num_ordent`) REFERENCES `orden_entrada` (`num_ord_ent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_entrada`
--

LOCK TABLES `detalle_entrada` WRITE;
/*!40000 ALTER TABLE `detalle_entrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pedido`
--

DROP TABLE IF EXISTS `detalle_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_pedido` (
  `cod_det_ped` int NOT NULL AUTO_INCREMENT,
  `num_pedido` int DEFAULT NULL,
  `cod_prod` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`cod_det_ped`),
  KEY `cod_prod_idx` (`cod_prod`),
  KEY `num_pedido_idx` (`num_pedido`),
  CONSTRAINT `cod_prod` FOREIGN KEY (`cod_prod`) REFERENCES `producto` (`cod_prod`),
  CONSTRAINT `num_pedido` FOREIGN KEY (`num_pedido`) REFERENCES `pedido` (`num_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedido`
--

LOCK TABLES `detalle_pedido` WRITE;
/*!40000 ALTER TABLE `detalle_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_pedido`
--

DROP TABLE IF EXISTS `estado_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado_pedido` (
  `cod_estado` int NOT NULL AUTO_INCREMENT,
  `nom_estado` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cod_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_pedido`
--

LOCK TABLES `estado_pedido` WRITE;
/*!40000 ALTER TABLE `estado_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `cod_inv` int NOT NULL AUTO_INCREMENT,
  `cod_produc_inv` int DEFAULT NULL,
  `cantidad` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fec_ingreso` date DEFAULT NULL,
  `fec_salida` date DEFAULT NULL,
  `estado` tinyint DEFAULT NULL,
  PRIMARY KEY (`cod_inv`),
  KEY `cod_produc_inv_idx` (`cod_produc_inv`),
  CONSTRAINT `cod_produc_inv` FOREIGN KEY (`cod_produc_inv`) REFERENCES `producto` (`cod_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_entrada`
--

DROP TABLE IF EXISTS `orden_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_entrada` (
  `num_ord_ent` int NOT NULL AUTO_INCREMENT,
  `num_factura` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `fec_ftura` date DEFAULT NULL,
  `ndoc_proveedor` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`num_ord_ent`),
  KEY `ndoc_proveedor_idx` (`ndoc_proveedor`),
  CONSTRAINT `ndoc_proveedor` FOREIGN KEY (`ndoc_proveedor`) REFERENCES `usuario` (`num_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_entrada`
--

LOCK TABLES `orden_entrada` WRITE;
/*!40000 ALTER TABLE `orden_entrada` DISABLE KEYS */;
INSERT INTO `orden_entrada` VALUES (1,'234','2022-03-22','123');
/*!40000 ALTER TABLE `orden_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `num_pedido` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `dir_envio` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cod_est_pedido` int DEFAULT NULL,
  `ndoc_client` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`num_pedido`),
  KEY `ndoc_client_idx` (`ndoc_client`),
  KEY `cod_est_pedido_idx` (`cod_est_pedido`),
  CONSTRAINT `cod_est_pedido` FOREIGN KEY (`cod_est_pedido`) REFERENCES `estado_pedido` (`cod_estado`),
  CONSTRAINT `ndoc_client` FOREIGN KEY (`ndoc_client`) REFERENCES `usuario` (`num_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `cod_prod` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cod_categoria` int DEFAULT NULL,
  `cod_unimed` int DEFAULT NULL,
  `descripción` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cod_prod`),
  KEY `cod_categoria_idx` (`cod_categoria`),
  KEY `cod_unimed_idx` (`cod_unimed`),
  CONSTRAINT `cod_categoria` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria` (`id_cat`),
  CONSTRAINT `cod_unimed` FOREIGN KEY (`cod_unimed`) REFERENCES `unidad_medida` (`cod_unimed`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (3,'Espatula',1,1,'de 4 nn'),(4,'Pala',1,1,'Cuadrada de 4 nn'),(47,'Martillo',1,1,'de uña de 7\"');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `cod_rol` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom_rol` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cod_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES ('1','administrador'),('2','proveedor'),('3','cliente');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_doc`
--

DROP TABLE IF EXISTS `tipo_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_doc` (
  `cod_tdoc` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tipo_doc` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cod_tdoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_doc`
--

LOCK TABLES `tipo_doc` WRITE;
/*!40000 ALTER TABLE `tipo_doc` DISABLE KEYS */;
INSERT INTO `tipo_doc` VALUES ('1','CC'),('2','NIT'),('3','CE');
/*!40000 ALTER TABLE `tipo_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_medida`
--

DROP TABLE IF EXISTS `unidad_medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidad_medida` (
  `cod_unimed` int NOT NULL AUTO_INCREMENT,
  `nombre_unidad_medida` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cod_unimed`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_medida`
--

LOCK TABLES `unidad_medida` WRITE;
/*!40000 ALTER TABLE `unidad_medida` DISABLE KEYS */;
INSERT INTO `unidad_medida` VALUES (1,'UN',NULL),(2,'KG',NULL);
/*!40000 ALTER TABLE `unidad_medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `tipo_documento` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `num_doc` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `clave` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `pnom` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `snom` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pape` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sape` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rs` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tel` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`num_doc`),
  KEY `tipo_documento_idx` (`tipo_documento`),
  CONSTRAINT `tipo_documento` FOREIGN KEY (`tipo_documento`) REFERENCES `tipo_doc` (`cod_tdoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('2','123','123','Carlos','Gilberto','Begambre',':)','Natural','123456789','c@gmail.com'),('2','12345','098','Jean','Mateo','rico','laverde','natural','2345','g@gmail.com'),('3','34','65432','diana ','carolina','RODRIGUEZ','AMADO','natural','ert','nm@gmail.com'),('1','567','876','Jonathan','La ','mas ','bella','natural','678865','m@hotmail.com'),('1','9876','76','efv','Justo Emilio','Lopez','Camelo','natural','7865','jhyg@gmail.com');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_rol` (
  `cod_utr` int NOT NULL,
  `cod_rol` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ndoc_usu` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cod_utr`),
  KEY `cod_rol_idx` (`cod_rol`),
  KEY `ndoc_usu_idx` (`ndoc_usu`),
  CONSTRAINT `cod_rol` FOREIGN KEY (`cod_rol`) REFERENCES `rol` (`cod_rol`),
  CONSTRAINT `ndoc_usu` FOREIGN KEY (`ndoc_usu`) REFERENCES `usuario` (`num_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,'2','123'),(2,'2','12345'),(4,'2','567');
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'p_csm2'
--

--
-- Dumping routines for database 'p_csm2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-19 15:10:51
