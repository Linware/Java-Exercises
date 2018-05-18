DROP DATABASE IF EXISTS BancoEJB;
CREATE DATABASE BancoEJB;
USE BancoEJB;

CREATE TABLE Operaciones (
id_operacion INT NOT NULL AUTO_INCREMENT,
fecha_hora DATETIME,
numero_cuenta VARCHAR(20),
tipo_operacion VARCHAR(1),
cantidad double,
PRIMARY KEY (id_operacion)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO Operaciones VALUES (0,"2015-09-12 00:00:00","225353","E",-2342);
INSERT INTO Operaciones VALUES (0,"2013-09-22 00:00:00","245653","I",45675);
INSERT INTO Operaciones VALUES (0,"2065-11-15 00:00:00","227853","E",-34564);
INSERT INTO Operaciones VALUES (0,"2005-09-02 00:00:00","225111","I",22453);
INSERT INTO Operaciones VALUES (0,"2016-06-17 00:00:00","111353","E",-1345);
INSERT INTO Operaciones VALUES (0,"2015-09-12 00:00:00","225353","I",12.56);
INSERT INTO Operaciones VALUES (0,"2015-09-12 00:00:00","225353","I",800);

CREATE TABLE Propietarios (
dni VARCHAR(9),
usuario VARCHAR(64),
nombre VARCHAR(32),
primer_apellido VARCHAR(32),
segundo_apellido VARCHAR(32),
numero_secreto VARCHAR(6),
PRIMARY KEY (dni)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO Propietarios VALUES ("46352837C","MLujan","Marta","Lujan","Garcia","473625");
INSERT INTO Propietarios VALUES ("44544645F","TLujan","Tadeo","Lujan","Garcia","112225");
INSERT INTO Propietarios VALUES ("71564337C","RRodriguez","Roberto","Rodriguez","Ibanez","172225");
INSERT INTO Propietarios VALUES ("44562234G","PLujan","Pedro","Lujan","Garcia","777625");
INSERT INTO Propietarios VALUES ("76767674D","AMaton","Andrea","Maton","Alvarez","477777");

CREATE TABLE CuentasBancarias (
numero_cuenta VARCHAR(6),
propietario VARCHAR(9),
saldo DOUBLE,
PRIMARY KEY (numero_cuenta),
CONSTRAINT fkCuentasBancarias FOREIGN KEY (propietario) REFERENCES Propietarios (dni)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO CuentasBancarias VALUES ("225353","46352837C",-1422);
INSERT INTO CuentasBancarias VALUES ("111353","44562234G",2342342);
INSERT INTO CuentasBancarias VALUES ("123456","46352837C",-2342555);
INSERT INTO CuentasBancarias VALUES ("323424","76767674D",676454);
INSERT INTO CuentasBancarias VALUES ("227853","44544645F",-56757575);

CREATE TABLE Historial (
id_historico INT NOT NULL AUTO_INCREMENT,
tipo_evento VARCHAR(1),
fecha_hora DATETIME,
numero_cuenta VARCHAR(6),
PRIMARY KEY (id_historico),
CONSTRAINT fkHistorial FOREIGN KEY (numero_cuenta) REFERENCES CuentasBancarias (numero_cuenta) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO Historial VALUES (0,"E","2016-04-14 07:06:00","123456");
INSERT INTO Historial VALUES (0,"I","2014-06-17 01:00:00","323424");
INSERT INTO Historial VALUES (0,"E","2015-06-17 04:00:00","123456");
INSERT INTO Historial VALUES (0,"I","2016-05-17 00:12:00","323424");
INSERT INTO Historial VALUES (0,"I","2016-06-17 00:20:00","225353");



