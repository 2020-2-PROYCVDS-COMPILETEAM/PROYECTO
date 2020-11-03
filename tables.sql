-- -----------------------------------------------------
-- Table `VI_TIPOITEM`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EQUIPO` (
  `id` INT(11) NOT NULL,
  `descripcion` VARCHAR(50)  NOT NULL);



CREATE TABLE IF NO EXISTS 'ELEMENTO'(
    id int(11) NOT NULL,
    tipo VARCHAR (50) NOT NULL,
    equipo VARCHAR (50) NOT NULL,
    marca VARCHAR (50) NOT NULL,
    nombre VARCHAR (50) NOT NULL,
    activo VARCHAR (50) NOT NULL);