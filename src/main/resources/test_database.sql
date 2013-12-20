CREATE DATABASE myweb_test;
USE myweb_test;
CREATE TABLE authorities
(
  username  VARCHAR(50),
  authority VARCHAR(20)
);
CREATE TABLE token
(
  code     VARCHAR(50) PRIMARY KEY             NOT NULL,
  username VARCHAR(50)                         NOT NULL,
  time     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
CREATE TABLE users
(
  id       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(50)     NOT NULL,
  nickname VARCHAR(50),
  realname VARCHAR(50),
  sex      INT,
  birthday DATE,
  email    VARCHAR(50),
  password VARCHAR(200),
  enabled  BIT
);
CREATE UNIQUE INDEX unique_username ON users (username);
