create database project default character set utf8;

CREATE TABLE BOARD(
  NO INT(11) unsigned NOT NULL AUTO_INCREMENT,
    SUBJECT VARCHAR(255) NOT NULL,
  CONTENT TEXT,
  CREATED datetime,
  PRIMARY KEY (NO)
);