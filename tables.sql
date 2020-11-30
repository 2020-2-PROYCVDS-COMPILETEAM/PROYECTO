/* tablas "elementos*/

create table Laboratorio (
	id int,
	nombre varchar,
	descripcion varchar,
	capacidadEquipos int,
	activo boolean,
	PRIMARY KEY (id));

create table Equipo (
	id int,
	nombre varchar,
	descripcion varchar,
	laboratorio int,
	activo boolean,
	PRIMARY KEY (id),
	FOREIGN KEY (laboratorio) REFERENCES Laboratorio(id));

create table Elemento (
	id int,
	nombre varchar,
	descripcion varchar,
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

create table Novedad_Equipo (
	id int,
	id_Equipo int,
	descripcion varchar,
	usuario varchar,
	PRIMARY KEY (id),
	FOREIGN KEY (usuario) REFERENCES usuario(correo),
	FOREIGN KEY (id_Equipo) REFERENCES Equipo(id));

create table Novedad_Elemento (
	id int,
	id_Elemento int,
	descripcion varchar,
	usuario varchar,
	PRIMARY KEY (id),
	FOREIGN KEY (usuario) REFERENCES usuario(correo),
	FOREIGN KEY (id_Elemento) REFERENCES elemento(id));

--laboratorio
INSERT INTO laboratorio
(id, nombre, descripcion, activo)
VALUES(0, 'lab de prueba', 'este es una lab para probar', true);


-- equipo
INSERT INTO equipo
(id, nombre, descripcion, laboratorio, activo)
VALUES(0, 'equipo de prueba', 'este es un equipo de prueba', 0, true);


-- elemento
INSERT INTO elemento
(id, nombre, descripcion, marca, equipo)
VALUES(0, 'elemento prueba', 'este es un elemento de prueba', 'prueba', 0);

-- usuario
INSERT INTO usuario
(correo, contraseña, username, nombre)
VALUES('prueba', 'prueba', 'prueba', 'prueba');

--novedad elemento
INSERT INTO novedad_elemento
(id, id_elemento, descripcion, usuario)
VALUES(0, 0, 'una novedad de prueba', 'prueba');

--novedad equipo
INSERT INTO novedad_equipo
(id, id_equipo, descripcion, usuario)
VALUES(0, 0, 'una novedad de prueba', 'prueba');


drop  table elemento  ;
drop  table equipo ;
drop  table laboratorio ;
drop table novedad_elemento ;
drop table novedad_equipo ;
drop table usuario ;


