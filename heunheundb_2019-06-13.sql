# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.3.13-MariaDB)
# Database: heunheundb
# Generation Time: 2019-06-13 05:15:48 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table amn
# ------------------------------------------------------------

DROP TABLE IF EXISTS `amn`;

CREATE TABLE `amn` (
  `amn_id` int(11) NOT NULL AUTO_INCREMENT,
  `amn` varchar(100) NOT NULL,
  PRIMARY KEY (`amn_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

LOCK TABLES `amn` WRITE;
/*!40000 ALTER TABLE `amn` DISABLE KEYS */;

INSERT INTO `amn` (`amn_id`, `amn`)
VALUES
	(1,'필수품목(수건,침대시트,비누,화장지,배게)'),
	(2,'무선인터넷'),
	(3,'샴푸'),
	(4,'옷장/서랍장'),
	(5,'TV'),
	(6,'난방'),
	(7,'에어컨'),
	(8,'조식,커피,차'),
	(9,'업무가능공간/책상'),
	(10,'벽난로'),
	(11,'다리미'),
	(12,'헤어드라이어'),
	(13,'게스트 전용 출입문');

/*!40000 ALTER TABLE `amn` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table auth
# ------------------------------------------------------------

DROP TABLE IF EXISTS `auth`;

CREATE TABLE `auth` (
  `auth_id` int(11) NOT NULL AUTO_INCREMENT,
  `auth` varchar(5) NOT NULL,
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `auth` WRITE;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;

INSERT INTO `auth` (`auth_id`, `auth`)
VALUES
	(1,'일반회원'),
	(2,'호스트'),
	(3,'관리자');

/*!40000 ALTER TABLE `auth` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table blike
# ------------------------------------------------------------

DROP TABLE IF EXISTS `blike`;

CREATE TABLE `blike` (
  `blike_no` int(11) NOT NULL AUTO_INCREMENT,
  `blike_check` int(11) NOT NULL DEFAULT 0,
  `board_id` int(11) NOT NULL,
  `usr_id` int(11) NOT NULL,
  PRIMARY KEY (`blike_no`),
  KEY `FK_board_TO_blike` (`board_id`),
  KEY `FK_usr_TO_blike` (`usr_id`),
  CONSTRAINT `FK_board_TO_blike` FOREIGN KEY (`board_id`) REFERENCES `board` (`board_id`),
  CONSTRAINT `FK_usr_TO_blike` FOREIGN KEY (`usr_id`) REFERENCES `usr` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

LOCK TABLES `blike` WRITE;
/*!40000 ALTER TABLE `blike` DISABLE KEYS */;

INSERT INTO `blike` (`blike_no`, `blike_check`, `board_id`, `usr_id`)
VALUES
	(2,0,37,1),
	(3,0,38,1),
	(4,0,39,1),
	(5,0,40,1),
	(6,0,46,1),
	(7,0,45,11),
	(8,0,46,11),
	(9,0,44,1),
	(10,0,43,1),
	(11,0,47,1),
	(12,0,54,1),
	(13,0,45,1),
	(14,0,54,11),
	(15,0,42,11),
	(16,0,41,11),
	(17,0,39,11),
	(18,0,47,11),
	(19,0,38,11);

/*!40000 ALTER TABLE `blike` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table board
# ------------------------------------------------------------

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `board_id` int(11) NOT NULL AUTO_INCREMENT,
  `usr_id` int(11) NOT NULL,
  `rms_id` int(11) DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `conts` mediumtext NOT NULL,
  `cdt` datetime NOT NULL DEFAULT current_timestamp(),
  `main_photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`board_id`),
  KEY `FK_usr_TO_board` (`usr_id`),
  KEY `FK_rms_TO_board` (`rms_id`),
  CONSTRAINT `FK_rms_TO_board` FOREIGN KEY (`rms_id`) REFERENCES `rms` (`rms_id`),
  CONSTRAINT `FK_usr_TO_board` FOREIGN KEY (`usr_id`) REFERENCES `usr` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;

INSERT INTO `board` (`board_id`, `usr_id`, `rms_id`, `title`, `conts`, `cdt`, `main_photo`)
VALUES
	(37,1,13,'블로그테스트입니다.','<p>아아 테스테스트<img src=\"/heunheuntrip/upload/blogphoto/4c6ca60e-23d8-4586-83aa-55c5711162b8\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/30261d9e-99c4-4b7d-9e61-c010c95d3dcf\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/11df0571-fbe3-422d-b85d-f72fbf72437b\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/74a626e6-cb63-4204-b3b6-a184bf8a96ee\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/37f11039-c77f-4c03-851c-3a6d3fc6a55c\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/8e9290ed-2db6-4b92-bf2f-47d64cda3d22\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/c88b4da9-87f9-49dd-8c5d-540cb070bf11\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/77f44d55-f91e-475c-a4e3-cd0a1b3c7a6d\" style=\"width: 898px;\"></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p>테스트라고</p><p><br></p>','2019-05-29 14:35:03','fb00a8b2-afba-4e8c-90df-1c6b79ac938d'),
	(38,1,13,'gggg','<p>gggg<img style=\"width: 898px;\" src=\"/heunheuntrip/upload/blogphoto/114b92f5-4a06-405b-995a-7ac06ba08161\"><img style=\"width: 898px;\" src=\"/heunheuntrip/upload/blogphoto/340f3325-717d-4309-b668-a9772fa30e6f\"><img style=\"width: 898px;\" src=\"/heunheuntrip/upload/blogphoto/55be7334-a57c-42b6-9a51-a8fcf3e5071a\"></p>','2019-05-29 14:48:14','737e7983-1464-4bc5-abe6-887f6268c2b7'),
	(39,1,13,'asdfasdf','<p><img style=\"width: 898px;\" src=\"/heunheuntrip/upload/blogphoto/f117db8a-94fd-46a8-8f0d-2b388340d56b\"><br></p>','2019-05-29 14:56:28','424002b4-7024-4cf5-85f1-1014bd436a9b'),
	(40,1,13,'asdfasdf','<p><img style=\"width: 898px;\" src=\"/heunheuntrip/upload/blogphoto/0dd78be1-fd87-474f-b778-597d96c3ff57\"><br></p>','2019-05-29 14:58:46','df750706-f86b-4e40-a106-156e5925db26'),
	(41,1,13,'재밌었어요','<ul><li>ㅎㅎㅎ</li></ul>','2019-05-30 11:00:54','4be8af64-e647-4864-b2d8-642e76979cc3'),
	(42,1,13,'하하하','<p>ㅎㅎㅎ</p>','2019-05-30 11:01:15','e5ec4ae3-a4a9-4fdf-8250-1513f376b6e0'),
	(43,1,13,'님?','<p>ㅎㅎ</p>','2019-05-30 11:01:40','e76c17bd-4a7c-49ab-bd76-3129fb0c93df'),
	(44,1,13,'ㅎㅎ노가다네?','<p>ㅎㅎ</p>','2019-05-30 11:01:57','36dcdb35-fc18-44ac-b34e-ea576c788ec3'),
	(45,1,13,'테스트테스트','<p>ㅎㅎ</p>','2019-05-30 11:02:21','c61ca7ca-b953-4587-bf92-d780b9c15465'),
	(46,1,13,'111','<p>1111</p>','2019-05-30 12:21:05','9477b59c-cbff-47b0-9002-d179019b321f'),
	(47,1,13,'hh','<p>hh<img src=\"/heunheuntrip/upload/blogphoto/abc59605-f027-4e39-90a3-33a0c4a2a2d6\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/6fbbfc8a-f1d8-433d-b909-8ea0b5efac82\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/7e0d91af-45f3-4002-9840-ccde5ac485eb\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/2600c20d-b1fc-422e-9384-6a56ab3a4bd4\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/319aff21-3700-42f4-9a65-d386cf72c735\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/556cf1f7-aa67-4d3c-b699-40a7aeb610d4\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/4d3a71ee-039a-48e3-9a4f-f768c5ccaf31\" style=\"width: 898px;\"><img src=\"/heunheuntrip/upload/blogphoto/8de26551-1f93-437b-9c4e-a76fb7a896ff\" style=\"width: 898px;\"></p>','2019-05-30 15:53:22','53af4172-118b-4049-a096-a68bf5c173f7'),
	(54,1,13,'aaa','<p>asd</p>','2019-05-30 18:04:32','2abc58a9-28d9-41cb-a0f7-791b87df0c66_tumbnail');

/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table bookmark
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bookmark`;

CREATE TABLE `bookmark` (
  `usr_id` int(11) NOT NULL,
  `rms_id` int(11) NOT NULL,
  `memo` text DEFAULT NULL,
  `cdt` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`usr_id`,`rms_id`),
  KEY `FK_rms_TO_bookmark` (`rms_id`),
  CONSTRAINT `FK_rms_TO_bookmark` FOREIGN KEY (`rms_id`) REFERENCES `rms` (`rms_id`),
  CONSTRAINT `FK_usr_TO_bookmark` FOREIGN KEY (`usr_id`) REFERENCES `usr` (`usr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `bookmark` WRITE;
/*!40000 ALTER TABLE `bookmark` DISABLE KEYS */;

INSERT INTO `bookmark` (`usr_id`, `rms_id`, `memo`, `cdt`)
VALUES
	(11,13,'ㅋㅋㅋㅋㅋ','2019-06-10 10:41:23'),
	(11,15,'ㅎㅎㅎ','2019-06-10 10:41:27');

/*!40000 ALTER TABLE `bookmark` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table faq
# ------------------------------------------------------------

DROP TABLE IF EXISTS `faq`;

CREATE TABLE `faq` (
  `faq_id` int(11) NOT NULL AUTO_INCREMENT,
  `faq` text NOT NULL,
  `faq_an` text NOT NULL,
  PRIMARY KEY (`faq_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

LOCK TABLES `faq` WRITE;
/*!40000 ALTER TABLE `faq` DISABLE KEYS */;

INSERT INTO `faq` (`faq_id`, `faq`, `faq_an`)
VALUES
	(1,'환불은 어떻게 하나요?','3일내 하셔야해요'),
	(2,'예약취소 어떻게 하나요?','결제취소 누르면되요'),
	(3,'할인혜택도 있나요?','없습니다.'),
	(4,'무통장 입금도 가능한가요?','가능합니다'),
	(5,'흔흔사이트 계정은 어떻게 만드나요?','heunheun.com 가셔서 회원가입하시면됩니다.'),
	(6,'친구나 가족을 대신하여 예약할수 있나요?','예 가능합니다'),
	(7,'예약하기 전에 숙소를 직접 볼수 있나요?','가능합니다,다만 숙소를 방문하지 않고도 숙소 및 호스트에 대해 알아 볼수있습니다.'),
	(8,'예약완료시 숙방정보는 문자로 보내주시나요?','결제하는 즉시 보내드립니다.'),
	(9,'회원은 예약 상태를 어떻게 확인 하나요?','호스트가 예약 요청을 수락하면 이메일로 알림을 받게 되며, 계정의 알림 설정에 따라 에어비앤비로부터 문자(SMS)나 푸시 알림을 받게 됩니다'),
	(10,'예약 요청은 어떻게 보내나요?','숙소 페이지에서 예약 요청을 클릭하세요.');

/*!40000 ALTER TABLE `faq` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table gallery
# ------------------------------------------------------------

DROP TABLE IF EXISTS `gallery`;

CREATE TABLE `gallery` (
  `id` int(11) NOT NULL,
  `title` varchar(225) NOT NULL,
  `file` text NOT NULL,
  `type` varchar(40) NOT NULL,
  `size` int(11) NOT NULL,
  `index` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `is_main` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table host
# ------------------------------------------------------------

DROP TABLE IF EXISTS `host`;

CREATE TABLE `host` (
  `usr_id` int(11) NOT NULL AUTO_INCREMENT,
  `bank` varchar(10) NOT NULL,
  `bank_id` varchar(30) NOT NULL,
  PRIMARY KEY (`usr_id`),
  CONSTRAINT `FK_usr_TO_host` FOREIGN KEY (`usr_id`) REFERENCES `usr` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

LOCK TABLES `host` WRITE;
/*!40000 ALTER TABLE `host` DISABLE KEYS */;

INSERT INTO `host` (`usr_id`, `bank`, `bank_id`)
VALUES
	(5,'신한','110-3334-6587'),
	(6,'농협','110-33784-6447'),
	(7,'신한','110-2224-7789'),
	(8,'하나','7894-3334-6587'),
	(10,'기업','7894-78945-61245');

/*!40000 ALTER TABLE `host` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table hst_qna
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hst_qna`;

CREATE TABLE `hst_qna` (
  `hst_qna_id` int(11) NOT NULL AUTO_INCREMENT,
  `usr_id` int(11) NOT NULL,
  `rms_id` int(11) NOT NULL,
  `conts` text NOT NULL,
  `cdt` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`hst_qna_id`),
  KEY `FK_usr_TO_hst_qna` (`usr_id`),
  KEY `FK_rms_TO_hst_qna` (`rms_id`),
  CONSTRAINT `FK_rms_TO_hst_qna` FOREIGN KEY (`rms_id`) REFERENCES `rms` (`rms_id`),
  CONSTRAINT `FK_usr_TO_hst_qna` FOREIGN KEY (`usr_id`) REFERENCES `usr` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;



# Dump of table photoboard
# ------------------------------------------------------------

DROP TABLE IF EXISTS `photoboard`;

CREATE TABLE `photoboard` (
  `pboard_id` int(11) NOT NULL AUTO_INCREMENT,
  `board_id` int(11) NOT NULL,
  `photo` varchar(255) NOT NULL,
  PRIMARY KEY (`pboard_id`),
  KEY `FK_board_TO_photoboard` (`board_id`),
  CONSTRAINT `FK_board_TO_photoboard` FOREIGN KEY (`board_id`) REFERENCES `board` (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

LOCK TABLES `photoboard` WRITE;
/*!40000 ALTER TABLE `photoboard` DISABLE KEYS */;

INSERT INTO `photoboard` (`pboard_id`, `board_id`, `photo`)
VALUES
	(1,37,'a'),
	(3,37,'b'),
	(4,47,'abc59605-f027-4e39-90a3-33a0c4a2a2d6'),
	(5,47,'7e0d91af-45f3-4002-9840-ccde5ac485eb'),
	(6,47,'2600c20d-b1fc-422e-9384-6a56ab3a4bd4'),
	(7,47,'556cf1f7-aa67-4d3c-b699-40a7aeb610d4'),
	(8,47,'4d3a71ee-039a-48e3-9a4f-f768c5ccaf31'),
	(9,47,'8de26551-1f93-437b-9c4e-a76fb7a896ff'),
	(10,47,'6fbbfc8a-f1d8-433d-b909-8ea0b5efac82'),
	(11,47,'319aff21-3700-42f4-9a65-d386cf72c735');

/*!40000 ALTER TABLE `photoboard` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table qna
# ------------------------------------------------------------

DROP TABLE IF EXISTS `qna`;

CREATE TABLE `qna` (
  `qna_id` int(11) NOT NULL AUTO_INCREMENT,
  `usr_id` int(11) NOT NULL,
  `qna_cate_id` int(11) NOT NULL,
  `parent` int(11) NOT NULL,
  `ordr` int(11) NOT NULL,
  `step` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` mediumtext NOT NULL,
  `qna_pwd` varchar(255) DEFAULT NULL,
  `cdt` datetime NOT NULL DEFAULT current_timestamp(),
  `vw_cnt` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`qna_id`),
  KEY `FK_usr_TO_qna` (`usr_id`),
  KEY `FK_qna_cate_TO_qna` (`qna_cate_id`),
  CONSTRAINT `FK_qna_cate_TO_qna` FOREIGN KEY (`qna_cate_id`) REFERENCES `qna_cate` (`qna_cate_id`),
  CONSTRAINT `FK_usr_TO_qna` FOREIGN KEY (`usr_id`) REFERENCES `usr` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

LOCK TABLES `qna` WRITE;
/*!40000 ALTER TABLE `qna` DISABLE KEYS */;

INSERT INTO `qna` (`qna_id`, `usr_id`, `qna_cate_id`, `parent`, `ordr`, `step`, `title`, `content`, `qna_pwd`, `cdt`, `vw_cnt`)
VALUES
	(1,1,1,1,1,1,'예약이1..','예약이안되요','1111','2019-05-28 09:55:32',1),
	(2,2,4,2,1,1,'예약이2..','이용방법이','1111','2019-05-28 09:55:32',1),
	(3,3,1,3,1,1,'예약이3..','날자를 변경해주세요','1111','2019-05-28 09:55:32',1),
	(4,4,1,4,1,1,'예약이4..','이용인원 변경이요','1111','2019-05-28 09:55:32',1),
	(5,5,1,5,1,1,'예약이5..','예약정보가 안뜨네요','1111','2019-05-28 09:55:32',1),
	(6,6,4,1,2,2,'예약이6..','이용규칙이 왜안뜨죠 ??','1111','2019-05-28 09:55:32',1),
	(7,7,2,4,2,2,'예약이7..','가격 정보가 결제금액이오....랑 다른경우는 어덯게 하죠..','1111','2019-05-28 09:55:32',1),
	(8,8,1,5,2,2,'예약이8..','취소해주세요','1111','2019-05-28 09:55:32',1),
	(9,9,1,3,2,2,'예약이9..','예약 대기가 안되네요 ....','1111','2019-05-28 09:55:32',1),
	(10,10,1,1,3,3,'예약이10..','예약이안되요','1111','2019-05-28 09:55:32',1),
	(11,2,1,1,4,3,'예약이11..','예약이안되요','1111','2019-05-28 09:55:32',1),
	(12,3,1,2,2,2,'예약이12..','예약이안되요','1111','2019-05-28 09:55:32',1),
	(13,5,1,5,3,2,'예약이13..','예약이안되요','1111','2019-05-28 09:55:32',1),
	(14,3,1,1,5,4,'예약이14..','예약이안되요','1111','2019-05-28 09:55:32',1);

/*!40000 ALTER TABLE `qna` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table qna_cate
# ------------------------------------------------------------

DROP TABLE IF EXISTS `qna_cate`;

CREATE TABLE `qna_cate` (
  `qna_cate_id` int(11) NOT NULL,
  `cate` varchar(20) NOT NULL,
  PRIMARY KEY (`qna_cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `qna_cate` WRITE;
/*!40000 ALTER TABLE `qna_cate` DISABLE KEYS */;

INSERT INTO `qna_cate` (`qna_cate_id`, `cate`)
VALUES
	(1,'예약'),
	(2,'결제, 환불'),
	(3,'계정'),
	(4,'기타');

/*!40000 ALTER TABLE `qna_cate` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rev
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rev`;

CREATE TABLE `rev` (
  `rev_id` int(11) NOT NULL AUTO_INCREMENT,
  `usr_id` int(11) NOT NULL,
  `stus_id` int(11) NOT NULL,
  `rms_id` int(11) NOT NULL,
  `cck_in` date NOT NULL,
  `cck_out` date NOT NULL,
  `stby_stus` char(2) NOT NULL,
  `rev_persn` int(11) NOT NULL,
  `rev_cdt` datetime NOT NULL DEFAULT current_timestamp(),
  `rev_char` int(11) NOT NULL,
  `rev_updt` int(11) DEFAULT NULL,
  `rev_reas` text DEFAULT NULL,
  PRIMARY KEY (`rev_id`),
  KEY `FK_usr_TO_rev` (`usr_id`),
  KEY `FK_stus_TO_rev` (`stus_id`),
  KEY `FK_rms_TO_rev` (`rms_id`),
  CONSTRAINT `FK_rms_TO_rev` FOREIGN KEY (`rms_id`) REFERENCES `rms` (`rms_id`),
  CONSTRAINT `FK_stus_TO_rev` FOREIGN KEY (`stus_id`) REFERENCES `stus` (`stus_id`),
  CONSTRAINT `FK_usr_TO_rev` FOREIGN KEY (`usr_id`) REFERENCES `usr` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

LOCK TABLES `rev` WRITE;
/*!40000 ALTER TABLE `rev` DISABLE KEYS */;

INSERT INTO `rev` (`rev_id`, `usr_id`, `stus_id`, `rms_id`, `cck_in`, `cck_out`, `stby_stus`, `rev_persn`, `rev_cdt`, `rev_char`, `rev_updt`, `rev_reas`)
VALUES
	(13,11,3,13,'2019-05-08','2020-05-10','승인',2,'2019-05-29 10:03:02',100000,NULL,NULL),
	(14,11,3,13,'2019-07-01','2019-07-02','대기',2,'2019-06-10 00:00:00',10000,NULL,NULL),
	(15,11,3,13,'2019-07-03','2019-07-04','대기',2,'2019-06-11 00:00:00',100000,14,'ㅣ이유\n');

/*!40000 ALTER TABLE `rev` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table riw
# ------------------------------------------------------------

DROP TABLE IF EXISTS `riw`;

CREATE TABLE `riw` (
  `riw_id` int(11) NOT NULL AUTO_INCREMENT,
  `usr_id` int(11) NOT NULL,
  `riw_conts` text NOT NULL,
  `grd` varchar(10) NOT NULL,
  `cdt` datetime NOT NULL DEFAULT current_timestamp(),
  `riw_reply` text DEFAULT NULL,
  `reply_dt` date DEFAULT NULL,
  `rms_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`riw_id`),
  KEY `FK_usr_TO_riw` (`usr_id`),
  KEY `FK_rms_TO_riw` (`rms_id`),
  CONSTRAINT `FK_rms_TO_riw` FOREIGN KEY (`rms_id`) REFERENCES `rms` (`rms_id`),
  CONSTRAINT `FK_usr_TO_riw` FOREIGN KEY (`usr_id`) REFERENCES `usr` (`usr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rm_photo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rm_photo`;

CREATE TABLE `rm_photo` (
  `r_photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `rms_id` int(11) NOT NULL,
  `rm_photo` varchar(255) NOT NULL,
  PRIMARY KEY (`r_photo_id`),
  KEY `FK_rms_TO_rm_photo` (`rms_id`),
  CONSTRAINT `FK_rms_TO_rm_photo` FOREIGN KEY (`rms_id`) REFERENCES `rms` (`rms_id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;

LOCK TABLES `rm_photo` WRITE;
/*!40000 ALTER TABLE `rm_photo` DISABLE KEYS */;

INSERT INTO `rm_photo` (`r_photo_id`, `rms_id`, `rm_photo`)
VALUES
	(5,13,'9ddac322-fa6a-4b78-928b-de8e14679b8b'),
	(6,13,'b9532755-0c54-4fea-b0d5-b6045acefe33'),
	(7,13,'6db02fda-5217-4bbb-b5f8-6b45fdaf9e12'),
	(8,13,'7547a157-b3b0-4bf1-a10a-d5cde79c94b2'),
	(9,13,'ce97c5f8-d298-460e-84b8-eefec9f647bb'),
	(10,13,'06836bef-446e-4f98-984d-91cba120f40f'),
	(11,14,'ad3a526f-3ca2-48b5-9673-3769ee8e3454'),
	(12,14,'aad0297f-703d-4977-85f0-775ee575fae6'),
	(13,14,'f3fb7546-8827-4ed2-9b87-a54d518054c2'),
	(14,14,'04da116e-e78e-46bf-ab24-f26cc702deb1'),
	(15,14,'31d55cc0-b7c6-49ef-993c-679da5a27a8f'),
	(16,14,'574a3544-b282-4d7d-99de-0c53e9f5b284'),
	(17,14,'13366749-e03f-43fd-862e-413d81e958af'),
	(18,15,'4d937e69-5504-4841-8115-641c01666fc4'),
	(19,15,'365e4e8d-c48a-499a-9be4-410f481be3fc'),
	(20,15,'ca3f5574-2e87-4d01-b017-7672825c2eae'),
	(21,15,'034557f6-1202-4f98-925b-38d6dfa8dc02'),
	(22,15,'6ee35305-e361-4338-91d7-25ee6a699664'),
	(23,15,'e4920dcb-84b4-42d7-81c5-ffac59a10c3d'),
	(24,15,'2d46bc07-6fbd-41ff-b05d-6abc8b46e434'),
	(25,16,'daaef923-b495-49d4-9a06-d8390b2f37be'),
	(26,16,'818efb6d-b1e6-4043-b8bb-1cfc33ac57f2'),
	(27,16,'19c69e4f-753e-4a5d-91a4-954e2c74ba84'),
	(28,16,'95846bce-f6f3-4bf2-9a86-387071bf91cb'),
	(29,16,'54753b41-c3fe-4425-8ec0-a7587a2c9e3c'),
	(30,16,'0ae96925-b3b7-4597-b7ac-a18818f33023'),
	(31,16,'49f213cf-7bd9-4bfa-9ef0-4c2f2555d890'),
	(32,17,'179a970b-acda-48b1-9c1c-c043f58e53a8'),
	(33,17,'458a191c-594c-424f-a37a-fd76c9e070bf'),
	(34,17,'d53c4cb9-2c16-45b0-8cab-84a9fc3eb506'),
	(35,17,'306b83d9-f7ac-4b69-86d1-ea47c49bb4da'),
	(36,17,'9cd97321-c76a-4c25-bdf7-6d37aec5893f'),
	(37,17,'bd4d41f6-5d6b-48bd-808f-3f0722fb756f'),
	(38,17,'cb18c77a-13f1-471b-ae75-f589c799366b'),
	(39,19,'4798c4e7-b749-4d82-89e6-dd468eeb63ce'),
	(40,19,'86eb9e49-646a-4593-bcf3-7c38de9994b5'),
	(41,19,'ddec785b-8013-4798-8324-55af3ab2d505'),
	(42,19,'8db35922-b9aa-47e5-ab47-1a1e12ff9f6d'),
	(43,19,'c540647a-d001-463b-b56f-f0218c2caa9c'),
	(44,19,'561067f5-7cab-420a-be7f-c41abf279034'),
	(45,19,'e72004b4-b424-428c-9789-311d552acf2d'),
	(46,19,'127fcd75-7e0a-41a2-afec-c26560cfb74e'),
	(47,21,'a31e2543-05c2-4b76-9014-264d4739981f'),
	(48,21,'d7d581a7-b184-42f8-8b8a-26b04ca51505'),
	(49,21,'6dcb4714-233a-4b5a-8486-5f5595b8fe67'),
	(50,21,'608a315c-9d23-480b-9339-d9a75e6db3e6'),
	(51,21,'c10339d5-5ea5-483c-b722-6466ac45743d'),
	(52,21,'fa3b9a43-f549-46b1-a9d0-08f660004fc6'),
	(53,21,'a38e7857-82d6-44d9-9da5-921a2cdc8948'),
	(54,22,'1e225030-e6f6-4a8e-8ea7-2e2e36ac1a18'),
	(55,22,'34016709-8be5-40fd-941a-01edb1c1b0de'),
	(56,22,'e375814d-0dea-4d94-9555-86a7c8676fd7'),
	(57,22,'96366835-eb23-4856-9f11-c100b98408cb'),
	(58,22,'de460282-5ff2-4ef1-8d2a-5650fa8677ee'),
	(59,22,'9411bb97-dda4-4cde-be8f-b0acdb973077'),
	(60,22,'838b55bc-bc46-4aee-a0e2-3d3a62418bf9'),
	(81,111,'beec8f29-aef8-414b-a6d3-a5a6c5187d4d'),
	(82,111,'f12452c9-c035-4b38-a341-76489f5f2c4d'),
	(83,111,'3dcb75b7-6960-4007-bcae-de7a2d93ab49'),
	(84,111,'7c958ee9-6d30-439d-8edb-57371c3b9864'),
	(85,112,'2ffca185-24b7-446d-965f-20904c909aa4'),
	(86,112,'fcdc8c17-24de-4a79-b8ac-b48728c473ad'),
	(87,112,'58ca9454-f8e6-4466-a995-ae826e6b8747'),
	(88,112,'7a517a6c-5eb5-4eef-ae37-d06d55f32e62'),
	(89,113,'df4414a5-1b47-4c84-b7e2-97fba186cf99'),
	(90,113,'68aa5cd3-f32b-4ce9-9d86-ee8d3511a901'),
	(91,113,'2a9ae8cb-af4a-4444-8e9a-65bec5689963'),
	(92,113,'29d5dcba-e631-46ea-ad59-07207183cb13'),
	(93,114,'c7251fdb-8a5d-40b3-adc1-576d7fde1120'),
	(94,114,'2e2b888d-a80c-4d08-b558-b8086411da04'),
	(95,114,'6b77e78b-d91d-4393-ab99-fad3920c0ed1'),
	(96,114,'b0e19766-f36f-4a5f-b552-7a5ec110d8c8'),
	(97,115,'51594f31-51b7-40cc-b39f-623252dbe4ff'),
	(98,115,'8050ba33-88c7-4373-b87d-eee29da4bbee'),
	(99,115,'46725599-5e7a-48a6-8f4b-7bb626e277e8'),
	(100,115,'71765897-f4e2-4159-991f-9d66f0c766cd'),
	(101,116,'f6a0a690-bf65-443c-b4b0-2aaf2a0048be'),
	(102,116,'861bfeb9-a0bc-4f6a-b78a-ccc4a289e052'),
	(103,116,'5c5cfcbf-92b9-4625-8679-1c88add3608d'),
	(104,116,'0a3950e8-e993-4117-97db-3fd968450a85'),
	(105,117,'87253a2d-a946-48c5-a93e-203ba24ff238'),
	(106,117,'0d8c8a06-b0ea-4af1-9280-9c27cb004a6e'),
	(107,117,'9ce9340c-2912-417f-9772-d177d65af3ba'),
	(108,117,'ece96212-7f27-4e9e-915e-949980694c43'),
	(109,118,'d04a28e9-18a6-4c20-9f09-a75df8e994d2'),
	(110,118,'1e18bfbe-d6d7-44a9-9c01-32266b8060cb'),
	(111,118,'296dbf9f-bd5f-471d-84a8-1cd1cd8e6ae8'),
	(112,118,'2ec18747-292a-495e-89de-7b9427012af8'),
	(113,119,'8690a2d6-1390-423b-bfb5-9041632def7b'),
	(114,119,'0cfcaf8d-450b-4e07-9ce5-8d14b860e9f1'),
	(115,119,'54e20a70-edd4-45e8-a571-94a8647e07dd'),
	(116,119,'73e752cb-540a-40a0-80a5-0b76e379ccc8'),
	(117,120,'713d9257-f68f-4d08-a079-26304e099a8f'),
	(118,120,'82a802e4-058a-42eb-a904-709aeeaa50de'),
	(119,120,'eda6a933-4393-4279-94c4-26fbd6903e3a'),
	(120,120,'eb5dab28-98f5-4ba4-ac8c-0bc38780229e'),
	(130,125,'dd543657-4922-48bf-ac17-f529f9a85021'),
	(131,125,'ef2951d5-a6f5-486e-92b8-b5d8670eb464'),
	(132,125,'23e92816-2767-4e2e-bbd0-2376d1d084b0'),
	(133,126,'123ae223-fd41-4b19-8d7f-72da6cfa8578'),
	(134,126,'ea1aaf23-760a-4477-9865-9dadeac19a20'),
	(135,126,'63b49093-9f4a-430f-9b16-d5661912c925'),
	(136,126,'42718d7d-27d5-4a32-b5bc-4ea5bf72376b'),
	(137,128,'8910d917-b0d4-4a6a-bec3-2f01e390f6b9'),
	(138,128,'7b223a08-db1a-47e7-b2b3-710a9cde84af'),
	(139,128,'6e16b160-1106-4b8d-a7c6-58a5e24542cb'),
	(140,128,'edeb2407-b19b-49ab-9de2-80a6aaf83a94'),
	(141,128,'53e37da4-84fc-44df-bdcb-dca84cfd2804'),
	(142,128,'fdf5c2bf-ee50-4312-b096-fdcbc3d91782');

/*!40000 ALTER TABLE `rm_photo` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rms
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rms`;

CREATE TABLE `rms` (
  `rms_id` int(11) NOT NULL AUTO_INCREMENT,
  `usr_id` int(11) NOT NULL,
  `area` varchar(255) NOT NULL,
  `type` varchar(100) NOT NULL,
  `bed` int(11) NOT NULL,
  `bath` int(11) NOT NULL,
  `cont` text NOT NULL,
  `dets` text DEFAULT NULL,
  `reva` text DEFAULT NULL,
  `come` text DEFAULT NULL,
  `traf` text DEFAULT NULL,
  `rm_name` varchar(100) NOT NULL,
  `rm_chge` int(11) NOT NULL,
  `max_ple` int(11) NOT NULL,
  `post_code` varchar(5) NOT NULL,
  `addr` varchar(255) NOT NULL,
  `dtil_addr` varchar(255) NOT NULL,
  `lati` varchar(50) NOT NULL,
  `longi` varchar(50) NOT NULL,
  `cdt` datetime NOT NULL DEFAULT current_timestamp(),
  `grd` varchar(5) DEFAULT NULL,
  `thum` varchar(255) DEFAULT NULL,
  `activation` int(11) DEFAULT 0,
  PRIMARY KEY (`rms_id`),
  KEY `FK_host_TO_rms` (`usr_id`),
  CONSTRAINT `FK_host_TO_rms` FOREIGN KEY (`usr_id`) REFERENCES `host` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

LOCK TABLES `rms` WRITE;
/*!40000 ALTER TABLE `rms` DISABLE KEYS */;

INSERT INTO `rms` (`rms_id`, `usr_id`, `area`, `type`, `bed`, `bath`, `cont`, `dets`, `reva`, `come`, `traf`, `rm_name`, `rm_chge`, `max_ple`, `post_code`, `addr`, `dtil_addr`, `lati`, `longi`, `cdt`, `grd`, `thum`, `activation`)
VALUES
	(13,6,'강남역','집전체',2,1,'강남역 최고의 위치!! 강남역 12번출구 앞 위치한 복층스튜디오.\n숙소 바로 앞 인천공항,김포공항 버스정류장 위치함.\n1.LTE wifi 무료\n2.24시간 경비 대기중.\n3.간편한 도어락시스템으로 호스트와 만남없이 자유로운 입퇴실.\n4.일회용 치약,칫솔 제공.','강남역 일대가 보이는 위치 및 전망.\n강남역 인근 복층 스튜디오입니다.\n\n**건물 내 주차 불가능하니 참고부탁드려요:-)','메신저를 통해 신속한 소통/문자,통화 다 가능.','','강남역 12번출구 1분거리','복층스튜디오 강남역',80000,6,'06252','서울 강남구 강남대로 328','강남역12번출구','37.49242638484167','127.0309201030125','2019-05-28 17:12:37',NULL,'f2f45a9a-ad70-46e7-95ee-7b53a9b2f746',0),
	(14,6,'강남역','다인실',1,1,'[강남역 1번출구 도보 1분거리]\n- 출/ 퇴근 용의\n- 짐 보관 가능 (창고무료 이용)\n- 강남역 1번 출구 입지 좋음,\n- 유흥가와 반대편 (조용함)\n- 2년 정도 된 신축 건물(깨끗함)\n- 모든게 다 갖춰져 있는 상가건물\n- 24시간 security system\n- 강남 놀거리 ,먹거리/ 강남스타일 등 최적의 입지 장소/ 공항버스와 바로 1분거리.( 건너지 않고 1분 내 숙소위치)\n- 신사/ 압구정/ 역삼역/ 삼성역/ 이태원/ 첨당동/ 강남 고속 터미널 가까운거리\n- New 가구! \n- 깨끗하고, High quality 제품제공.','[Bath room]\n- 비데 \n- 바디워시 / 샴푸/ 컨디셔너\n- 물비누\n- 드라이기\n- 타월(얼굴세안용 + body)\n- 옷세탁시(세제 증정)\n\n[Kitchen]\n- 전자레인지\n- 세탁기\n- Stove (인덕션)\n- 냄비 / 후라이펜\n- 컵 / 세제\n- 커피포트\n- 수저\n- 와인잔\n- 와인오프너\n- 냉장고\n\n[Bed room]\n- Queen size 침대 \n- 테이블\n- 의자\n- TV 34\"(SK broadband)\n- 디퓨져\n- 스팀다리미\n- 다리미\n- 에어컨\n- 히터\n\n[기타이용]\n- 주차 불가능\n- 지하로 이어지는 엘레베이터 지하1층 ( kind of restaurants)\n- 주변 : 스타벅스, 던킨도넛, 드라이클리닝(같은 건물), 편의점','언제든지 궁금한 점은 메신저를 통해서 연락 바랍니다.','오피스 · 네온 조명으로 환한 밤 거리 · 반짝반짝 새 빌딩들 · 음주 · 약속 장소? 당연히 강남이지! · 디지털 미디어 박스','강남역1분거리','편안한 New J house',68000,2,'06267','서울 강남구 강남대로 238','강남역1분거리','37.48496497372552','127.03475678137497','2019-05-28 17:29:33',NULL,'0dfb3d97-f08a-4b8a-9ccb-4c56f1ffa84e',0),
	(15,6,'강남역','집전체',2,1,'넓고 고급스러운\n네츄럴하고 모던스타일로 깔끔하게 꾸며진방\n\n깨끗하고 편안한 방\n\n넓고 고급스러운 네츄럴하고 모던스타일로 깔끔하게 꾸며진방 깨끗하고 편안한 방 \n강남역 도보 5분거리에 위치 다양한 편의시설이 갖춰져있습니다 인터넷 와이파이 가능  버스정류장 1분거리 (포스코 p&s타워 정거장) 24시간 연락가능 \n\n강남역 도보 5분거리에 위치\n\n다양한 편의시설이 갖춰져있습니다.\n\n인터넷 와이파이 가능\n\n버스정류장 1분거리\n(포스코 p&s타워 정거장)\n\n24시간 연락가능','','','','강남역 도보 5분거리에 위치','깨끗하고 넓고 이쁜집',55000,5,'06267','서울 강남구 강남대로 242','강남역1번출구','37.48537242576503','127.03408308745306','2019-05-28 17:35:58',NULL,'224c853d-d19a-4927-821c-51cda20e9bfd',0),
	(16,6,'잠실롯데','다인실',2,1,'잠실롯데에서 가장 가까운 위치의 모던하고 깨끗한 숙소입니다.\n\n*최상의 위치\n1.대중교통을 이용하기 편리한 위치\n- 잠실역 (2호선. 8호선) 도보 3 min\n- 공항리무진 버스 정류장 도보 3 mi (Website hidden by Airbnb) 잠실인천공항 (6705번 (Website hidden by Airbnb) 잠실김포공항 (6706번)\n2.연인& 가족여행으로 적합한 장소\n- 롯데월드 어드벤처 도보 1 min\n- 키자니아 도보 1 min\n- 석촌호수 도보 1 min\n- 롯데마트 도보 1 min\n- 아쿠아리움\n- 송리단길의 카페와 펍\n- 롯데몰에서의 다양한 먹거리와 대형 쇼핑몰\n- 에비뉴엘내의 롯데 면세점\n- 롯데시네마\n3. 숙소건물의 편의 시설\n-맛집 윤스테이블 \n-이화교복\n-유명 마카롱\n-스타벅스\n-편의점 2곳\n-그외의 다양한 먹거리','*사용가능한 공간/시설\n- 숙소는 총 6명이 사용할 수 있는 공간입니다.\n퀸베드 2개와 요와이불이 잘 준비되어 있구요. \n침구는 2인 기준으로 퀸베드 1세트가 제공됩니다. \n3인 이상일 경우 숙박요금이 추가되며 침구셋트가 제공됩니다 . 항상 청결하고 쾌적한 환경을 위해서 잘 관리하고 있답니다.','게스트와의 적극적인 교류를 원해요 . 전화, 문자, 이메일 모두 가능합니다. \n주의하시고 고려해야 할 사항과 세부정보는 메신저로 상세히 알려드립니다.','','롯데월드•잠실역 3min','따뜻한 아리하우스',42000,6,'05573','서울 송파구 잠실동 305-9','잠실역3분거리','37.50488577562563','127.0774578608472','2019-05-28 17:47:45',NULL,'0117ae63-6e29-419e-96bf-044a05d6e54a',0),
	(17,6,'잠실역','다인실',2,1,'안녕하세요. 토토로 하우스 입니다. :) \n매우 멋진 석촌호수와 시티뷰가 자랑이고, 잠실역과 석촌역에서 가깝습니다. 롯데월드몰에서 신나는 놀이공원과 아쿠아리움 여행과 편리한 쇼핑이 가능합니다. 혼자, 연인, 친구 및 출장차 이용하기에 좋습니다. :)','고층에서 즐기는 석촌호수와 롯데월드 뷰. 주간에는 탁 트인 전경과 야간에는 환상적인 야경이 자랑입니다. 숙소 바로 앞에 석촌호수가 있어서 산책을 하며 힐링을 하기에도 좋습니다. 롯데월드 놀이공원과 백화점이 있어 관광과 쇼핑에도 매우 좋습니다. 숙소근처에 편의점과 식당이 많이 있으며, 방이동먹자골목과 카페거리가 있어 즐기시기에 좋습니다.','언제든 메신저 해주세요.','숙소 앞에는 석촌호수가 있어서 산책을 하며 힐링을 하기에 좋습니다. 롯데월드몰에서 놀이공원, 아쿠아리움의 관광과 백화점에서 쇼핑을 하기에 매우 좋습니다. 근처에 편의점과 방이동 먹자골목 그리고 카페 거리도 있어서 즐길수 있습니다.','잠실역 10분','롯데월드 뷰 복층 하우스',61000,4,'05567','서울 송파구 백제고분로 지하 189','잠실역10분','37.50450037838299','127.08745065870269','2019-05-28 17:54:58',NULL,'ec62c6d6-548e-42db-bc3f-87dbc38f72ae',0),
	(19,6,'롯데월드몰 도보5분','다인실',3,1,'내추럴 & 감성 스튜디오\n\n감각적인 인테리어와 따뜻한 햇살이 들어오는 편안한 공간에서 행복한 추억을 만드세요!\n잠실역 10번출구, 롯데월드몰 도보 5분으로 잠실의 모든 시설을 편리하게 이용하실 수 있습니다','1. 편리한 위치 (도보 실측 기준)\n- 몽촌토성역(8호선),4분\n- 잠실역(2,5호선), 5분 \n- 롯데월드 몰, 5분\n- 석촌호수, 5분\n- 올림픽공원, 5분 \n- 롯데월드 아쿠아리움, 6분\n- 테디베어주, 6분\n- 서울 스카이(롯데월드타워 전망대), 7분\n- 롯데콘서트홀, 7분\n- 롯데 면세점, 9분\n- 롯데월드, 13분\n- 뽀로로파크, 14분\n- 키자니아, 14분\n- 토이저러스, 14분\n- 샤롯데씨어터, 15분\n- 잠실한강공원, 20분\n\n2. 내추럴 감성인테리어 & Amenity\n[전체]\n- 내추럴하고 따뜻한 인테리어로 편안한 공간을 구성하였습니다.\n\n[침실& 거실]\n- 편안하고 넓은 2개의 퀸사이즈 침대와 깨끗하게 세탁된 침구가 마련되어 있습니다.\n- 안락한 소파베드가 준비되어 있습니다. 펼치면 퀸사이즈의 베드로 변형됩니다.\n\n[주방]\n- Nespresso 커피 머신으로 하루를 시작하세요\n\n[욕실]\n- 깔끔한 욕실이 마련되어 있습니다.\n- 넉넉하게 제공되는 고급 순면 수건과 샤워용품, 일회용 칫솔 제공해 드립니다.\n\n3. 깔끔하고 쾌적한 공간\n- 깔끔하게 청소된 공간\n\n4.친절한 호스트\n- 게스트님의 예약문의부터 Checkout 후 재 방문까지 모든 여행 일정을 함께 하는 마음으로 고민하고 준비하겠습니다.',NULL,'[쇼핑몰]\n- 롯데월드 몰, 6분\n- 롯데마트, 6분\n- 롯데월드 에비뉴엘, 면세점 9분\n- 홈플러스, 7분\n- 하이마트, 15분\n\n[잠실 여행지]_ 도보 기준\n- 잠실역, 5분 \n- 롯데월드 몰, 5분\n- 석촌호수, 5분\n- 올림픽공원, 5분 \n- 롯데월드 아쿠아리움, 6분\n- 테디베어주, 6분\n- 서울 스카이(롯데월드타워 전망대), 7분\n- 롯데콘서트홀, 7분\n- 롯데 면세점, 9분\n- 롯데월드, 13분\n- 뽀로로파크, 14분\n- 키자니아, 14분\n- 토이저러스, 14분\n- 샤롯데씨어터, 15분\n- 잠실한강공원, 20분\n\n[근교 여행지]_잠실역 기준\n- 잠실 야구장, 12분(2호선)\n- 코엑스 삼성역, 15분(2호선)\n- 가락농수산물시장, 16분(버스) 20분(8호선)\n- 강남역, 18분(2호선)\n- 동대문 디자인플라자, 28분(2호선)\n- 어린이대공원, 32분(2호선, 7호선)\n- 가로수길 신사사거리 34분(버스)\n- 명동, 37분(2, 4호선)\n- 남산 케이블카, 47분(2, 4호선)\n- 경복궁, 50분(2, 3호선) \n- 홍대, 56분(2호선)\n- 서울랜드, 1시간 1분(2, 4호선)\n- 에버랜드, 1시간 7분(버스)','[지하철]\n- 잠실역(2,5호선) 10번 출구, 도보 5분\n- 몽촌토성역 (8호선) 3번 출구, 도보 4분\n\n[주차공간]\n: 건물내 주차 불가 인근 민영 주차장 사용가능 \n1) 성남민영주차장\n- 서울특별시 송파구 방이2동 59-3\n- 숙소와의 거리 120m\n- 일 주차 30,000원\n\n[김포공항 리무진]\n- 6000번 김포 공항리무진 잠실역 정류장, 12분(도보)\n- 6706번 인천 공항리무진 잠실롯데월드 정류장, 15분(도보)\n\n[인천공항 리무진]\n- 6006번 인천 공항리무진 잠실역 정거장, 12분(도보)\n- 6705번 인천 공항리무진 잠실롯데월드 정거장, 15분(도보)','감성하우스 Cozy house',39000,6,'05691','서울 송파구 가락로5길 7-19','롯데월드몰','37.499833180325275','127.10099331713904','2019-05-29 10:24:23',NULL,'4798c4e7-b749-4d82-89e6-dd468eeb63ce',0),
	(21,6,'잠실역/석촌호수/송리단길/롯데월드','다인실',1,1,'잠실의 핫플레이스인 석촌호수와 송리단길, 그리고 아름다운 롯데월드와 롯데월드타워를 보며 서울에서 아름다운 추억을 보낼 수 있는 공간을 준비했어요 특히 롯데월드는 도보로 5분-10분 정도로 정말 가깝습니닷!\n\n제가 대학생 때 직접 거주하였던 곳을 새롭게 리모델링하였구요. 사진에서 보시다시피 모든 가구나 바닥 등 다 새롭게 구매하고 리모델링해 깨끗하고 깔끔합니다.\n\n숙소는 8층에 위치해 있어 햇빛도 잘 들어와 채광도 좋고 낮에는 화사한 분위기가 나서 더욱 좋아요.\n지하철 2호선 잠실역에서 900여m 떨어져 있으며 도보로는 10여분 정도로 전철역과의 접근성이 매우 뛰어납니다. 그리고 지하철 9호선 석촌고분역에서는 400여m 떨어져 있으며 도보로 5분 정도 걸립니다\n\n그리고 공항 버스 터미널, 송리단길, 롯데월드와 롯데타워, 맛집 등 모든 편의시설과 관광지도 도보로 5분~10분 안에 다 갈 수 있답니다.^^ \n인생에서 잊지 못할 소중한 추억을 바로 이곳에서 만드시길 바랍니다.','집의 위치는 서울의 중심지를 모두 지나는 지하철 2호선 잠실역에서 900여m 떨어져 있으며 도보로는 10여분 정도로 전철역과의 접근성이 매우 뛰어납니다. 그리고 지하철 9호선 석촌고분역에서는 400여m 떨어져 있으며 도보로는 5분 정도 걸립니다.\n\n그리고 송리단길, 롯데월드, 롯데월드타워, 롯데마트, 롯데백화점, 롯데시네마, 샤롯데, 잠실 공항버스 정류장, 스타벅스 등 모든 편의시설과 관광지를 도보로 5분~10분안에 다 갈 수 있습니다.^^ 이렇게 위치적으로도 잠실의 모든 것을 누릴 수 있는 최고의 입지라고 자부하구요. 당연한 이야기지만 여러분들이 아름다운 추억을 보내시기에도 너무나도 좋습니다.^^\n\n집은 10평대 원룸이고 2명이서 지내기에는 아주 좋은 크기이며 매트리스와 요를 추가하신다면 4명까지도 이용하실 수 있습니다.\n단, 2명이 추가 될 시 1인당 15,000원의 추가요금이 발생합니다.\n무엇보다 방안의 모든 가구와 바닥 마루, 화장실 등을 새롭게 구매하고 리모델링한지 2주도 안되어 비슷한 가격대의 호텔이나 모텔보다도 더 쾌적하고 깔끔하며 분위기 있는 공간이라고 자부합니다.\n집 안 모든시설은 깨끗하고 청결하며 안전에도 문제가 없습니다.\n그리고 깨끗하고 쾌적하고 넉넉한 주방과 감각적이고 세련된 식탁이 있기에 주변의 친한 분들과 함께 오셔서 맛있는 요리를 즐기며 가족, 친구, 연인 분들과 아름다운 시간을 보내기에도 아주 좋습니다.\n\n특히 화장실도 새롭게 리모델링했기에 아주 예쁜 공간으로서 깨끗하게 준비되어 있답니다!^^\n세탁기도 있기 때문에 여행 중이시거나 세탁이 필요할 경우 언제든지 사용하실 수 있습니다.\n마지막으로 집 앞 1분 거리에 잠실 석촌호수와 송리단길이 있습니다. 날씨 좋을 때 아름다운 롯데월드타워를 보시며 산책이나 바람을 쐬러 나가실 때도 무척 좋고 야경을 즐기기에도 너무나도 좋은 곳입니다 ^^\n\n낯선 곳에서 여행을 하며 새로운 경험을 하는 것을 매우 좋아하는 사람으로서 여러분과 같이 여행자의 입장에서 필요한 모든 것을 준비해놨답니다 ^^\n평소에 인테리어에 관심이 많고 방꾸미기를 좋아해서 나름 아늑하면서도 따뜻한 공간이 되도록 꾸며보았네요 :D\n\n이제 곧 여행하기 좋은 계절이네요. 일상 속에서 어디론가 떠나고 싶거나 짧지만 힐링의 시간을 원하시는 분들!\n그런 여러분들을 이곳으로 초대합니다^^\n여기에 방문하시는 모든 분들이 인생에 있어서 최고로 좋은 추억 남기실 수 있도록 호스트로서 잘 준비해놓겠습니다!\n여러분들도 꼭 한 번 방문하셔서 아기자기하고 아늑한 분위기를 느끼며 편안한 시간 보내셨으면 좋겠네요^^\n숙소에 관해 여러가지 궁금하신 사항 있으시면 언제든지 부담갖지 마시고 메세지 주세요 ^^\n최대한 빨리 여러분의 궁금증을 해소해드리겠습니당 :)\n그럼 여기까지 검색해주시고 읽어봐주셔서 감사합니닷^^ 그럼 잘 고민해보시고 최고의 추억을 만드시고 싶으시다면 메세지 주시거나 예약해주시구~언제든지 오셔서 즐거운 시간 보내시길 바랍니다.^^','언제든지 궁금한 사항이 있으면 편하게 연락주세요^^\n24시간 5분 내로 답변드립니다~^^','숙소가 위치한 지역은 관광, 교통, 편의시설 등 모든 것이 모여있고 잘 발달되어 있는 서울시 송파구 잠실입니다.\n잠실역, 송리단길, 롯데월드, 롯데월드타워, 롯데마트, 롯데백화점, 롯데시네마, 샤롯데, 스타벅스, 잠실 공항버스 정류장 등 모든 편의시설과 관광지를 도보로 5분에서 10분 안에 다 갈 수 있습니다.^^ 당연한 이야기지만 잠실의 맛집도 많이 모여있는 곳입니다.\n\n이렇게 위치적으로도 잠실의 모든 것을 누릴 수 있는 최고의 입지라고 자부하구요. 당연한 이야기지만 여러분들이 아름다운 추억을 보내시기에도 너무나도 좋습니다.^^\n\n특히 석촌호수는 건물 1분 거리에 있을 정도로 아주 가깝습니다. 저녁에 가족, 연인, 친구 등 소중한 사람들과 아름다운 롯데월드타워와 석촌호수의 야경을 즐기며 가볍게 산책을 하시거나, 커피나 맥주를 마시며 보내시기에도 너무 좋은 곳입니다.\n이렇게 좋은 곳! 여러분도 경험 해보시길 바랍니닷^^','서울의 중심지를 모두 지나는 지하철 2호선 잠실역에서 900여m 떨어져 있으며 도보로는 10여분 정도로 전철역과의 접근성이 매우 뛰어납니다. \n그리고 지하철 9호선 석촌고분역에서는 400여m 떨어져 있으며 도보로는 5분 정도 걸립니다.','잠실 최고로 안락하고 편안한 공간',40000,4,'05510','서울 송파구 올림픽로 지하 265','롯데월드','37.513319997745555','127.10031473197408','2019-05-29 11:12:38',NULL,'c872ba86-ddfc-403a-9863-e1494bbf7ea7',0),
	(22,6,'잠실','다인실',3,1,'아늑하고 편안한 우리 웨이니(weini)하우스는 잠실 “롯데월드”와 “석촌호수” 전망이 내려다 보이는 곳에 위치해 있습니다.\n\n근처에 롯데마트와 롯데백화점, 먹자골목, 카페 등이 형성되어 있어 \n편리한 생활환경을 갖추고 있구요.\n\n숙식이 가능하게 모든 것이 구비되어 있으며, 최대 6명까지 숙식이 가능합니다.\n\n전용카드를 통해 1층 출입문을 드나들 수 있어 여자분끼리 묶으시기에도 안전합니다.\n\n지하철 2호선과 8호선의 편리한 교통시설로 대중교통을 이용하기 편리하답니다\n\n커플, 여행족, 출장자, (아이 동반) 가족에 적합합니다.','지하철 2호선과 8호선의 편리한 교통시설로 대중교통을 이용하기 편리하답니다｡','궁금한점이 있으시면 언제든지 문의 주세요~','저희 weini house는\n잠실역에 위치해 있습니다.\n석촌호수와 롯데월드, 123층의 롯데 몰이 한눈에 보이는 전망을 보유하고 있어요~~~ 최고의 자랑이지요 ^^*\n언제나 편안히 쉬었다 가실 수 있도록 준비 하고있답니다.^^*\n주위에 좋은 Cafe 와 Bar 도 많이 있어서 연인과 친구들과 시간을 보내고\n하루 쉬었다 가셔도 좋은 장소 입니다.','지하철 2호선과 8호선이 바로 옆에 위치하고 있고\n방이동 먹자골목이 바로 옆에 위치하고 있고 롯데월드몰이 앞에 위치해있습니다.\n교통, 식사, 문화 생활등을 편안히 이용하실 수 있어요~~','Tower World 잠실 석촌호수',55000,6,'05573','서울 송파구 잠실동 305-15','롯데월드','37.50442475114397','127.0770140471743','2019-05-29 15:21:42',NULL,'24d30dd1-a87f-41f4-af8b-c65ec2d28e5f',0),
	(111,6,'통영시','다인실',1,1,'아기자기한 섬과 바다의 맛과 멋이 가득한 통영에서 멋진 하루를 보내세요!\n\n통영대교가 내려다 보이는 전망좋은 아파트\n집 전체 리모델링으로 깔끔하고 편리한 시설\n아파트 앞 해양공원, 해안데크를 따라 산책 가능\n한려수도 케이블카와 루지 근처에 위치','당신이 숙소에 머무를 때 필요한 대부분을 제공합니다.\n* 거실 - TV, 소파, 협탁, 공기청정기, 에어컨, wifi\n* 주방 - 냉장고, 전자렌지, 가스렌지, 전기포트, 주방도구 및 식기류\n* 침실 - 침대(Q), 옷장, 협탁, 화장대, 헤어드라이어\n* 화장실 - 수건, 샴푸, 린스, 바디워시, 클렌징폼, 치약, 물비누','아파트의 다른 주민을 위해 저녁 소음에 주의해주세요-\n도착이 늦어지실 때와 퇴실 하실 때 꼭 메세지 부탁드려요!','통영 미수동에 위치한 작은 아파트로 바로 앞 통영대교와 해양공원이 있어 야경도 아름답고 해안데크를 따라 산책하기에 좋아요. 한려수도 케이블카와 루지, 통영유람선터미널 차로 5분, 동피랑과 중앙시장, 서피랑, 여객선터미널은 10분 거리에 있습니다!\n걸어서는 10분 거리에 횟집단지와 해저터널이 있습니다. 그리고 벛꽃이 아름다운 봉수골이 20분 거리에 있고 맛있는 해산물 찜요리와 아기자기한 카페가 많은 곳이에요!','통영버스터미널에서 차로 20~25분 정도 걸립니다.\n시내버스는 300, 500번대 미수동행을 타고《미수동주민센터》에서 내리시면 됩니다.\n주차는 아파트 내 주차장을 이용하시면 됩니다ㅎ','통영 바다가 보이는  아름다운 집!',65000,2,'53011','경남 통영시 광도면 갓섬길 14','케이블카 근처','34.926413739257164','128.43696484197625','2019-05-29 15:41:00',NULL,'5a652436-94ca-4fcd-a021-c63d3cee0c23',0),
	(112,6,'홍대입구역','다인실',1,1,'안녕하세요!!+_+\n오즈의 집 주인장 오즈입니다! 킼키킼\n오즈의집에 대해서 짧고 굵게 요점만 설명하겠습니다!! 집중해서 읽어주세요!!!\n\n! ) 홍대입구역 3번출구에서 3분컷 \n! ) 홍대 그 유명하다는!!! 연트롤 파크 30초컷\n! ) 주변 편의시설 완비\n! ) 당신은 지금 오즈의집을 예약하고싶습니다.. +_+\n! ) 당신은 지금 오즈의집에 빠졌습니다..+_+\n\n머리말_)\n\n오즈의 마법사의 집은 주인장 오즈가 직접 공사하고\n꾸민 집으로 여러분들이 마법처럼 편히 사르륵 묶고 가시라고 제가 땀흘리며 오픈한 게스트하우스 입니다! \n연트롤파크, 젊음의 명소 홍대에서 신나게 놀고 심신이 지쳤을때 오셔서 편히 마법처럼 스르륵 잠들어보세요!!!','# 체크인, 체크아웃은 셀프입니다 !\n★예약확정을 하시면 더 자세히 위치랑 숙소설명을 보내드립니다★\n\n(길을 잃으시면 언제든지 연락주세요 날아갑니다)\n\n# 에어비앤비 사진에 지도가 있으니 참고해주세요 !\n\n# 체크인- 17:00시 이후 부터 아무때나\n(늦은시간에 들어오실때는 조용히 해주세요) \n#체크아웃-13:00시 이전','체크인을 일찍하시는건 상관없습니다 \n다만 침실에는 오후 5시 이후부터 쓰실수있습니다\n거실에 짐을 냅둬주시고 에어비앤비 메세지로 사진을 찍어보내주세요!\n제가 청소후에 방안에 고히 모셔놓겠습니다 +_+','기타 질문 및 궁금한점 오즈얼굴이 보고싶으시다면ㅋㅋㅋ KA TALK: ruper2 전화 : 공일공-오공사구-팔육구사 로 연락 주시면 신속하게 답변 드리겠습니다. 저는 항상 마법으로 당신의 꿈을 지지합니다 !!! ^ _ ^ b\n','홍대입구역 3번출구에서 3분\n연트롤파크 30초컷 \n주변 30초 거리 각종편의시설 및 최고의 술집','오즈의집',33900,2,'03989','서울 마포구 연남동 358-1','홍대입구역 3번 출구','37.560236864405205','126.92377060612615','2019-05-29 15:47:56',NULL,'c7cfc245-0bdb-430b-a707-cdf12266e2cf',0),
	(113,6,'홍대','다인실',3,1,'*홍대 입구역 9번출구에서 7분거리에 있습니다. 홍익대학교와 3분 거리에 위치해있습니다.\n\n*가까운 곳에 편의점과 장을 볼 수 있는 마트가 있습니다.\n\n*최대 5명이 주무실 수 있어요. 4명까지는 추가 요금이 없어요!\n\n*따뜻한 난방과 시원한 에어컨이 사시사철 준비되어 있어요. 추운날에는 따뜻하게,\n더운날에는 시원하고 쾌적하게 있을 수 있는 집입니다.\n\n*와이파이와 포터블 와이파이가 모두 준비되어있습니다. 방에 준비해두었으니 자유롭게 사용하시고 체크아웃 시에 제자리에 둬주시면 됩니다.\n\n*이불은 인원수에 맞춰 충분히 준비해두었습니다. 퀸사이즈 구스 이불이라 따뜻하고, 성인 두 분이 이불 1개를 충분히 사용하실 수 있습니다. 침구 커버와 베개 커버는 1박을 포함한 모든 손님의 체크아웃 시에 수거, 세탁/건조합니다. 먼지 알러지나 청결 상태가 걱정이신 분들도 마음 편하게 사용하세요.\n\n* 칫솔,치약,세면도구, 바디 스펀지,비누, 생수 2병이 준비되어있습니다.\n\n*요리를 위해 필요한 주방 식기와 도구들이 충분히 준비되어 있습니다. :)\n\n*저희 집 주변에는 쇼핑과 즐길거리가 많습니다. 밑으로 쭉 내려가시면 바로 쇼핑거리가 있고, 홍대 걷기 좋은 거리가 나옵니다. 추천하는 음식점은 또보겠지 떡볶이집, 항상 줄서서 먹는 새우장덮밥이 유명한 소년식당, 퓨전 일식 좋아하시면 ginza ryoko, 고기 좋아하시면 항상 손님이 넘치는 옥돌수정생소금구이 집도 유명하니 찾아가 보세요.\n빵집은 집근처의 일본 장인이 만드는 아오이토리도 유명하고 맛있습니다. (앙버터, 명란바게트 추천!)\n\n','[침실]\n퀸사이즈 침대 2\n1인용 소파배드\n\n[부엌]\n인덕션\n냄비 / 프라이팬 / 칼 / 가위 등 조리기구\n와인잔 / 와인오프너\n커피포트\n\n[욕실]\n샴푸 / 바디워시 / 린스 \n일회용 칫솔 / 치약 / 비누 / 바디스펀지\n\n[기타]\n바닥난방 / 에어컨\n빠른 와이파이 / 포켓 와이파이 무료 대여\n케이블 티비 (노트북 연결해서 시청 가능)\n세탁기 / 세제 / 섬유유연제 / 건조대\n다리미 / 다리미판','체크인 - 오후 3시\n체크아웃 - 오전 11시\n\n[규칙] 꼭 지켜주세요!\n체크인, 체크아웃 시간을 준수해주세요.\n실내에서 절대 금연입니다.\n외출 할 때 난방, 에어컨 꺼주세요.\n벽에 부착 금지. 벽지가 손상돼요\n늦은 밤 지나친 소음에 주의해주세요.','홍대 입구역 9번출구에서 7분거리에 있습니다. 홍익대학교와 3분 거리에 위치해있습니다.','홍대 입구 9번출구에서 7분 거리에 있으니, 힘들지 않을거에요.\n모든 침구는 호스트가 직접 깨끗하게 관리해서 쾌적하고,\n문의에 대한 답변은 언제나 빠르게 드립니다. :)\n놀러오세요!','감각적인 복층 스튜디오',50000,5,'03900','서울 마포구 가양대로 1','홍대입구역','37.57703941571225','126.86439732179267','2019-05-29 15:57:56',NULL,'6ce9aaeb-eb74-4ad9-81a4-6cb0b3b6305b',0),
	(114,6,'남해군','다인실',1,1,'가슴에 담고 싶은 순간\n푸른 남해바다를 바라보며,\n지금 이 순간을 사랑하는 사람과 나눕니다.\n\n수평선으로 떨어지는 붉은 해를 바라보며 스파에 몸을 담그면\n고단했던 일상이 잊혀 집니다.\n\n한 번쯤 먼 바다를 향해가는 그런 여행을 꿈꿔보지 않으셨나요.\n잠깐 스쳐지나가며 모든 것을 담기에는 아름다움이 너무 많습니다.\n파도소리 바람소리만 들리는 이곳에서.\n멈추면 비로소 보이는 아름다운 감성을 느껴보세요.\n\n아련한 사랑과 추억을 만드는 곳\n남해스파힐입니다.','[바비큐이용안내]\n바베큐 숯, 그릴 대여시 비용이 발생합니다.\n2인 10,000원 / 4인 20,000원\n(현장결제 (Website hidden by Airbnb) \n바다와 수영장이하나로 연결된 듯 한 아름다운 전망의 수영장에서 최고의 추억을 간직하세요.\n유아 및 아이가 놀기에 좋은 수영장입니다.\n수영장 길이 :10M, 폭5M, 높이 1M\n7~8월 개장 예정입니다.\n\n[ 스 파 ]\n남해바다를 한눈에 감상하면 즐길 수 있는 스파가 각 객실에 설치되어 있습니다.\n단독 데크에 마련된 스파 공간은 둘만의 스파를 즐기기에 최적의 장소이며, \n달콤한 와인과 프로젝트로 영화 감상도 함께 하면 로맨틱한 시간이 될 것입니다.\n\n(Website hidden by Airbnb) 펜션에서 운영하는 편의점에서 필요한 물품들을 구입할 수 있어요.\n음료, 주류, 군것질거리, 거기에 갑자기 필요할 수 있는 상비약들까지.\n다양한 물품이 준비되어 있습니다.\n편의점과 연결된 야외 카페에는 넓게 펼쳐진 야경을 감상하실수도 있습니다.\n\n(Website hidden by Airbnb) 펜션 바로 앞에 바다가 펼쳐져 있어 언제든 바다를 가까이서 볼 수 있습니다.\n파도소리를 더 가까이 듣고 싶다면 사랑하는 사람과 따뜻한 아메리카노 한잔 들고나가 해변을 걸어보세요.\n걷는 발걸음마다 웃음과 행복이 쌓여갈 거예요. 걸어서 10분 거리의 바닷가에 석방렴이 있답니다,\n\n(Website hidden by Airbnb) 컵라면와 커피는 각 객실에 비치되어 있습니다.\n\n(Website hidden by Airbnb) 보고싶은 영화를 USB에 담아 오시면 빔 프로젝트 통해 영화감상 하실 수 있습니다.\n사용 가능한 객실을 (Phone number hidden by Airbnb) 호 객실만 사용가능합니다.\n\n(Website hidden by Airbnb) 많은 분들이 다녀간 만큼 더욱 청결에 힘을 쓰고 있습니다.\n남해 최고 청결한 침구 및 객실로 여러분을 맞이하겠습니다.','입실시간 16:00 / 퇴실시간 12:00\n퇴실 시 퇴실점검이 있습니다.','Nam-myeon, Namhae, Gyeongsangnam-do, 한국에 있습니다.','자가용 이용 권장','올화이트로 이루어진 심플한 객실',127200,3,'52436','경남 남해군 남면 남면로 219-48','바다 근처','34.75275678549938','127.90547679201696','2019-05-29 16:06:14',NULL,'aa31a1b7-c17d-41ae-91ea-b115efd2e210',0),
	(115,6,'남해군','다인실',2,1,'버지니아 맨션은 푸른 바다, 농지, 산과 아름다운 마을로 둘러싸여 있습니다.\n네, 정말 멋진 경치예요.\n저는 남해에 있는 아메리칸 빌리지에서 가장 깨끗하고 최신 스타일의 방을 가지고 있습니다.\n버지니아 맨션은 사생활 보호를 위해 좋은 위치에 있습니다.','반려동물 동반 불가\n흡연, 파티 또는 이벤트 금지','체크인 시간: 15:00~02:00(다음 날), 체크아웃 시간: 11:00까지',' Idong-myeon, Namhae-gun, Gyeongsangnam-do, 한국에 있습니다.','자가용 이용 권장 ','버지니아 맨션 ',212500,6,'52430','경남 남해군 이동면 강진만로 302','아메리칸 빌리지','34.83034191943281','127.93570430570483','2019-05-29 16:13:42',NULL,'416ccd80-e199-4bd2-bf6f-8d0336f9f06e',0),
	(116,6,'광안리','개인실',4,2,'헤븐리 펜트하우스는 광안리 해변 바로앞 10층에 위치하여 환상적인 바다 전망을 즐길 수 있습니다. 침실 3개와 욕실 2개, 주방을 갖춘 30평대 하우스입니다. 총 12인까지 수용이 가능하여 가족여행, 동호회 모임, 회사 워크샵, 파티 등 각종 단체를 위한 최상의 조건을 갖춘 숙소입니다.\n기본요금은 4인 기준입니다. 추가인원은 1인당 15,000원의 요금이 부과되며 추가로 매트리스와 침구를 제공합니다. \n헤븐리는 광안리에서 즐길 수 있는 모든것들과 가까운 거리에 있어요. 회센터, 해변 버스킹, 수변공원, 해수온천, 서핑, 해변까페거리 등 광안리 핫스팟 모두 도보 5분 이내 거리에 있답니다 :) \n광안리의 밤은 짧아요! 게스트님의 숙면을 위해 포근하고 청결한 호텔식 침구와 암막 커튼을 준비했습니다.','헤븐리 펜트하우스는 두개의 30평대 스위트 하우스를 보유하고 있습니다. 지금 보고 계신곳은 뻥뚫린 시원한 오션뷰를 즐기실 수 있는 오션뷰 하우스입니다. \n침실 1: 퀸 침대, 오션뷰 bar\n침실 2: 퀸 침대, 오션뷰 bar, 좌식 테이블\n침실 3: 퀸 침대2, TV, 옷걸이 \n주방 : 조리가능한 도구/식기 완비, 식탁\n욕실 1: 샤워칸분리된 화장실 \n욕실 2: 두개의 샤워칸 \n* 샴푸, 린스, 바디젤, 비누, 치약, 수건 제공\n\n모든공간 냉/난방 시설 완비','체크인 시간: 16:00 이후 언제나, 체크아웃 시간: 12:00까지\n키패드(으)로 셀프 체크인','Millak-dong, Suyeong-gu, Busan, 한국에 있습니다.','대중교통, 자가용 권장 ','오션뷰 스위트 펜션',150000,8,'48277','부산 수영구 민락동 161-25','광안 대교','35.15887723526162','129.12106357966925','2019-05-29 16:21:59',NULL,'dc81945d-4be6-402c-9906-aa57e671c8c0',0),
	(117,6,'센텀시티','개인실',3,2,'◆30층 이상의 초고층 부산 해운대 고급 아파트\n◆안전성, 편리함, 청결함이 최고인 호텔같은 아파트\n◆거실, 방의 베란다에서 보이는 끝내주는 시티뷰\n(자연스럽게 힐링됩니다*^^*)\n◆남녀노소 모두가 머무를 수 있는 적합한 숙소\n◆벡스코행사 참여, 결혼식 하객, 단체모임 , 가족여행에 안성맞춤 숙소\n\n-해운대구 재송동 센텀시티에 위치한 초고층 고급 \n아파트 단지이며, 밤에는 LED조명이 켜지고 여러 \n색깔들이 보여요.\n\n-전망좋은 고층 아파트, 54평에\n심플,모던 겸 고풍스러운 분위기도 느껴지는 공간의 느낌을 만끽해 보세요.\n\n-내진,재진,면진완벽설계로 인한 안전성을 보장하며,\n층마다 크린룸완비(음실물쓰레기, 일반쓰레기, \n분리수거시설)로 인해 편리함과 청결함을 \n자랑해요.','-호텔식 화이트 침구로 청결함을 최우선으로 하며, \n넉넉한 공간에 추가인원을 위한 매트리스(요+ 이불)를 준비하여 편안한 침실을 제공해요.\n\n-넓은 주방은 게스트분들이 요리하기에 부족하지 않은 공간이에요. 요리하고 싶은 욕구가 생겨요.\n\n-게스트분들이 머무시는 동안 가족, 동료, 친구, 연인과 많은 대화를 나눌 수 있는 공간으로 거실쪽에 식탁을 두어서 식사 및 작업 등 다용도로 사용 하실 수 있어요.\n\n-심플한 컨셉 위주고 너무 꽉 채우지 않고, 비움의 공간을 주어 게스트의 자유공간으로 만들었어요. 머무시는동안 내집처럼 사용해 보세요.\n\n-상가마트,미용실, 카페, 치킨집, 다양한 먹거리 음식점, 음주 할 수 있는 가게 등이 있어요.\n아파트 주변 각종 편의 시설이 갖춰져 있어요. 조금만 눈을 돌려보시면 있을건 다 있답니다.\n(아파트 단지 내에 \"BBQ치킨 부산해운대센텀점\"이 있어요. 야식은 치맥 아시죠??^^ㅋ)\n\n-숙소 옆에는 큰 도로지만 차들이 많이 다니지 않아 교통이 혼잡하지 않아서 좋아요. \n조용해서 우리만 있는 공간 같아서 더 좋고, 잠도 푹 잘 수 있어요.\n\n-밤에 시티뷰가 정말 최고!!!\n조명만 켜고, 식탁에 앉아 좋은 사람들과 함께라면 분위기 있는 밤을 보내실거에요.(얘기가 술술~~)\n\n-조금 더 쾌적한 숙소를 제공하고 싶어서, 숙소 오픈하고 얼마 후에 공기청정기를 비치해 두었습니다. \n(먼지와 세균 용납 할 수 없어요!!! \n게스트를 위해 항상 뭔가를 준비하고, 노력하는 숙소입니다.^-^)\n\n','※게스트를 위해 깨끗하고, 편안히 머무를 수 있는 숙소로 준비하겠습니다.\n\n※예약 확정되면 체크인 하시기 전에 안내사항 (정확한 주소와 현관 비밀번호 등)을 알려드립니다.\n\n※흡연은 절대 하면 안됩니다. \n그리고 야간에는 이웃주민들을 위해 지나친 소음은 자제 부탁드립니다.','Jaesong 1(il)-dong, Haeundae, Busan, 한국에 있습니다.\n-1분거리 센텀역이 있어서, \n벡스코방면/기장방면으로 쉽고 빠르게 가실 수 있어요.\n\n-동해선 센텀역을 끼고 있으며 수영강을 따라 \n산책하기에도 아주 좋아요.(누리공원)\n\n-영화의 전당,벡스코,신세계/롯데 백화점이 있어요. 걸어가시면서 각종 먹거리식당, 베이커리,카페 등 편의시설이 엄청 많아요.(주거,직장,문화 밀집 동네)','센텀시티역 하차, 자가용 이용','해운대 센텀 고급 시티뷰',138000,8,'48054','부산 해운대구 재송동 210-74','센텀시티','35.188251742002066','129.1214362000572','2019-05-29 16:28:52',NULL,'ab461b19-0a69-4f4d-88ed-a19d08190ceb',0),
	(118,6,'제주도','다인실',4,3,'2019년 1월 리뉴얼 오픈한 저희 하우스는 천지연 폭포 근처 서귀포 미항 바로 앞에 있는 건물의 6층에 위치해 있습니다.\n\n바다 방향에 마련된 넓은 공용 테라스 혹은 일부 바다방향 룸에서 서귀포 앞바다와 아름다운 부속 섬들(새섬, 문섬, 섶섬, 범섬)을 바로 눈 앞에서 아찔하게 보실 수 있습니다. 저녁이 되면 은은한 조명이 켜지는 새연교의 아름다움과 그 위로 떨어지는 대한민국 남단의 항홀한 낙조를 경험하실 수도 있습니다.\n\n전망의 장점을 잘 살린 인테리어와 널찍한 공간을 구성해서 시끌벅적한 파티를 강조하는 일부 게하와는 다르게 게하 본연의 기능에 충실해서 아름다운 서귀포를 감각적으로 느끼며 조용히 여행하고 싶어하는 나홀로나 단체 및 커플여행객에 적합합니다.. \n(제주 환상 자전거 또는 스쿠터 여행족을 위한 완벽한 보관소도 보유하고 있어요)','해당룸은 여성전용 8인 도미토리입니다. 오션뷰 룸으로 방안에서 혹은 야외 테라스에서 환상적인 서귀포 미항과 아름다운 새연교 및 여러 섬들을 보실 수 있습니다.\n\n각 침실마다 개인 콘센트/신발장/사물함 구비되어 있습니다.\n\n공용화장실(남,녀 구분)/샤워장(칸막이 구분)을 이용합니다.\n공용주방에서는 조식으로는 토스트/쨈/커피가 무상 제공됩니다.\n바다가 보이는 휴게실과 테라스는 마음껏 이용하실 수 있습니다.\n\n저희 하우스는 최근 문제가 되고 있는 술자리가 곁들이는 저녁 단체 파티를 하지 않는 일반적인 게스트하우스로서 제주를 오롯이 느끼며 조용히 여행하고자 하는 여행객에게 적합합니다. 요란하고 신나는 단체 파티는 여행 일정 중 바람 많이 부는 서쪽 애월이나 동쪽 성산 쪽 파티 전문 게스트하우스에서 하시고... 여행 중간에 머무를 여기 남쪽 서귀포에서는 전망좋은 저희 숙소에서 아름다운 대한민국 남녘 바다와 섬들을 보며 힐링~해 보시는 일정으로 계획을 세워 보시는게 어떨까요? \n새섬과 새연교가 눈앞에 아찔하게 보이는 전망좋은 야외 테라스에서 혼자서 혹은 룸에서 새로 사귄 친구와 가볍게 한잔 하는 분위기는 언제든 환영입니다. \n내일의 또다른 소중한 스케줄을 위해 밤 11시에는 전체 소등합니다.','1시간 정도 게스트와 시간을 보낼 수 있습니다  ^^ ','Chilsimni-ro, Seogwipo-si, Jeju-do, 한국에 있습니다.\n도보 10분 이내에 천지연 폭포와 이중섭거리, 서귀포유람선과 잠수함을 탈 수 있는 매표소가 있어요. \n서귀포올레시장 또한 1km 거리이고 숙소 주변엔 음식문화특화 거리로 다양한 먹거리 식당이 있어서 뚜벅이 나 홀로 여행객도 부담없이 서귀포 중심가를 여행할 수 있습니다.','대중교통으로의 접근 - 제주공항에서 공항 리무진 버스 600번을 이용해서 \'서귀포항\'에서 내리시면 2~3분 거리에 숙소가 있습니다.\n주차공간 - 건물 1층 주차장, 건물 앞 서귀포항 무료 주차장 및 건물 뒷편 자체 주차장이 있습니다.\n자전거나 스쿠터 주차 - 건물내 안전한 자체 보관 장소가 있습니다.','감성 힐링 오션뷰 도미토리',17000,8,'63275','제주특별자치도 제주시 가령골길 1','제주도 해변 근처','33.50586125126642','126.54021599812346','2019-05-29 16:36:28',NULL,'e4925fb8-cc17-4162-972c-4c8fddf8a1b5',0),
	(119,6,'춘천','개인실',2,1,'한적한 마을에 있는 한옥독채입니다. 가족 또는 연인과 오붓하게 시간보내시고 싶은 분이나 혼자만의 휴식, 힐링이 필요하신 분에게 권합니다. 낮에는 산과 들 풍경을 벗삼고, 밤에는 하늘가득 빤짝이는 별을 만날 수 있습니다.\n\n기본인원은 2인이며, 인원을 추가하시면 4인까지 이용 가능합니다. (5인 이상일 경우는 예약전 메세지 주세요.)\n\n침구는 항상 새로 직접 세탁한 것을 드립니다. \n유기농 면과 광목, 순면 제품으로 준비드려요. \n(유아로 표시된 손님에는 추가비용이 발생하지 않습니다. 이런경우 요는 추가되지 않고 담요를 하나 준비해 드립니다. 유아손님이지만 이부자리 추가를 원하시면 어린이로 표시해주세요.)\n\n숙소에서 요리하실 수 있습니다. 실내에 냄새가 베는 요리는 삼가주세요. 미리 말씀해주시면 야외에서 바베큐 가능합니다. (오시는 길목에 가까운 마트와 식당 안내드려요.)','전통건축일을 하고 있는 제가 시골집을 직접 고쳐보았습니다. 단열을 새로하여 춥지 않습니다. 작은방은 전통방식으로 흙벽을 치고 구들드려 온돌방을 꾸몄습니다. 불편함은 빼고 아늑함만 남긴 집이에요:) 인스타그램 #지혜원 에 참고하실 사진이 더 있습니다.\n\n전통방식의 구들방, 작은대청, 툇마루, 안방, 욕실, 주방겸 식당, 데크 등 집전체를 사용할 수 있습니다.\n\n보이차와 다구, 원두와 드립세트, 믹스커피, 홍차 티백, 커피캡슐 등을 준비드려요.\n\n조리도구와 그릇, 양념(소금, 간장, 식초, 설탕, 기름, 고춧가루 등)을 사용하세요.\n\n냉장고, 전기렌지, 전자렌지, 밥솥, 전기포트, 토스터 그리고 세탁기가 있습니다.\n\nTV, wifi, 에어컨, 선풍기, 온풍기, 비데\n\n비누, 폼클렌져, 치약, 샴푸, 컨디셔너, 바디샴푸,\n수건과 헤어드라이어,\n\n비상약품이 준비되어 있습니다.','언제든지 궁금한 사항에 대하여 문의주세요. 소규모 파티나 촬영을 위한 대관 가능합니다. 집짓기에 대한 대화도 환영합니다:) 영어가능합니다(English speaking host).','산과 강으로 둘러싸인 조용한 농촌마을입니다. 춘천댐 상류지역으로 물이 많고 경치가 좋습니다. 산에서 나는 샘물을 마을 상수도로 이용합니다. 솔바우마을 농산품(된장, 감자, 한과 등)구매가능합니다.\n\n주변관광지 : \n고탄낚시터, 해피초원목장(2km)\n용화산계곡 휴양림(3km)\n막국수체험박물관(8km)\n이상원미술관(9km)\n애니메이션박물관, 로봇박물관(11km)\n소양강댐, 닭갈비막국수 거리(12km)\n화천산천어축제장(13km)\n옥광산, 달아실미술관(13km)\n구봉산전망대 카페거리(14km)\n김유정문학촌,책과인쇄박물관,레일바이크(20km)\n\n출발지와 가고싶은 곳 알려주시면 여행일정에 맞는 코스와 근처 식당과 카페 소개해드려요.\n\n특별히 예쁜경치를 만나실 수 있는 곳:\n•춘천댐 옆 \'수력원자력 한강수력본부\' 벗꽃길\n•\'현지사\' 옆 연꽃단지\n•강원한우 해피초원목장','서울방향에서 운전해 오신다면,\n의암댐-서면(애니메이션,로봇박물관,경치좋은카페)-춘천댐을 지나는 드라이브코스(마라톤 코스이기도 합니다)를 추천합니다.\n\n시내버스를 이용하실 분은 미리 연락주시면 자세히 안내하겠습니다. 저와 시간 맞으시면 픽업해드려요.','지혜원 한옥독채',180000,4,'24201','강원 춘천시 사북면 송암리 167','지혜원','38.005552614883875','127.69213388843737','2019-05-29 16:43:57',NULL,'24a7db94-4124-454e-8d99-d74e8dd00a72',0),
	(120,6,'연남동','다인실',4,2,'1. 심플한 무지(201) & 모던한 흑백(301) 스타일의 실내 - 원목가구로 인해 따듯하고 편안한 2층 실내와 모던한 흑백 가구로 채워진 3층 실내\n\n2. 편리한 대중교통 접근성 - 공항철도 및 지하철 2호선 홍대입구역 3번 출구에서 도보 10분 이내 거리입니다.\n\n3. 환상적인 루프탑 - 루프탑에서 경관을 바라보면, 이국적인 분위기를 느낄 수 있습니다.','건물 2, 3층 및 환상적인 루프탑까지 자유롭게 사용할 수 있습니다.\n\n루프탑 바베큐 이용에는 준비가 필요하므로 미리 문의 주세요.\n소고기, 돼지고기, 새우, 버섯, 소시지, 쌈 채소, 쌈장, 식기류 일체가 넉넉히 제공됩니다. 음료 및 주류는 준비해오셔야 합니다.\n1인당 30,000원이며, 최소 4인부터 이용 가능합니다.\n\n연남동 중심지의 접근성 좋은 위치\n- 홍대역(공항철도)에서 도보 7분 거리\n- 연남 센트럴 파크, 테마를 가진 여러 카페, 맛집\n- 편리한 대중 교통 : 지하철, 공항철도, 버스\n\n아래는 무료로 제공됩니다.\n- 환상적인 루프탑\n- 세탁기, 건조기\n- 실내 100Mb Wi-Fi\n- 조리 기구 일체가 완비된 부엌(냄새나는 음식, 고기 및 생선 구이 불가)\n- 주차(대형 불가, 중형 이하 가능)','문의에 대한 응답 가능 시간은 09:00~17:00 입니다. 응급 상황 발생 시, 15분 내에 도착 가능합니다.','홍대 옆 조용한 거리였던 연남동은 이제 홍대 못지않은 번화가입니다.\n\n경의선 숲길(연남 센트럴 파크)을 따라 수많은 식당과 카페가 즐비하며, 밤낮 할 것 없이 늘 많은 사람들로 붐빕니다.\n\n근처에 동진시장이 위치해있으며 주변에 카페나 다양한 음식점이 많습니다.','홍대입구역 공항철도 3번 출구와 도보로 10분 거리(630m)에 위치해있습니다.\n숙소에 주차(무료, 중형 이하)는 1대 가능하고\n필요 시, 연남 노상 공영주차장(10m, 유료)에 주차 할 수 있습니다.\n\n\n','무지&모던 스타일 파티룸',712963,8,'03989','서울 마포구 연남동 358-1','역 근처','37.560236864405205','126.92377060612615','2019-05-29 16:51:55',NULL,'2880ced9-fcb3-4aeb-88ea-5d8f08b91ce1',0),
	(125,6,'asdf','집전체',1,1,'asdfasdfaas','','','','','asdfasdf',34534,1,'06000','서울 강남구 강남대로 708','asdf','37.52444025620515','127.01593273664581','2019-05-31 10:08:38',NULL,'e3721751-a3dd-433f-a40d-18eb115d9022',0),
	(126,6,'강남','다인실',2,1,'설명입니다설명입니다.','추가설명입니다','추가설명입니다','추가설명입니다','추가설명입니다','제목제목',115000,4,'06267','서울 강남구 강남대로 238','강남역','37.48496497372552','127.03475678137497','2019-05-31 11:37:28',NULL,'dda2d6df-541d-4c12-82e4-711a8317c7d0',0),
	(128,6,'gsdgsdg','집전체',1,1,'gsdgsdgsdgsdgsdg','','','','','zzz',111111,1,'06000','서울 강남구 강남대로 708','aaa','37.52444025620515','127.01593273664581','2019-06-10 09:34:11',NULL,'6047761c-693e-4858-8c03-f678b83cd947',0);

/*!40000 ALTER TABLE `rms` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rms_amn
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rms_amn`;

CREATE TABLE `rms_amn` (
  `amn_id` int(11) NOT NULL,
  `rms_id` int(11) NOT NULL,
  PRIMARY KEY (`amn_id`,`rms_id`),
  KEY `FK_rms_TO_rms_amn` (`rms_id`),
  CONSTRAINT `FK_amn_TO_rms_amn` FOREIGN KEY (`amn_id`) REFERENCES `amn` (`amn_id`),
  CONSTRAINT `FK_rms_TO_rms_amn` FOREIGN KEY (`rms_id`) REFERENCES `rms` (`rms_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `rms_amn` WRITE;
/*!40000 ALTER TABLE `rms_amn` DISABLE KEYS */;

INSERT INTO `rms_amn` (`amn_id`, `rms_id`)
VALUES
	(1,13),
	(1,14),
	(1,15),
	(1,16),
	(1,17),
	(1,19),
	(1,21),
	(1,22),
	(1,111),
	(1,112),
	(1,113),
	(1,114),
	(1,115),
	(1,116),
	(1,117),
	(1,118),
	(1,119),
	(1,120),
	(1,125),
	(1,126),
	(1,128),
	(2,13),
	(2,14),
	(2,15),
	(2,16),
	(2,17),
	(2,19),
	(2,21),
	(2,22),
	(2,111),
	(2,112),
	(2,113),
	(2,115),
	(2,116),
	(2,117),
	(2,118),
	(2,119),
	(2,120),
	(2,126),
	(3,13),
	(3,14),
	(3,15),
	(3,16),
	(3,17),
	(3,19),
	(3,21),
	(3,22),
	(3,111),
	(3,112),
	(3,113),
	(3,114),
	(3,115),
	(3,117),
	(3,118),
	(3,119),
	(3,120),
	(3,126),
	(4,13),
	(4,14),
	(4,15),
	(4,16),
	(4,17),
	(4,19),
	(4,21),
	(4,22),
	(4,111),
	(4,113),
	(4,114),
	(4,115),
	(4,116),
	(4,117),
	(4,118),
	(4,119),
	(4,120),
	(4,126),
	(5,13),
	(5,14),
	(5,15),
	(5,16),
	(5,17),
	(5,19),
	(5,21),
	(5,22),
	(5,111),
	(5,112),
	(5,113),
	(5,114),
	(5,115),
	(5,116),
	(5,117),
	(5,119),
	(5,120),
	(5,126),
	(6,13),
	(6,14),
	(6,15),
	(6,16),
	(6,17),
	(6,19),
	(6,21),
	(6,22),
	(6,111),
	(6,112),
	(6,113),
	(6,114),
	(6,116),
	(6,117),
	(6,118),
	(6,119),
	(6,126),
	(7,13),
	(7,14),
	(7,15),
	(7,16),
	(7,17),
	(7,19),
	(7,21),
	(7,22),
	(7,117),
	(7,126),
	(8,111),
	(8,112),
	(8,114),
	(8,117),
	(8,118),
	(8,119),
	(9,13),
	(9,14),
	(9,15),
	(9,16),
	(9,17),
	(9,19),
	(9,21),
	(9,22),
	(9,111),
	(9,115),
	(9,116),
	(9,117),
	(9,118),
	(9,119),
	(9,120),
	(10,113),
	(10,114),
	(10,115),
	(10,116),
	(10,117),
	(10,118),
	(10,119),
	(10,120),
	(11,111),
	(11,112),
	(11,115),
	(11,116),
	(11,117),
	(11,118),
	(11,119),
	(11,120),
	(12,13),
	(12,14),
	(12,15),
	(12,16),
	(12,17),
	(12,19),
	(12,21),
	(12,22),
	(12,111),
	(12,112),
	(12,113),
	(12,114),
	(12,115),
	(12,116),
	(12,117),
	(12,118),
	(12,119),
	(12,120),
	(13,114),
	(13,120);

/*!40000 ALTER TABLE `rms_amn` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rms_safety
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rms_safety`;

CREATE TABLE `rms_safety` (
  `safety_id` int(11) NOT NULL,
  `rms_id` int(11) NOT NULL,
  PRIMARY KEY (`safety_id`,`rms_id`),
  KEY `FK_rms_TO_rms_safety` (`rms_id`),
  CONSTRAINT `FK_rms_TO_rms_safety` FOREIGN KEY (`rms_id`) REFERENCES `rms` (`rms_id`),
  CONSTRAINT `FK_safety_TO_rms_safety` FOREIGN KEY (`safety_id`) REFERENCES `safety` (`safety_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `rms_safety` WRITE;
/*!40000 ALTER TABLE `rms_safety` DISABLE KEYS */;

INSERT INTO `rms_safety` (`safety_id`, `rms_id`)
VALUES
	(1,13),
	(1,14),
	(1,15),
	(1,16),
	(1,17),
	(1,19),
	(1,21),
	(1,22),
	(1,111),
	(1,112),
	(1,113),
	(1,114),
	(1,115),
	(1,116),
	(1,117),
	(1,118),
	(1,119),
	(1,120),
	(1,125),
	(1,126),
	(1,128),
	(2,13),
	(2,21),
	(2,111),
	(2,112),
	(2,113),
	(2,114),
	(2,115),
	(2,116),
	(2,117),
	(2,118),
	(2,119),
	(2,120),
	(3,111),
	(3,112),
	(3,113),
	(3,114),
	(3,115),
	(3,116),
	(3,117),
	(3,118),
	(3,119),
	(3,120),
	(4,13),
	(4,14),
	(4,15),
	(4,16),
	(4,17),
	(4,19),
	(4,21),
	(4,22),
	(4,114),
	(4,115),
	(4,116),
	(4,117),
	(4,118),
	(4,119),
	(4,120),
	(4,126),
	(5,111),
	(5,116),
	(5,120);

/*!40000 ALTER TABLE `rms_safety` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table safety
# ------------------------------------------------------------

DROP TABLE IF EXISTS `safety`;

CREATE TABLE `safety` (
  `safety_id` int(11) NOT NULL AUTO_INCREMENT,
  `safety` varchar(255) NOT NULL,
  PRIMARY KEY (`safety_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

LOCK TABLES `safety` WRITE;
/*!40000 ALTER TABLE `safety` DISABLE KEYS */;

INSERT INTO `safety` (`safety_id`, `safety`)
VALUES
	(1,'화재감지기'),
	(2,'일산화탄소 감지기'),
	(3,'구급상자'),
	(4,'소화기'),
	(5,'침실문 잠금장치');

/*!40000 ALTER TABLE `safety` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table stus
# ------------------------------------------------------------

DROP TABLE IF EXISTS `stus`;

CREATE TABLE `stus` (
  `stus_id` int(11) NOT NULL AUTO_INCREMENT,
  `stus` char(10) NOT NULL,
  PRIMARY KEY (`stus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

LOCK TABLES `stus` WRITE;
/*!40000 ALTER TABLE `stus` DISABLE KEYS */;

INSERT INTO `stus` (`stus_id`, `stus`)
VALUES
	(1,'결제완료'),
	(2,'체크인'),
	(3,'체크아웃'),
	(4,'결제취소');

/*!40000 ALTER TABLE `stus` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table usr
# ------------------------------------------------------------

DROP TABLE IF EXISTS `usr`;

CREATE TABLE `usr` (
  `usr_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `auth_id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `cdt` datetime NOT NULL DEFAULT current_timestamp(),
  `sns_no` int(11) NOT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `usr_photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usr_id`),
  KEY `FK_auth_TO_usr` (`auth_id`),
  CONSTRAINT `FK_auth_TO_usr` FOREIGN KEY (`auth_id`) REFERENCES `auth` (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

LOCK TABLES `usr` WRITE;
/*!40000 ALTER TABLE `usr` DISABLE KEYS */;

INSERT INTO `usr` (`usr_id`, `email`, `pwd`, `auth_id`, `name`, `cdt`, `sns_no`, `tel`, `usr_photo`)
VALUES
	(1,'tlwls@naver.com','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',1,'사랑하는슬기','2019-05-28 09:55:32',0,'010-4444-3333',NULL),
	(2,'qwrwer@naver.com','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',1,'삼순이','2019-05-28 09:55:32',0,'010-5647-3333',NULL),
	(3,'sadfe@naver.com','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',1,'둘리','2019-05-28 09:55:32',0,'010-4456-3433',NULL),
	(4,'werdf@naver.com','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',1,'도넛','2019-05-28 09:55:32',0,'010-7894-3344',NULL),
	(5,'sdfdsre@naver.com','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',2,'원빈','2019-05-28 09:55:32',0,'010-5452-3733',NULL),
	(6,'sdafwerdf@naver.com','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',2,'한효주','2019-05-28 09:55:32',0,'010-4456-3133',NULL),
	(7,'ewrsdf@daum.net','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',2,'강동원','2019-05-28 09:55:32',0,'010-4433-3322',NULL),
	(8,'erwerdf@daum.net','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',2,'이지혜','2019-05-28 09:55:32',0,'010-4894-3733',NULL),
	(9,'fgertewr@daum.net','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',1,'앙리','2019-05-28 09:55:32',0,'010-4466-3983',NULL),
	(10,'ewrdsf@gmail.com','*89C6B530AA78695E257E55D63C00A6EC9AD3E977',2,'김사랑','2019-05-28 09:55:32',0,'010-4411-3893',NULL),
	(11,'saint2030@naver.com','*E9D057131C22A0D76B4AAD2C61655BDFA706E637',1,'손병준','2019-05-30 11:11:50',0,'01094559808','7bab831c-0a3f-43f0-9f80-65d01d4617ac.jpeg'),
	(12,'sambosoft@Naver.com','*E65BEA0FE33E04B494310B9FD4DE3961C79828C0',1,'전진욱','2019-05-30 12:17:13',0,NULL,'826aeac5-1040-4585-a630-30b862e09538.jpeg'),
	(13,'aaaa','*367BE0AF56D3C7A0A3C1725AFBC9D25E1E95C36E',1,'김김김','2019-06-11 15:58:09',0,NULL,'default.jpeg'),
	(14,'aaaa','*367BE0AF56D3C7A0A3C1725AFBC9D25E1E95C36E',1,'김김김','2019-06-11 15:58:34',0,NULL,'default.jpeg'),
	(15,'aaaa@com.com','*367BE0AF56D3C7A0A3C1725AFBC9D25E1E95C36E',1,'김김김','2019-06-11 16:02:22',0,NULL,'default.jpeg');

/*!40000 ALTER TABLE `usr` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
