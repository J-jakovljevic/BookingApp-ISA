insert into authority(id, name) values (1, 'ROLE_CLIENT');
insert into authority(id, name) values (2, 'ROLE_FISHINGINSTRUCTOR');
insert into authority(id, name) values (3, 'ROLE_BOATOWNER');
insert into authority(id, name) values (4, 'ROLE_COTTAGEOWNER');
insert into authority(id, name) values (5, 'ROLE_SYSTEMADMIN');

insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(1,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Zikina sarenica',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(2,'Bul Cara Lazara 2,Novi Sad','Ovo je brod broj 2','Omnia',
15,56,333,'nista','342w','ldkkff','dflkdfkfd','djjfdfj','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(3,'Bul Cara Lazara 17, Beograd','Odlican za zurke.','Amadeus specialicus',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(4,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Titanic',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(5,'Trg Slobode 2,Kragujevac','Ovo je brod velicine titanika','Jena',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(7,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Layla',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(6,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Astoria linguaria',
15,56,333,'nista,samo karta pa se snalaziii','342w','ldkkff','dflkdfkfd','djjfdfj','Boat');


insert into cottages(id,description,name,address,rules,capacity,type) values (7,'U srcu Zlatiborskih suma,daleko od gradske buke,ova vikendica je pravi raj za odmor sa porodicom.','Planinske kuce Elizabeta','Bul Cara Lazara 2,Novi Sad','Unapred se daje 100e depozita koji se vraca u slucaju da je sav inventar po izlasku gostiju u redu.',17,'Cottage');
insert into cottages(id,description,name,address,rules,capacity,type) values (8,'Vikendica odlicna za odmor od gradske buke','Vikendica Sumski raj','Bul Cara Lazara 2,Novi Sad','Depozit 45e.',100,'Cottage');
insert into cottages(id,description,name,address,rules,capacity,type) values (9,'Vikendica za odmor za dusu','Vikendica RTANJ','Bul Cara Lazara 2,Novi Sad','Depozit u dogovoru sa gazdom licno.',2,'Cottage');

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
(5,'Bul Cara Lazara 2,Beograd','Irina','Djordjevic','Client','jovanajako@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'irina');
insert into users(id,address,name,surname,role,email,password,phone_number,enabled,username) values
(6,'Bul Cara Lazara 2,Pristina','Maksim','Lalic','BoatOwner','lelak@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'maksim');
insert into users(id,address,name,surname,role,email,password,phone_number,enabled,username) values
(7,'Bul Cara Lazara 2,Cuprija','Anastasija','Milankovic','CottageOwner','anas@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true,'anastasija');


insert into fishing_instructor_classes(id,description,name,address,rules,capacity,instructor_biography,fishing_instructor_id,type)
values (10,'Bojan ima preko 10 godina iskustva u pecanju i sa njim ce vam pecanje postati prava carolija',
'Pecajte s Bojanom','Konstantina Konstantinovica 221,Novi Sad','Sesija sa Bojanom traje tacno 2 sata.Sve dodatno se dodatno naplacuje po specijalnoj tarifi.',17,'Bojan je iskusni pecaros.',1,
'FishingInstructorClass');
insert into fishing_instructor_classes(id,description,name,address,rules,capacity,instructor_biography,fishing_instructor_id,type)
values (11,'Lela ima preko 30 godina iskustva u pecanju i iako je zena to je njena dugogodisnja strast.',
'Pecaroske avanture sa Lelom','Bul Cara Lazara 2,Novi Sad','Sve po dogovoru.',46,'Lela je iskusni pecaros.',2,
'FishingInstructorClass');
insert into fishing_instructor_classes(id,description,name,address,rules,capacity,instructor_biography,fishing_instructor_id,type)
values (12,'Goran obozava da peca i preko 30 godina iskustva ga cini odlicnim mentorom.',
'Goran casovi pecanja','Bul Cara Lazara 2,Novi Sad','Sve po dogovoru.',46,'Nista dodatno za napomenuti.',3,
'FishingInstructorClass');


insert into user_authority(user_id,authority_id) values (1,2);
insert into user_authority(user_id,authority_id) values (2,2);
insert into user_authority(user_id,authority_id) values (3,2);
insert into user_authority(user_id,authority_id) values (4,1);
insert into user_authority(user_id,authority_id) values (5,1);
insert into user_authority(user_id,authority_id) values (6,3);
insert into user_authority(user_id,authority_id) values (7,4);

insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (1,1,'2022-06-05 10:00:00','2021-06-05 10:00:00',23453,true);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (2,11,'2021-06-05 10:00:00','2021-06-05 10:00:00',23453,true);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (3,12,'2021-06-05 10:00:00','2021-06-05 10:00:00',23453,true);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (4,5,'2021-06-05 10:00:00','2021-06-10 10:00:00',23453,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (5,5,'2021-06-12 10:00:00','2021-06-20 10:00:00',25585,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (6,5,'2021-12-22 10:00:00','2021-06-20 10:00:00',25585,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (7,7,'2021-12-22 10:00:00','2021-06-20 10:00:00',25585,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (8,8,'2021-12-22 10:00:00','2021-06-20 10:00:00',25585,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (9,9,'2021-12-22 10:00:00','2021-06-20 10:00:00',25585,false);

insert into quick_reservations(id,action_id,client_id) values (1,1,5);
insert into quick_reservations(id,action_id,client_id) values (2,2,5);
insert into quick_reservations(id,action_id,client_id) values (3,3,5);
insert into quick_reservations(id,action_id,client_id) values (4,6,5);
insert into quick_reservations(id,action_id,client_id) values (5,7,5);
insert into quick_reservations(id,action_id,client_id) values (6,8,5);
insert into quick_reservations(id,action_id,client_id) values (7,9,5);

insert into subscriptions(id,client_id,renting_item_id) values (1,5,3);
insert into subscriptions(id,client_id,renting_item_id) values (2,5,4);
insert into subscriptions(id,client_id,renting_item_id) values (3,4,3);

insert into penalties(id,quick_reservation_id) values (1,1);
insert into penalties(id,quick_reservation_id) values (2,2);
insert into penalties(id,quick_reservation_id) values (3,3);
insert into penalties(id,quick_reservation_id) values (4,4);

insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (1,'2021-12-22 10:00:00','2021-12-27 10:00:00',1,4332);
insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (2,'2022-01-10 10:00:00','2022-02-20 10:00:00',2,4332);
insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (3,'2021-12-01 10:00:00','2021-12-31 10:00:00',3,4929);
insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (4,'2022-05-01 10:00:00','2022-12-31 10:00:00',7,10230);
insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (5,'2022-08-01 10:00:00','2022-12-31 10:00:00',8,10230);

insert into additional_services(id,description,renting_item_id) values (1,'dve pecaljke i mamci',1);
insert into additional_services(id,description,renting_item_id) values (2,'spasilacka oprema',1);
insert into additional_services(id,description,renting_item_id) values (3,'navigator',1);
insert into additional_services(id,description,renting_item_id) values (4,'nocna svetla',2);
insert into additional_services(id,description,renting_item_id) values (5,'navigator',2);
insert into additional_services(id,description,renting_item_id) values (6,'navigator',4);
insert into additional_services(id,description,renting_item_id) values (7,'navigator',5);