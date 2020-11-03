-- -----------------------------------------------------
-- Table `VI_TIPOITEM`
-- -----------------------------------------------------
create table equipo(
    id serial primary key,
	laboratorioID varchar(10),
	activo boolean not null,
	nombre varchar(20) not null);



CREATE TABLE IF NO EXISTS 'ELEMENTO'(
    id int(11) NOT NULL,
    tipo VARCHAR (50) NOT NULL,
    equipo VARCHAR (50) NOT NULL,
    marca VARCHAR (50) NOT NULL,
    nombre VARCHAR (50) NOT NULL,
    activo BOOLEAN (50) NOT NULL);


CREATE TABLE IF NO EXISTS 'NOVEDAD'(
    id int (10) NOT NOT NULL,
	elementoID integer,
	equipoID integer,
	fecha DATE not null,
	titulo varchar(200) not null,
	usuarioID varchar(50) not null,
	detalle varchar(500)not null,
);

create table usuario(
    username varchar(50) primary key,
	estado varchar(10) not null,
	rol varchar(20) not null,
	correo varchar(100) not null,
	nombreCompleto varchar(100) not null ,
	contrasena varchar(254) not null);

create table laboratorio
	(id varchar(10) primary key,
	nombre varchar(30) not null,
	descripcion varchar(500) not null,
	capacidadequipos integer not null,
	activo boolean not null);