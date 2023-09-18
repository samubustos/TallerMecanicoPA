CREATE DATABASE IF NOT EXISTS tallermecanico;

\c tallermecanico

create table IF NOT EXISTS marca (
    id serial NOT NULL,
    nombre text UNIQUE,
    estado boolean,
    CONSTRAINT pk_id_marca PRIMARY KEY (id),
    CONSTRAINT uk_marca_nombre UNIQUE (nombre)  
);

create table IF NOT EXISTS modelo(
    id serial NOT NULL,
    nombre text,
    estado boolean,
    marca integer,
    anio integer,
    CONSTRAINT pk_id_modelo PRIMARY KEY (id),
    CONSTRAINT fk_modelo_marca FOREIGN KEY (marca) REFERENCES marca (id) ON DELETE CASCADE
);

create table IF NOT EXISTS vehiculo(
    id serial NOT NULL,
    marca integer,
    modelo integer,
    patente text UNIQUE,
    estado boolean,
    CONSTRAINT pk_id_vehiculo PRIMARY KEY (id),
    CONSTRAINT fk_vehiculo_marca FOREIGN KEY (marca) REFERENCES marca (id) ON DELETE CASCADE,
    CONSTRAINT fk_vehiculo_modelo FOREIGN KEY (modelo) REFERENCES modelo (id) ON DELETE CASCADE,
    CONSTRAINT uk_vehiculo_patente UNIQUE (patente)
);

create table IF NOT EXISTS tecnico(
    id serial NOT NULL,
    nombre text,
    apellido text,
    telefono text,
    estado boolean,
    dni text,
    CONSTRAINT pk_id_tecnico PRIMARY KEY (id),
    CONSTRAINT uk_tecnico_dni UNIQUE (dni)
);

create table IF NOT EXISTS cliente(
    id serial NOT NULL,
    nombre text,
    apellido text,
    telefono text,
    estado boolean,
    dni text,
    CONSTRAINT pk_id_cliente PRIMARY KEY (id),
    CONSTRAINT uk_cliente_dni UNIQUE (dni)
);