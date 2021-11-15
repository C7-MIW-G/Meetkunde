-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

CREATE SCHEMA `Figuren`;
USE `Figuren`;

--
-- Tabel structuur voor tabel `Figuur`
--
CREATE TABLE `Figuur` (
  `figuurnummer` int NOT NULL AUTO_INCREMENT,
  `kleur` varchar(45) NOT NULL,
  PRIMARY KEY (`figuurnummer`)
) ;
--
-- Tabel structuur voor tabel `Cirkel`
--
CREATE TABLE `Cirkel` (
  `figuurnummer` int NOT NULL,
  `straal` decimal(6,2) NOT NULL,
  `xcoordinaat` decimal(6,2) NOT NULL,
  `ycoordinaat` decimal(6,2) NOT NULL,
  PRIMARY KEY (`figuurnummer`),
  KEY `fk_Cirkel_Figuur_idx` (`figuurnummer`),
  CONSTRAINT `fk_Cirkel_Figuur` FOREIGN KEY (`figuurnummer`) REFERENCES `Figuur` (`figuurnummer`)
) ;
--
-- Tabel structuur voor tabel `Rechthoek`
--
CREATE TABLE `Rechthoek` (
  `figuurnummer` int NOT NULL,
  `lengte` decimal(6,2) NOT NULL,
  `breedte` decimal(6,2) NOT NULL,
  `xcoordinaat` decimal(6,2) NOT NULL,
  `ycoordinaat` decimal(6,2) NOT NULL,
  PRIMARY KEY (`figuurnummer`),
  KEY `fk_Rechthoek_Figuur_idx` (`figuurnummer`),
  CONSTRAINT `fk_Rechthoek_Figuur` FOREIGN KEY (`figuurnummer`) REFERENCES `Figuur` (`figuurnummer`)
) ;
--
-- Tabel structuur voor tabel `Punt`
--
CREATE TABLE `Punt` (
  `xcoordinaat` decimal(6,2) NOT NULL,
  `ycoordinaat` decimal(6,2) NOT NULL,
  PRIMARY KEY (`xcoordinaat`, `ycoordinaat`)
);

insert into figuur(kleur) values ('groen');
insert into figuur(kleur) values ('grijs');
insert into figuur(kleur) values ('geel');
insert into figuur(kleur) values ('rood');
insert into figuur(kleur) values ('zwart');
insert into figuur(kleur) values ('blauw');
insert into figuur(kleur) values ('paars');

insert into cirkel values (1, 5, 3, 4);
insert into cirkel values (2, 6, 5, -4);
insert into cirkel values (3, 3.5, 2.7, -4.5);
insert into cirkel values (4, 5.85, 3.23, 4.34);

insert into rechthoek values (5, 5, 4, 3, 4);
insert into rechthoek values (6, 6, 2, 5, -4);
insert into rechthoek values (7, 3.5, 2.6, 2.7, -4.5);

insert into punt values (0, 0);
insert into punt values (2, 1);
insert into punt values (-1, -2);

CREATE USER 'userFiguren'@'localhost' IDENTIFIED BY 'userFigurenPW';
GRANT ALL PRIVILEGES ON Figuren . * TO 'userFiguren'@'localhost';