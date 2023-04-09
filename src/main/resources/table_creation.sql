create database documentation_server;
use documentation_server;

CREATE TABLE metadocument (
id int NOT NULL AUTO_INCREMENT,
name varchar(255),
year varchar(255),
owner varchar(255),
uuid varchar(255),
PRIMARY KEY (id)
);

CREATE TABLE document (
id int NOT NULL AUTO_INCREMENT,
mime varchar(255),
uuid varchar(255),
data MEDIUMBLOB,
PRIMARY KEY (id)
);

