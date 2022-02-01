CREATE DATABASE IF NOT EXISTS university CHARACTER SET
utf8 COLLATE utf8_general_ci;

USE university;

CREATE TABLE IF NOT EXISTS university.university(
    id    int PRIMARY KEY AUTO_INCREMENT,
    name         varchar(50) NOT NULL,
    furikana      varchar(30) NOT NULL,
    INDEX(id)
);