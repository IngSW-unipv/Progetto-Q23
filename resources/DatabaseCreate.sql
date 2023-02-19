CREATE DATABASE  IF NOT EXISTS `airmanager`;
USE `airmanager`;

-- Host: localhost    Database: trenissimo


-- Create Table for Account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci; -- check this line

 -- Input some sample data for minimum account number of 1 for admin
LOCK TABLES `account` WRITE;
INSERT INTO `account` VALUES ('admin1','password');
UNLOCK TABLES;
