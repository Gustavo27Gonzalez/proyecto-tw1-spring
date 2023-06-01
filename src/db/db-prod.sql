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

CREATE TABLE excursiones(
id_excursion INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(50),
fecha date,
precio double,
cupo int,
descripcion varchar(250));

select * from excursiones;

insert into excursiones(nombre, fecha, precio, cupo, descripcion) values
("Los mejores viñedos", '2023-12-06', 30000.0, 12, "Recorrido por los mejores viñedos de... Mendozaaaaaaaa"),
("Treking en el cero Catedral", '2023-01-07', 50000.0, 8, "Treking por el cerro...qué más querés que te diga?"),
("Escapada partido de la costa", '2023-12-10', 25000.0, 4, "Tour de 6 días por Villa Gesell, Mar de las Pampas, Mar del Plata y Pinamar");

drop table excursiones;

*/