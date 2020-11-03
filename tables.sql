/* tablas "elementos*/

create table Laboratorio (
	id int,
	nombre varchar,
	descripcion varchar,
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
	rol varchar,
	PRIMARY KEY (correo));
	
/* tablas "reporte"*/

create table Reporte (
	id int, 
	descripcion varchar,
	usuario varchar,
	PRIMARY KEY (id),
	FOREIGN KEY (usuario) REFERENCES usuario(correo));

create table Novedad (
	id int, 
	descripcion varchar,
	usuario varchar,
	PRIMARY KEY (id),
	FOREIGN KEY (usuario) REFERENCES usuario(correo));

/* tablas uniones Reportes*/

create table Reporte_Equipo (
	id_Reporte int, 
	id_Equipo int,
	CONSTRAINT PK_Reporte_Equipo PRIMARY KEY (id_Reporte,id_Equipo),
	FOREIGN KEY (id_Reporte) REFERENCES Reporte(id),
	FOREIGN KEY (id_Equipo) REFERENCES Equipo(id));

create table Reporte_Laboratorio (
	id_Reporte int, 
	id_Laboratorio int,
	CONSTRAINT PK_Reporte_Laboratorio PRIMARY KEY (id_Reporte,id_Laboratorio),
	FOREIGN KEY (id_Reporte) REFERENCES Reporte(id),
	FOREIGN KEY (id_Laboratorio) REFERENCES laboratorio(id));

create table Reporte_Elemento (
	id_Reporte int, 
	id_Elemento int,
	CONSTRAINT PK_Reporte_Elemento PRIMARY KEY (id_Reporte,id_Elemento),
	FOREIGN KEY (id_Reporte) REFERENCES Reporte(id),
	FOREIGN KEY (id_Elemento) REFERENCES elemento(id));

/* tablas uniones Novedades*/

create table Novedad_Equipo (
	id_Novedad int, 
	id_Equipo int,
	CONSTRAINT PK_Novedad_Equipo PRIMARY KEY (id_Novedad,id_Equipo),
	FOREIGN KEY (id_Novedad) REFERENCES novedad(id),
	FOREIGN KEY (id_Equipo) REFERENCES Equipo(id));

create table Novedad_Laboratorio (
	id_Novedad int, 
	id_Laboratorio int,
	CONSTRAINT PK_Novedad_Laboratorio PRIMARY KEY (id_Novedad,id_Laboratorio),
	FOREIGN KEY (id_Novedad) REFERENCES novedad(id),
	FOREIGN KEY (id_Laboratorio) REFERENCES laboratorio(id));

create table Novedad_Elemento (
	id_Novedad int, 
	id_Elemento int,
	CONSTRAINT PK_Novedad_Elemento PRIMARY KEY (id_Novedad,id_Elemento),
	FOREIGN KEY (id_Novedad) REFERENCES novedad(id),
	FOREIGN KEY (id_Elemento) REFERENCES elemento(id));




