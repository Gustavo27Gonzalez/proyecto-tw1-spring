/*
CREATE DATABASE IF NOT EXISTS tw1dbprod;
USE tw1dbprod;
-- DROP DATABASE tw1dbprod;

CREATE TABLE usuarios(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(50),
pass VARCHAR(30),
rol VARCHAR(50),
activo boolean);

USE tw1dbprod;

select * from usuarios;

INSERT INTO usuarios(email, pass) VALUES
("usuario1@prueba.com", "usuario1"),
("usuario2@prueba.com", "usuario2"),
("usuario3@prueba.com", "usuario3");

*/