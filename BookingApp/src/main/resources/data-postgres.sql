--insert into addresses(id,city,latitude,longitude,street,state) values (1,'Novi Sad',
--4893095,984383098,'Bul cara lazara 14','Srbija');
--insert into addresses(id,city,latitude,longitude,street,state) values (2,'Beograd',
--4893095,984383098,'Savski most 14','Srbija');
--insert into addresses(id,city,latitude,longitude,street,state) values (3,'Beograd',
--4893095,984383098,'Dunavski kamp 14','Srbija');
--insert into addresses(id,city,latitude,longitude,street,state) values (4,'Novi Sad',
--4893095,984383098,'Bul Despota Stefana 134','Srbija');

insert into authority(id, name) values (1, 'ROLE_CLIENT');
insert into authority(id, name) values (2, 'ROLE_FISHINGINSTRUCTOR');
insert into authority(id, name) values (3, 'ROLE_BOATOWNER');
insert into authority(id, name) values (4, 'ROLE_COTTAGEOWNER');
insert into authority(id, name) values (5, 'ROLE_SYSTEMADMIN');

insert into boats(id,address,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(1,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Brod brodic','dve pecaljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(2,'Bul Cara Lazara 2,Novi Sad','Ovo je brod broj 2','Brod Brkina Marina','dve pecakljke i mamci',
15,56,333,'nista','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(3,'Bul Cara Lazara 17, Beograd','Odlican za zurke.','Brod 3','Nista,ne treba vam',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(4,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Brod brodic','dve pecakljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(5,'Trg Slobode 2,Kragujevac','Ovo je brod velicine titanika','Brod brodic','dve pecakljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');insert into boats(id,address,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(7,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Brod brodic','dve pecakljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(6,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Brod brodic','dve pecakljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');


insert into cottages(id,description,name,address,rules,capacity) values (1,'U srcu Zlatiborskih suma,daleko od gradske buke,ova vikendica je pravi raj za odmor sa porodicom.','Planinske kuce Elizabeta','Bul Cara Lazara 2,Novi Sad','Unapred se daje 100e depozita koji se vraca u slucaju da je sav inventar po izlasku gostiju u redu.',17);
insert into cottages(id,description,name,address,rules,capacity) values (2,'Vikendica odlicna za odmor od gradske buke','Vikendica Sumski raj','Bul Cara Lazara 2,Novi Sad','Depozit 45e.',100);
insert into cottages(id,description,name,address,rules,capacity) values (3,'Vikendica za odmor za dusu','Vikendica RTANJ','Bul Cara Lazara 2,Novi Sad','Depozit u dogovoru sa gazdom licno.',2);

--svi passwordi su 123, 10 rundi
insert into users(id,address,name,surname,role,email,password,phone_number,enabled,username) values
(1,'Bul Cara Lazara 2,Novi Sad','Jovana','Jakovljevic','FishingInstructor','jovana@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'jovana');
insert into users(id,address,name,surname,role,email,password,phone_number,enabled,username) values
(2,'Bul Cara Lazara 2,Novi Sad','Lela','Kocic','FishingInstructor','lelak@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'lela');
insert into users(id,address,name,surname,role,email,password,phone_number,enabled,username) values
(3,'Bul Cara Lazara 2,Novi Sad','Goran','Milankovic','FishingInstructor','goranm@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'goran');
insert into users(id,address,name,surname,role,email,password,phone_number,enabled,username) values
(4,'Bul Cara Lazara 2,Novi Sad','Gordana','Ninkovic','Client','gordananik@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'gordana');
insert into users(id,address,name,surname,role,email,password,phone_number,enabled,username) values
(5,'Bul Cara Lazara 2,Beograd','Irina','Djordjevic','Client','irina@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'irina');
insert into users(id,address,name,surname,role,email,password,phone_number,enabled,username) values
(6,'Bul Cara Lazara 2,Pristina','Maksim','Lalic','BoatOwner','lelak@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'maksim');
insert into users(id,address,name,surname,role,email,password,phone_number,enabled,username) values
(7,'Bul Cara Lazara 2,Cuprija','Anastasija','Milankovic','CottageOwner','anas@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'anastasija');


insert into fishing_instructor_classes(id,description,name,address,rules,capacity,instructor_biography,fishing_instructor_id)
values (1,'Bojan ima preko 10 godina iskustva u pecanju i sa njim ce vam pecanje postati prava carolija',
'Pecajte s Bojanom','Konstantina Konstantinovica 221,Novi Sad','Sesija sa Bojanom traje tacno 2 sata.Sve dodatno se dodatno naplacuje po specijalnoj tarifi.',17,'Bojan je iskusni pecaros.',1);
insert into fishing_instructor_classes(id,description,name,address,rules,capacity,instructor_biography,fishing_instructor_id)
values (2,'Lela ima preko 30 godina iskustva u pecanju i iako je zena to je njena dugogodisnja strast.',
'Pecaroske avanture sa Lelom','Bul Cara Lazara 2,Novi Sad','Sve po dogovoru.',46,'Lela je iskusni pecaros.',2);
insert into fishing_instructor_classes(id,description,name,address,rules,capacity,instructor_biography,fishing_instructor_id)
values (3,'Goran obozava da peca i preko 30 godina iskustva ga cini odlicnim mentorom.',
'Goran casovi pecanja','Bul Cara Lazara 2,Novi Sad','Sve po dogovoru.',46,'Nista dodatno za napomenuti.',3);


insert into user_authority(user_id,authority_id) values (1,2);
insert into user_authority(user_id,authority_id) values (2,2);
insert into user_authority(user_id,authority_id) values (3,2);
insert into user_authority(user_id,authority_id) values (4,1);
insert into user_authority(user_id,authority_id) values (5,1);
insert into user_authority(user_id,authority_id) values (6,3);
insert into user_authority(user_id,authority_id) values (7,4);