CREATE SCHEMA IF NOT EXISTS `KOPR` DEFAULT CHARACTER SET utf8 ;
USE `KOPR` ;

CREATE TABLE `Subject` (
  `id` varchar(40) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `AttendanceList` (
  `id` varchar(40) NOT NULL,
  `idSubject` varchar(40) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idSubject_idx` (`idSubject`),
  CONSTRAINT `idSubject` FOREIGN KEY (`idSubject`) REFERENCES `Subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Student` (
  `id` varchar(40) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `StudentAttendance` (
  `idStudent` varchar(40) NOT NULL,
  `idAttendanceList` varchar(40) NOT NULL,
  KEY `idStudent` (`idStudent`),
  KEY `idAttendanceList` (`idAttendanceList`),
  CONSTRAINT `idAttendanceList` FOREIGN KEY (`idAttendanceList`) REFERENCES `AttendanceList` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idStudent` FOREIGN KEY (`idStudent`) REFERENCES `Student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO KOPR.Student(id,name,surname) VALUES ('b46eab54-17e0-11e8-8d9d-d415e74bbeda','Janko','Hrasko');
INSERT INTO KOPR.Student(id,name,surname) VALUES ('b46eab54-17e0-11e8-8d9d-d415e74bbedb','Zofka','Nova');

INSERT INTO KOPR.Subject(id,name) VALUES ('cf30abd6-17e0-11e8-8d9d-d415e74bbeda','KonkurentneProgramovanie');
INSERT INTO KOPR.Subject(id,name) VALUES ('cf30abd6-17e0-11e8-8d9d-d415e74bbedb', 'Kryptografia');
INSERT INTO KOPR.Subject(id,name) VALUES ('cf30abd6-17e0-11e8-8d9d-d415e74bbedc', 'Statistika');

INSERT INTO KOPR.AttendanceList(id,idSubject,date) VALUES 
('ef233cf6-17e0-11e8-8d9d-d415e74bbeda','cf30abd6-17e0-11e8-8d9d-d415e74bbeda','2018-02-10 06:30:00');
INSERT INTO KOPR.AttendanceList(id,idSubject,date) VALUES 
('ef233cf6-17e0-11e8-8d9d-d415e74bbedb','cf30abd6-17e0-11e8-8d9d-d415e74bbedb','2018-02-5 16:30:00');
INSERT INTO KOPR.AttendanceList(id,idSubject,date) VALUES 
('ef233cf6-17e0-11e8-8d9d-d415e74bbedc','cf30abd6-17e0-11e8-8d9d-d415e74bbedc','2018-02-12 09:30:00');
INSERT INTO KOPR.AttendanceList(id,idSubject,date) VALUES 
('ef233cf6-17e0-11e8-8d9d-d415e74bbedd','cf30abd6-17e0-11e8-8d9d-d415e74bbedc','2018-02-07 10:30:00');

INSERT INTO KOPR.StudentAttendance(idStudent,idAttendanceList) VALUES 
('b46eab54-17e0-11e8-8d9d-d415e74bbeda','ef233cf6-17e0-11e8-8d9d-d415e74bbeda');
INSERT INTO KOPR.StudentAttendance(idStudent,idAttendanceList) VALUES 
('b46eab54-17e0-11e8-8d9d-d415e74bbeda','ef233cf6-17e0-11e8-8d9d-d415e74bbedb');
INSERT INTO KOPR.StudentAttendance(idStudent,idAttendanceList) VALUES 
('b46eab54-17e0-11e8-8d9d-d415e74bbeda','ef233cf6-17e0-11e8-8d9d-d415e74bbedd');
INSERT INTO KOPR.StudentAttendance(idStudent,idAttendanceList) VALUES 
('b46eab54-17e0-11e8-8d9d-d415e74bbedb','ef233cf6-17e0-11e8-8d9d-d415e74bbeda');
INSERT INTO KOPR.StudentAttendance(idStudent,idAttendanceList) VALUES 
('b46eab54-17e0-11e8-8d9d-d415e74bbedb','ef233cf6-17e0-11e8-8d9d-d415e74bbedc');


CREATE USER 'kopr'@'localhost' IDENTIFIED BY 'koprsoap';
GRANT ALL PRIVILEGES ON KOPR.* TO 'kopr'@'localhost';





