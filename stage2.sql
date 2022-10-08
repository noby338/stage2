-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: stage2
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
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `class_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'一班'),(2,'二班'),(3,'三班'),(4,'四班'),(5,'五班'),(6,'六班'),(7,'七班'),(8,'八班'),(9,'九班');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_teacher_map`
--

DROP TABLE IF EXISTS `class_teacher_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_teacher_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `avr_score` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `class_teacher_map_id_uindex` (`id`),
  KEY `class_teacher_map_class_id_fk` (`cid`),
  KEY `class_teacher_map_teacher_id_fk` (`tid`),
  CONSTRAINT `class_teacher_map_class_id_fk` FOREIGN KEY (`cid`) REFERENCES `class` (`id`),
  CONSTRAINT `class_teacher_map_teacher_id_fk` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_teacher_map`
--

LOCK TABLES `class_teacher_map` WRITE;
/*!40000 ALTER TABLE `class_teacher_map` DISABLE KEYS */;
INSERT INTO `class_teacher_map` VALUES (1,1,1,70),(2,1,2,70),(3,1,3,70),(4,1,5,70),(5,2,6,70),(6,2,4,70),(7,2,7,79),(8,3,6,79),(9,3,7,79),(10,3,8,79),(11,3,9,79),(12,4,2,79),(13,4,5,82),(14,5,2,82),(15,5,6,82),(16,6,4,82),(17,6,10,82),(18,7,7,82),(19,8,9,82),(20,9,10,91);
/*!40000 ALTER TABLE `class_teacher_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `cellphone` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `profession` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `customer_cid_uindex` (`cid`),
  UNIQUE KEY `customer_cid_uindex_2` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'张玉珍','女','1987-05-10','18952411003','natian@example.org','工程/设备经理'),(2,'陆兰英','男','1989-08-15','18186381112','minhuang@example.org','市场助理'),(3,'宋莉','男','1985-07-16','18933655228','shifang@example.net','销售代表'),(4,'罗伟','女','1988-06-22','18744004641','wanyong@example.org','会务/会展主管'),(5,'孙桂芳','男','1983-11-20','15238867810','minzhang@example.com','市场/营销/拓展主管'),(6,'廖磊','女','1996-10-16','13791865535','qiangcheng@example.net','物业设施管理人员'),(7,'李岩','男','1985-12-05','13925638942','yshen@example.com','地勤人员'),(8,'曾婷婷','女','1996-10-06','15231525727','gangxia@example.net','工厂经理/厂长'),(9,'吴琳','女','2001-06-10','15838563336','qiang25@example.org','嵌入式硬件开发(主板机…)'),(10,'黄婷','女','1996-03-16','18537516461','heyan@example.com','市场企划专员'),(11,'贾波','男','1994-01-15','18866709743','wbai@example.net','医疗器械研发'),(12,'欧秀芳','女','1999-11-17','15914117255','xsu@example.org','网店/淘宝运营'),(13,'周涛','男','1992-11-06','13358734890','yang98@example.net','财务总监'),(14,'李丹丹','女','1989-06-25','18167240986','jiangwei@example.net','刨工'),(15,'谭洁','男','1986-10-17','13216816188','xiulansong@example.com','证券/期货/外汇经纪人'),(16,'方桂香','男','1993-12-07','13026186184','maoguiying@example.net','晒版员'),(17,'赵成','女','1990-08-02','18997390306','bsun@example.net','珠宝销售顾问'),(18,'黄莉','女','1990-09-11','18632848141','zhongming@example.org','保险内勤'),(19,'吴丽娟','女','1989-07-23','18113524189','npan@example.org','系统管理员/网络管理员'),(20,'刘颖','男','1988-05-28','13045945439','maxia@example.net','会计'),(21,'孟玉','男','1990-10-05','18547454298','gangxue@example.com','可靠度工程师'),(22,'王龙','女','1991-07-11','18551754308','shiguiying@example.net','IT-管理'),(23,'叶淑英','男','1984-07-28','13200748672','fang59@example.net','英语翻译'),(24,'王磊','男','1997-01-14','15893264040','xiulan35@example.com','其他'),(25,'钱敏','女','1990-03-04','18529977717','ping05@example.com','服装领班'),(26,'杨玉珍','女','1991-09-15','13263903257','guiying50@example.net','酒店前台'),(27,'张阳','女','1998-07-24','13464763223','minqin@example.net','西餐厨师'),(28,'王林','女','1999-05-04','13165300520','fang60@example.net','园艺/园林/景观设计'),(29,'周海燕','女','1988-08-06','13128752238','ping29@example.net','灯光师'),(30,'张淑华','男','1994-03-03','13182723431','guiying52@example.com','摄影师/摄像师'),(31,'吴秀梅','男','1993-07-24','14514237056','jun05@example.net','餐饮服务员'),(32,'赵鹏','男','1998-01-29','15713890013','pingcui@example.org','调色员'),(33,'赵亮','男','1990-11-28','18735336060','xuli@example.net','房地产投资分析'),(34,'徐燕','女','1989-04-11','13151516137','chao53@example.org','洗衣工'),(35,'成雪梅','男','1996-06-10','13678097047','tao62@example.com','企业策划人员'),(36,'沈龙','男','1989-10-31','13877376869','yong93@example.com','网店/淘宝客服'),(37,'杜琳','男','1989-09-14','15980475062','kzhong@example.org','中餐厨师'),(38,'吴玉','女','1992-07-06','15816194367','caili@example.com','机械机床'),(39,'程涛','女','1989-08-16','14587139032','xiaoxiuying@example.org','清算人员'),(40,'田红梅','男','1999-08-13','15282459536','junlei@example.net','媒介经理');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dep`
--

DROP TABLE IF EXISTS `dep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dep` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dep_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dep`
--

LOCK TABLES `dep` WRITE;
/*!40000 ALTER TABLE `dep` DISABLE KEYS */;
INSERT INTO `dep` VALUES (1,'研发部'),(2,'销售部'),(3,'财务部'),(4,'人力资源部'),(5,'采购部');
/*!40000 ALTER TABLE `dep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Emp_id_uindex` (`id`),
  KEY `emp_dep_id_fk` (`did`),
  CONSTRAINT `emp_dep_id_fk` FOREIGN KEY (`did`) REFERENCES `dep` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'许丽华',4),(2,'周宁',5),(3,'厉红梅',5),(4,'严秀华',2),(5,'戴建',2),(6,'许艳',2),(7,'姚东',1),(8,'王洋',5),(9,'田健',3),(10,'蒋军',4),(11,'朱俊',2),(12,'齐娜',2),(13,'谢峰',4),(14,'高慧',4),(15,'刘洁',4),(16,'常琳',3),(17,'周秀荣',2),(18,'封琳',1),(19,'吕磊',1),(20,'吴博',3);
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'刘辉',1,'1984-05-28'),(2,'敬丽华',1,'1989-08-26'),(3,'张华',0,'1995-06-17'),(4,'樊旭',0,'2001-07-25'),(5,'戴桂英',0,'1995-05-04'),(6,'陈璐',0,'1994-05-29'),(7,'李淑华',1,'2000-12-03'),(8,'陈雪梅',0,'1987-12-10'),(9,'林亮',0,'1996-10-26'),(10,'陈兵',1,'1988-02-12'),(11,'丁健',1,'1986-05-03'),(12,'石丹',1,'1998-09-09'),(13,'邓璐',1,'2002-04-14'),(14,'胡秀芳',1,'2002-06-20'),(15,'谢鑫',0,'1993-11-02'),(16,'刘坤',0,'1996-03-12'),(17,'黄小红',1,'2002-07-10'),(18,'倪波',1,'1987-07-05'),(19,'胡丹',0,'1992-10-11'),(20,'雷俊',1,'1996-03-07'),(21,'王东',1,'1985-01-16'),(22,'李慧',1,'1992-01-18'),(23,'齐利',0,'1985-10-22'),(24,'蒋兵',0,'2001-02-08'),(25,'张凤英',0,'1983-11-19'),(26,'向帆',0,'1988-12-11'),(27,'何冬梅',0,'1985-11-20'),(28,'封建',1,'1994-12-25'),(29,'周晶',1,'1997-01-22'),(30,'张萍',0,'1984-08-21'),(31,'张凤兰',0,'1987-11-05'),(32,'王雪梅',1,'1997-06-27'),(33,'赵琳',1,'1987-02-13'),(34,'黄云',0,'1989-08-18'),(35,'林丽华',1,'1993-09-11'),(36,'钟秀兰',1,'1989-05-11'),(37,'张平',1,'1996-02-18'),(38,'贾建',1,'1988-05-24'),(39,'何荣',0,'1991-08-04'),(40,'吴建国',1,'1995-06-02');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacher_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'张老师'),(2,'王老师'),(3,'李老师'),(4,'刘老师'),(5,'赵老师'),(6,'向老师'),(7,'牛老师'),(8,'周老师'),(9,'谭老师'),(10,'廖老师');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-04  0:31:15
