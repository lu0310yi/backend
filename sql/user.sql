CREATE DATABASE newdb`newdb`;
CREATE TABLE `user`(
userid INT PRIMARY KEY AUTO_INCREMENT,
nickname VARCHAR(20) UNIQUE,
`password` VARCHAR(16) DEFAULT '123456',
gender CHAR,
mobile CHAR(11) UNIQUE,
avatar VARCHAR(20),
background VARCHAR(20),`user`
county_id VARCHAR(20),
gmt_birth DATE,
signature VARCHAR(100),
gmt_sign_up DATETIME NOT NULL,
gmt_last_login DATETIME NOT NULL,
last_login_ipv4 VARCHAR(15),
last_login_ipv6 VARCHAR(39)
)


INSERT INTO `user` VALUES(
1,'lili','asdfg15946',`user`

