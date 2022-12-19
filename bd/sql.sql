create database BD_LCV;

use BD_LCV;

create table tb_club(
	cod_club int primary key auto_increment,
	nombre_club varchar(25)
)


create table tb_posicion(
	cod_posicion int primary key auto_increment,
	nom_posicion varchar(25)
)

create table tb_jugador(
	cod_jugador int primary key auto_increment,
	nombre_jugador varchar(25),
	ape_jugador varchar(25),
	dni_jugador INT,
	sueldo double,
	cod_club int,
	cod_posicion int
)


alter table tb_jugador add constraint fk_jugador_club foreign key (cod_club) references tb_club(cod_club);
alter table tb_jugador add constraint fk_jugador_posicion foreign key (cod_posicion) references tb_posicion(cod_posicion);


insert into tb_club (nombre_club) values ('Universitario');
insert into tb_club (nombre_club) values ('Alianza Lima');
insert into tb_club (nombre_club) values ('Cristal');

select * from tb_club;

insert into tb_posicion (nom_posicion) values ('Delantero');
insert into tb_posicion (nom_posicion) values ('Arquero');
insert into tb_posicion (nom_posicion) values ('Defensa');

select * from tb_posicion;

insert into tb_jugador (nombre_jugador,ape_jugador,dni_jugador,
sueldo,cod_club,cod_posicion)
values('Pedro','Perez',15458599,3000,1,1);

insert into tb_jugador (nombre_jugador,ape_jugador,dni_jugador,
sueldo,cod_club,cod_posicion)
values('Luis','Chavez',15427499,2000,2,2);

insert into tb_jugador (nombre_jugador,ape_jugador,dni_jugador,
sueldo,cod_club,cod_posicion)
values('Juan','Saldivar',15436799,1000,3,3);


select j.cod_jugador ,j.nombre_jugador,
j.ape_jugador ,j.dni_jugador ,j.sueldo,
tc.nombre_club , tp.nom_posicion
from tb_jugador j 
inner join tb_club tc on j.cod_club =tc.cod_club inner join tb_posicion tp on j.cod_posicion = tp.cod_posicion


