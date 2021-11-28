insert into addresses(id,city,latitude,longitude,street,state) values (1,'Novi Sad',
4893095,984383098,'Bul cara lazara 14','Srbija');
insert into addresses(id,city,latitude,longitude,street,state) values (2,'Beograd',
4893095,984383098,'Savski most 14','Srbija');
insert into addresses(id,city,latitude,longitude,street,state) values (3,'Beograd',
4893095,984383098,'Dunavski kamp 14','Srbija');
insert into addresses(id,city,latitude,longitude,street,state) values (4,'Novi Sad',
4893095,984383098,'Bul Despota Stefana 134','Srbija');


insert into boats(id,address_id,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(1,1,'Ovo je brod velicine titanika','Brod brodic','dve pecakljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address_id,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(2,1,'Ovo je brod broj 2','Brod Brkina Marina','dve pecakljke i mamci',
15,56,333,'nista','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address_id,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(3,2,'Odlican za zurke.','Brod 3','Nista,ne treba vam',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address_id,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(4,3,'Ovo je brod velicine titanika','Brod brodic','dve pecakljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address_id,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(5,4,'Ovo je brod velicine titanika','Brod brodic','dve pecakljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');insert into boats(id,address_id,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(7,1,'Ovo je brod velicine titanika','Brod brodic','dve pecakljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');
insert into boats(id,address_id,description, name
,additional_fishing_equipment,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,type) values
(6,1,'Ovo je brod velicine titanika','Brod brodic','dve pecakljke i mamci',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj');


insert into cottages(id,description,name,address_id,rules,capacity) values (1,'U srcu Zlatiborskih suma,daleko od gradske buke,ova vikendica je pravi raj za odmor sa porodicom.','Planinske kuce Elizabeta',1,'Unapred se daje 100e depozita koji se vraca u slucaju da je sav inventar po izlasku gostiju u redu.',17);
insert into cottages(id,description,name,address_id,rules,capacity) values (2,'Vikendica odlicna za odmor od gradske buke','Vikendica Sumski raj',2,'Depozit 45e.',100);
insert into cottages(id,description,name,address_id,rules,capacity) values (3,'Vikendica za odmor za dusu','Vikendica RTANJ',3,'Depozit u dogovoru sa gazdom licno.',2);


insert into users(id,address_id,name,surname,role,email,password,phone_number) values
(1,1,'Jovana','Jakovljevic','FishingInstructor','jovana@gmail.com','jovana','094340909');
insert into users(id,address_id,name,surname,role,email,password,phone_number) values
(2,1,'Lela','Kocic','FishingInstructor','lelak@gmail.com','lela','094340909');
insert into users(id,address_id,name,surname,role,email,password,phone_number) values
(3,1,'Goran','Milankovic','FishingInstructor','goranm@gmail.com','goran','094340909');
insert into fishing_instructor_classes(id,description,name,address_id,rules,capacity,instructor_biography,fishing_instructor_id)
values (1,'Bojan ima preko 10 godina iskustva u pecanju i sa njim ce vam pecanje postati prava carolija',
'Pecajte s Bojanom',1,'Sesija sa Bojanom traje tacno 2 sata.Sve dodatno se dodatno naplacuje po specijalnoj tarifi.',17,'Bojan je iskusni pecaros.',1);
insert into fishing_instructor_classes(id,description,name,address_id,rules,capacity,instructor_biography,fishing_instructor_id)
values (2,'Lela ima preko 30 godina iskustva u pecanju i iako je zena to je njena dugogodisnja strast.',
'Pecaroske avanture sa Lelom',1,'Sve po dogovoru.',46,'Lela je iskusni pecaros.',2);
insert into fishing_instructor_classes(id,description,name,address_id,rules,capacity,instructor_biography,fishing_instructor_id)
values (3,'Goran obozava da peca i preko 30 godina iskustva ga cini odlicnim mentorom.',
'Goran casovi pecanja',1,'Sve po dogovoru.',46,'Nista dodatno za napomenuti.',3);