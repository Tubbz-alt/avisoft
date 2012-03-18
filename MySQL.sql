
CREATE TABLE empresa (
                NIT CHAR(15) NOT NULL,
                razon_social VARCHAR(150) NOT NULL,
                telefono CHAR(10) NOT NULL,
                direccion VARCHAR(255) NOT NULL,
                PRIMARY KEY (NIT)
);


CREATE TABLE insumo (
                id INT AUTO_INCREMENT NOT NULL,
                nombre VARCHAR(60) NOT NULL,
                tipo VARCHAR(32) NOT NULL,
                cantidad INT NOT NULL,
                medida CHAR(5) NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE usuario (
                nombre VARCHAR(60) NOT NULL,
                clave CHAR(64) NOT NULL,
                email VARCHAR(150) NOT NULL,
                PRIMARY KEY (nombre)
);


CREATE TABLE persona (
                cedula CHAR(12) NOT NULL,
                nombres VARCHAR(80) NOT NULL,
                apellidos VARCHAR(80) NOT NULL,
                telefono CHAR(10) NOT NULL,
                direccion VARCHAR(255) NOT NULL,
                PRIMARY KEY (cedula)
);


CREATE TABLE proveedor (
                cedula CHAR(12) NOT NULL,
                NIT CHAR(15) NOT NULL,
                PRIMARY KEY (cedula)
);


CREATE TABLE compra (
                num INT AUTO_INCREMENT NOT NULL,
                fecha DATE NOT NULL,
                total DOUBLE PRECISION NOT NULL,
                cedula CHAR(12) NOT NULL,
                PRIMARY KEY (num)
);


CREATE TABLE detalle_compra (
                num INT NOT NULL,
                id INT NOT NULL,
                cantidad INT NOT NULL,
                precio DOUBLE PRECISION NOT NULL,
                PRIMARY KEY (num, id)
);


CREATE TABLE empleado (
                cedula CHAR(12) NOT NULL,
                fecha_ing DATE NOT NULL,
                tipo_contrato VARCHAR(50) NOT NULL,
                sueldo DOUBLE PRECISION NOT NULL,
                cargo VARCHAR(150) NOT NULL,
                PRIMARY KEY (cedula)
);


CREATE TABLE departamento (
                cod INT AUTO_INCREMENT NOT NULL,
                nombre VARCHAR(150) NOT NULL,
                PRIMARY KEY (cod)
);


CREATE TABLE municipio (
                cod_mun INT AUTO_INCREMENT NOT NULL,
                cod_dep INT NOT NULL,
                nombre VARCHAR(150) NOT NULL,
                clima TINYINT NOT NULL,
                PRIMARY KEY (cod_mun, cod_dep)
);


CREATE TABLE granja (
                cod_granja INT AUTO_INCREMENT NOT NULL,
                nombre VARCHAR(150) NOT NULL,
                direccion VARCHAR(255) NOT NULL,
                area DOUBLE PRECISION NOT NULL,
                tipo CHAR NOT NULL,
                usuario VARCHAR(60) NOT NULL,
                cod_mun INT NOT NULL,
                cod_dep INT NOT NULL,
                ced_propietario CHAR(12) NOT NULL,
                tipo_1 CHAR(7) NOT NULL,
                PRIMARY KEY (cod_granja)
);


CREATE TABLE labora (
                cod_granja INT NOT NULL,
                cedula CHAR(12) NOT NULL,
                PRIMARY KEY (cod_granja, cedula)
);


CREATE TABLE galpon (
                cod_galpon INT AUTO_INCREMENT NOT NULL,
                cod_granja INT NOT NULL,
                area DOUBLE PRECISION NOT NULL,
                PRIMARY KEY (cod_galpon, cod_granja)
);


CREATE TABLE lote (
                cod_lote INT AUTO_INCREMENT NOT NULL,
                cod_granja INT NOT NULL,
                num_init INT NOT NULL,
                fecha_ing DATE NOT NULL,
                cod_galpon INT NOT NULL,
                tipo_criadoras VARCHAR(10) NOT NULL,
                tipo_bebederos VARCHAR(10) NOT NULL,
                tipo_comederos VARCHAR(10) NOT NULL,
                tipo_ventiladores VARCHAR(10) NOT NULL,
                cant_criadoras INT NOT NULL,
                cant_bebederos INT NOT NULL,
                cant_bandejas INT NOT NULL,
                cant_comederos INT NOT NULL,
                cant_ventiladores INT NOT NULL,
                cant_bombillos INT NOT NULL,
                semana VARCHAR(32) NOT NULL,
                PRIMARY KEY (cod_lote, cod_granja)
);


CREATE TABLE engorde (
                fecha_reg DATE NOT NULL,
                cod_lote INT NOT NULL,
                cod_granja INT NOT NULL,
                peso_hem DOUBLE PRECISION NOT NULL,
                peso_mac DOUBLE PRECISION NOT NULL,
                mortalidad INT NOT NULL,
                PRIMARY KEY (fecha_reg, cod_lote, cod_granja)
);


CREATE TABLE ponedor (
                fecha_reg DATE NOT NULL,
                cod_lote INT NOT NULL,
                cod_granja INT NOT NULL,
                produccion INT NOT NULL,
                mortalidad INT NOT NULL,
                PRIMARY KEY (fecha_reg, cod_lote, cod_granja)
);


CREATE TABLE recurso (
                id INT NOT NULL,
                fecha_reg DATE NOT NULL,
                cod_lote INT NOT NULL,
                cod_granja INT NOT NULL,
                cantidad DOUBLE PRECISION NOT NULL,
                PRIMARY KEY (id, fecha_reg, cod_lote, cod_granja)
);


ALTER TABLE proveedor ADD CONSTRAINT empresa_proveedor_fk
FOREIGN KEY (NIT)
REFERENCES empresa (NIT)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE detalle_compra ADD CONSTRAINT insumo_detalle_compra_fk
FOREIGN KEY (id)
REFERENCES insumo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE recurso ADD CONSTRAINT insumo_recurso_fk
FOREIGN KEY (id)
REFERENCES insumo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE granja ADD CONSTRAINT usuario_granja_fk
FOREIGN KEY (usuario)
REFERENCES usuario (nombre)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE empleado ADD CONSTRAINT persona_empleado_fk
FOREIGN KEY (cedula)
REFERENCES persona (cedula)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE proveedor ADD CONSTRAINT persona_cliente_fk
FOREIGN KEY (cedula)
REFERENCES persona (cedula)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE granja ADD CONSTRAINT persona_granja_fk
FOREIGN KEY (ced_propietario)
REFERENCES persona (cedula)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE compra ADD CONSTRAINT proveedor_compra_fk
FOREIGN KEY (cedula)
REFERENCES proveedor (cedula)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE detalle_compra ADD CONSTRAINT compra_detalle_compra_fk
FOREIGN KEY (num)
REFERENCES compra (num)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE labora ADD CONSTRAINT empleado_labora_fk
FOREIGN KEY (cedula)
REFERENCES empleado (cedula)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE municipio ADD CONSTRAINT departamento_municipio_fk
FOREIGN KEY (cod_dep)
REFERENCES departamento (cod)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE granja ADD CONSTRAINT municipio_granja_fk
FOREIGN KEY (cod_mun, cod_dep)
REFERENCES municipio (cod_mun, cod_dep)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE galpon ADD CONSTRAINT granja_galpon_fk
FOREIGN KEY (cod_granja)
REFERENCES granja (cod_granja)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE labora ADD CONSTRAINT granja_labora_fk
FOREIGN KEY (cod_granja)
REFERENCES granja (cod_granja)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE lote ADD CONSTRAINT galpon_grupo_ave_fk
FOREIGN KEY (cod_galpon, cod_granja)
REFERENCES galpon (cod_galpon, cod_granja)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE ponedor ADD CONSTRAINT lote_ponedor_fk
FOREIGN KEY (cod_lote, cod_granja)
REFERENCES lote (cod_lote, cod_granja)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE engorde ADD CONSTRAINT lote_engorde_fk
FOREIGN KEY (cod_lote, cod_granja)
REFERENCES lote (cod_lote, cod_granja)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE recurso ADD CONSTRAINT engorde_recurso_fk
FOREIGN KEY (fecha_reg, cod_lote, cod_granja)
REFERENCES engorde (fecha_reg, cod_lote, cod_granja)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE recurso ADD CONSTRAINT ponedor_recurso_fk
FOREIGN KEY (fecha_reg, cod_lote, cod_granja)
REFERENCES ponedor (fecha_reg, cod_lote, cod_granja)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
