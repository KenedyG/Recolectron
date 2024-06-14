CREATE TABLE registro (
    id_user INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(25),
    apellidoP VARCHAR(25),
    apellidoM VARCHAR(25),
    correo VARCHAR(30),
    usuario CHAR(30),
    password VARCHAR(16)
);

CREATE TABLE login (
    usuario VARCHAR(30),
    password VARCHAR(16),
    id_user INT,
    FOREIGN KEY (id_user) REFERENCES registro(id_user)
);

CREATE TABLE asistencias (
    id_asistencia INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    horaentrada TIMESTAMP NOT NULL,
    horasalida TIMESTAMP NOT NULL,
    id_user INT,
    FOREIGN KEY (id_user) REFERENCES registro(id_user)
);

CREATE TABLE inventario (
    id_electronico INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100),
    modelo VARCHAR(100),
    especificaciones TEXT,
    peso INT,
    status VARCHAR(20),
    stock INT NOT NULL
);

CREATE TABLE registro_egreso (
    id_RP INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(100),
    matricula VARCHAR(10),
    materia VARCHAR(50),
    facultad VARCHAR(50),
    carrera VARCHAR(50),
    nivel_academico VARCHAR(20),
    donativoE FLOAT,
    fecha DATE,
    id_electronico INT,
    FOREIGN KEY (id_electronico) REFERENCES inventario(id_electronico)
);

CREATE TABLE donativo (
    id_donativo INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(70),
    nombreObjeto VARCHAR(20)
);

CREATE TABLE alumnos (
    id_alumno INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(20),
    materia VARCHAR(20)
);

CREATE TABLE solicitudes (
    id_solicitud INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    noequipo INT,
    fecha_solicitud TIMESTAMP NOT NULL,
    fecha_uso TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    id_alumno INT,
    FOREIGN KEY (id_alumno) REFERENCES alumnos(id_alumno)
);

-- CRUD Operations for Table: registro

-- Create
INSERT INTO registro (nombre, apellidoP, apellidoM, correo, usuario, password) VALUES ('Juan', 'Perez', 'Gomez', 'juan.perez@gmail.com', 'juanperez', 'password123');

-- Read
SELECT * FROM registro;

-- Update
UPDATE registro SET nombre = 'Juanito', correo = 'juanito.perez@gmail.com' WHERE id_user = 1;

-- Delete
DELETE FROM registro WHERE id_user = 1;


-- CRUD Operations for Table: login

-- Create
INSERT INTO login (usuario, password, id_user) VALUES ('juanperez', 'password123', 1);

-- Read
SELECT * FROM login;

-- Update
UPDATE login SET password = 'newpassword123' WHERE id_user = 1;

-- Delete
DELETE FROM login WHERE id_user = 1;


-- CRUD Operations for Table: asistencias

-- Create
INSERT INTO asistencias (horaentrada, horasalida, id_user) VALUES ('2024-06-13 09:00:00', '2024-06-13 17:00:00', 1);

-- Read
SELECT * FROM asistencias;

-- Update
UPDATE asistencias SET horasalida = '2024-06-13 18:00:00' WHERE id_asistencia = 1;

-- Delete
DELETE FROM asistencias WHERE id_asistencia = 1;


-- CRUD Operations for Table: inventario

-- Create
INSERT INTO inventario (nombre, fabricante, modelo, especificaciones, peso, status, stock) VALUES ('Laptop', 'Dell', 'Inspiron 15', '8GB RAM, 256GB SSD', 2000, 'available', 10);

-- Read
SELECT * FROM inventario;

-- Update
UPDATE inventario SET stock = 8 WHERE id_electronico = 1;

-- Delete
DELETE FROM inventario WHERE id_electronico = 1;


-- CRUD Operations for Table: registro_egreso

-- Create
INSERT INTO registro_egreso (nombre, matricula, materia, facultad, carrera, nivel_academico, donativoE, fecha, id_electronico) VALUES ('Carlos Lopez', 'A12345', 'Math', 'Science', 'Engineering', 'Bachelor', 100.0, '2024-06-13', 1);

-- Read
SELECT * FROM registro_egreso;

-- Update
UPDATE registro_egreso SET donativoE = 150.0 WHERE id_RP = 1;

-- Delete
DELETE FROM registro_egreso WHERE id_RP = 1;


-- CRUD Operations for Table: donativo

-- Create
INSERT INTO donativo (nombre, nombreObjeto) VALUES ('John Doe', 'Books');

-- Read
SELECT * FROM donativo;

-- Update
UPDATE donativo SET nombreObjeto = 'Laptops' WHERE id_donativo = 1;

-- Delete
DELETE FROM donativo WHERE id_donativo = 1;


-- CRUD Operations for Table: alumnos

-- Create
INSERT INTO alumnos (nombre, materia) VALUES ('Maria Gonzalez', 'Physics');

-- Read
SELECT * FROM alumnos;

-- Update
UPDATE alumnos SET materia = 'Chemistry' WHERE id_alumno = 1;

-- Delete
DELETE FROM alumnos WHERE id_alumno = 1;


-- CRUD Operations for Table: solicitudes

-- Create
INSERT INTO solicitudes (noequipo, fecha_solicitud, fecha_uso, status, id_alumno) VALUES (1, '2024-06-13 10:00:00', '2024-06-14 10:00:00', 'Pending', 1);

-- Read
SELECT * FROM solicitudes;

-- Update
UPDATE solicitudes SET status = 'Approved' WHERE id_solicitud = 1;

-- Delete
DELETE FROM solicitudes WHERE id_solicitud = 1;
