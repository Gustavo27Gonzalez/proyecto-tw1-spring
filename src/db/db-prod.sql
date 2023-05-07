/*
CREATE SCHEMA IF NOT EXISTS codermix;
USE codermix;
-- DROP DATABASE codermix;

CREATE TABLE usuarios(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(50),
password VARCHAR(30),
nombre VARCHAR(50),
apellido VARCHAR(50),
activo boolean);

select * from usuarios;

INSERT INTO usuarios(email, password, nombre, apellido, activo) VALUES
("usuario1@prueba.com", "!Usuario1234", "Test", "Usuario", true);

*/