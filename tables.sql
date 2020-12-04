/* tablas "elementos*/

create table Laboratorio (
	id int,
	nombre varchar,
	descripcion varchar,
	capacidadEquipos int,
	activo boolean,
	PRIMARY KEY (id));

create table Equipo (
	id serial,
	nombre varchar,
	descripcion varchar,
	laboratorio int,
	activo boolean,
	PRIMARY KEY (id),
	FOREIGN KEY (laboratorio) REFERENCES Laboratorio(id));

create table Elemento (
	id serial,
	tipo varchar ,
	nombre varchar,
    activo boolean,
	marca varchar,
	Equipo int,
	PRIMARY KEY (id),
	FOREIGN KEY (Equipo) REFERENCES Equipo(id));

create table usuario (
	correo varchar,
	contraseña varchar,
	username varchar,
	nombre varchar,
	PRIMARY KEY (correo));

/* tablas "novedad*/

create table Novedad(
	id serial,
	id_elemento int,
	id_Equipo int,
	usuario varchar,
	fecha DATE ,
	detalles VARCHAR ,
	nombre varchar ,
	PRIMARY KEY (id),
	--FOREIGN KEY (usuario) REFERENCES usuario(correo),
	FOREIGN KEY (id_Equipo) REFERENCES Equipo(id),
	FOREIGN KEY (id_elemento) REFERENCES Elemento(id));

--laboratorio
INSERT INTO laboratorio
(id, nombre, descripcion, activo)
VALUES(0, 'lab de prueba', 'este es una lab para probar', true);


-- equipo
--INSERT INTO equipo
--(id, nombre, descripcion, laboratorio, activo)
--VALUES(0, 'equipo de prueba', 'este es un equipo de prueba', 0, true);




-- usuario
--INSERT INTO usuario
--(correo, contraseña, username, nombre)
--VALUES('prueba', 'prueba', 'prueba', 'prueba');

insert into novedad(id, id_elemento, id_Equipo, usuario, fecha, detalles, nombre)
values (1,1,1,null,TO_DATE('04/01/2020','DD/MM/YYYY'),'se cago el teclado', 'teclado roto');



drop  table elemento  ;
drop  table equipo ;
drop  table laboratorio ;
drop table usuario ;
drop table Novedad;

