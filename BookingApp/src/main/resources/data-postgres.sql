insert into authority(id, name) values (1, 'ROLE_CLIENT');
insert into authority(id, name) values (2, 'ROLE_FISHINGINSTRUCTOR');
insert into authority(id, name) values (3, 'ROLE_BOATOWNER');
insert into authority(id, name) values (4, 'ROLE_COTTAGEOWNER');
insert into authority(id, name) values (5, 'ROLE_SYSTEMADMIN');

insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(1,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Zikina sarenica',
15,56,333,'nista,samo karta pa se snalaziii','342w','30% depozita u slucaju otkaza ide gazdi.','Samo pravila prilikom otkaza.','Jedrilica','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(2,'Bul Cara Lazara 2,Novi Sad','Ovo je brod broj 2','Omnia',
15,56,333,'nista','342w','10% depozita u slucaju otkaza ide gazdi.','Nema zurki.','Jahta','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(3,'Bul Cara Lazara 17, Beograd','Odlican za zurke.','Amadeus specialicus',
15,56,333,'nista,samo karta pa se snalaziii','342w','Mora se otkazati najmanje 10 dana unapred,inace 10% depozita u ide gazdi.','Samo pravila prilikom otkaza.','Jedrilica','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(4,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Titanic',
15,56,333,'nista,samo karta pa se snalaziii','342w','30% depozita u slucaju otkaza ide gazdi.','Samo pravila prilikom otkaza.','Jedrilica','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(5,'Trg Slobode 2,Kragujevac','Ovo je brod velicine titanika','Jena',
15,56,333,'nista,samo karta pa se snalaziii','342w','30% depozita u slucaju otkaza ide gazdi.','Nosivost broda je max 20 osoba.','Jahta','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(15,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Layla',
15,56,333,'nista,samo karta pa se snalaziii','342w','Ukoliko se otkaze 14 dana pre rezervacije,nema zadrzavanja depozita.','Ukoliko je planirana proslava na brodu,iznajmljivac snosi sve troskove bilo kakve stete.','Jahta','Boat');
insert into boats(id,address,description, name,capacity,length,max_speed
,navigation_equipment,engine_number,cancellation_terms,rules,boat_type,type) values
(6,'Bul Cara Lazara 2,Novi Sad','Ovo je brod velicine titanika','Astoria linguaria',
15,56,333,'nista,samo karta pa se snalaziii','342w','30% depozita u slucaju otkaza ide gazdi.','Brod je iskljucivo namenjen za mirna porodicna putovanja.','Jedrilica','Boat');


--svi passwordi su 123, 10 rundi
insert into users(id,address,name,surname,role,email,password,phone_number,enabled) values
(1,'Bul Cara Lazara 2,Novi Sad','Vuk','Kesic','SystemAdmin','admin','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true);
insert into users(id,address,name,surname,role,email,password,phone_number,enabled) values
(2,'Bul Cara Lazara 2,Novi Sad','Lela','Kocic','FishingInstructor','lelak@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true);
insert into users(id,address,name,surname,role,email,password,phone_number,enabled) values
(3,'Bul Cara Lazara 2,Novi Sad','Goran','Milankovic','FishingInstructor','goranm@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true);
insert into users(id,address,name,surname,role,email,password,phone_number,enabled) values
(4,'Bul Cara Lazara 2,Novi Sad','Gordana','Ninkovic','Client','gordananik@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true);
insert into users(id,address,name,surname,role,email,password,phone_number,enabled) values
(5,'Bul Cara Lazara 2,Beograd','Jovana','Jakovljevic','Client','jovanajako@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true);
insert into users(id,address,name,surname,role,email,password,phone_number,enabled) values
(6,'Bul Cara Lazara 2,Pristina','Milos','Milic','BoatOwner','losmi@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true);
insert into users(id,address,name,surname,role,email,password,phone_number,enabled) values
(7,'Bul Cara Lazara 2,Cuprija','Anastasija','Milankovic','CottageOwner','anas@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true);
insert into users(id,address,name,surname,role,email,password,phone_number,enabled) values
(8,'Bul Cara Lazara 5,Novi Sad','Sasa','Matic','CottageOwner','sasa@gmail.com','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','094340909',true);


insert into cottages(id,description,name,address,rules,capacity,cottage_owner_id,type) values (7,'U srcu Zlatiborskih suma,daleko od gradske buke,ova vikendica je pravi raj za odmor sa porodicom.','Planinske kuce Elizabeta','Njegosevih Brigada,Zlatibor','Unapred se daje 100e depozita koji se vraca u slucaju da je sav inventar po izlasku gostiju u redu.',17,7,'Cottage');
insert into cottages(id,description,name,address,rules,capacity,cottage_owner_id,type) values (8,'Vikendica odlicna za odmor od gradske buke','Vikendica Sumski raj','Bul Despota Stefana 4,Beograd','Depozit 45e.',100,7,'Cottage');
insert into cottages(id,description,name,address,rules,capacity,cottage_owner_id,type) values (9,'Vikendica za odmor za dusu','Vikendica RTANJ','Bul Cara Lazara 5,Novi Sad','Depozit u dogovoru sa gazdom licno.',2,8,'Cottage');

insert into fishing_instructor_classes(id,description,name,address,rules,capacity,instructor_biography,fishing_instructor_id,type)
values (10,'Bojan ima preko 10 godina iskustva u pecanju i sa njim ce vam pecanje postati prava carolija',
'Pecajte s Bojanom','Konstantina Konstantinovica 221,Novi Sad','Sesija sa Bojanom traje tacno 2 sata.Sve dodatno se dodatno naplacuje po specijalnoj tarifi.',17,'Bojan je iskusni pecaros.',2,
'FishingInstructorClass');
insert into fishing_instructor_classes(id,description,name,address,rules,capacity,instructor_biography,fishing_instructor_id,type)
values (11,'Lela ima preko 30 godina iskustva u pecanju i iako je zena to je njena dugogodisnja strast.',
'Pecaroske avanture sa Lelom','Bul Cara Lazara 2,Novi Sad','Sve po dogovoru.',46,'Lela je iskusni pecaros.',2,
'FishingInstructorClass');
insert into fishing_instructor_classes(id,description,name,address,rules,capacity,instructor_biography,fishing_instructor_id,type)
values (12,'Goran obozava da peca i preko 30 godina iskustva ga cini odlicnim mentorom.',
'Goran casovi pecanja','Bul Cara Lazara 2,Novi Sad','Sve po dogovoru.',46,'Nista dodatno za napomenuti.',3,
'FishingInstructorClass');


insert into user_authority(user_id,authority_id) values (1,5);
insert into user_authority(user_id,authority_id) values (2,2);
insert into user_authority(user_id,authority_id) values (3,2);
insert into user_authority(user_id,authority_id) values (4,1);
insert into user_authority(user_id,authority_id) values (5,1);
insert into user_authority(user_id,authority_id) values (6,3);
insert into user_authority(user_id,authority_id) values (7,4);



insert into subscriptions(id,client_id,renting_item_id) values (1,5,3);
insert into subscriptions(id,client_id,renting_item_id) values (2,5,4);
insert into subscriptions(id,client_id,renting_item_id) values (3,4,3);

insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (1,'2021-02-22 10:00:00','2022-02-27 10:00:00',1,4332);
insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (2,'2021-12-10 10:00:00','2022-12-31 10:00:00',2,4332);
insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (3,'2021-12-01 10:00:00','2022-12-31 10:00:00',3,4929);
insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (4,'2022-05-01 10:00:00','2022-12-31 10:00:00',7,10230);
insert into  renting_item_availability(id,start_time,end_time,renting_item_id,price) values (5,'2022-08-01 10:00:00','2022-12-31 10:00:00',8,10230);

insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (1,1,'2021-12-15 10:00:00','2021-12-24 10:00:00',234533,true);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (2,11,'2021-06-05 10:00:00','2021-06-10 10:00:00',4533,true);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (3,12,'2021-05-05 10:00:00','2021-05-25 10:00:00',453,true);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (4,5,'2021-11-25 10:00:00','2021-11-26 10:00:00',2343,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (5,5,'2021-06-12 10:00:00','2021-06-20 10:00:00',2500,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (6,5,'2021-12-22 10:00:00','2021-12-31 10:00:00',25,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (7,7,'2021-12-21 10:00:00','2021-12-30 10:00:00',255,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (8,8,'2021-12-20 10:00:00','2021-12-29 10:00:00',5445,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (9,9,'2021-12-22 10:00:00','2021-12-29 10:00:00',25385,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (10,3,'2022-02-08 10:00:00','2022-02-15 10:00:00',33939,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (11,10,'2022-02-05 10:00:00','2022-02-20 10:00:00',253,false);
insert into actions(id,renting_item_id,start_time,end_time,price,reserved) values (12,3,'2022-01-05 10:00:00','2022-02-20 10:00:00',2543,false);

insert into quick_reservations(id,action_id,client_id,cancelled) values (1,1,5,false);
insert into quick_reservations(id,action_id,client_id,cancelled) values (2,2,5,false);
insert into quick_reservations(id,action_id,client_id,cancelled) values (3,3,5,false);
insert into quick_reservations(id,action_id,client_id,cancelled) values (4,6,5,false);
insert into quick_reservations(id,action_id,client_id,cancelled) values (5,7,5,false);
insert into quick_reservations(id,action_id,client_id,cancelled) values (6,8,5,false);
insert into quick_reservations(id,action_id,client_id,cancelled) values (7,9,5,false);
insert into quick_reservations(id,action_id,client_id,cancelled) values (8,10,5,false);
insert into quick_reservations(id,action_id,client_id,cancelled) values (9,11,5,false);

insert into additional_services(id,description,renting_item_id) values (1,'dve pecaljke i mamci',1);
insert into additional_services(id,description,renting_item_id) values (2,'spasilacka oprema',1);
insert into additional_services(id,description,renting_item_id) values (3,'navigator',1);
insert into additional_services(id,description,renting_item_id) values (4,'nocna svetla',2);
insert into additional_services(id,description,renting_item_id) values (5,'kabanice i oprema za kisu',2);
insert into additional_services(id,description,renting_item_id) values (6,'cebad i posteljina',4);
insert into additional_services(id,description,renting_item_id) values (7,'kompas',5);

insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (1,6,5,'2021-12-12 10:00:00','2021-12-24 10:00:00',23,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (2,7,5,'2021-12-04 10:00:00','2021-12-20 10:00:00',2000,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (3,8,5,'2022-12-22 10:00:00','2022-12-24 10:00:00',5453,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (4,11,5,'2022-12-20 10:00:00','2022-12-24 10:00:00',1500,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (5,1,5,'2021-06-12 10:00:00','2021-06-24 10:00:00',2300,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (6,3,5,'2021-11-14 10:00:00','2021-11-21 10:00:00',2000,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (7,8,5,'2021-12-20 10:00:00','2021-12-29 10:00:00',1000,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (8,5,5,'2021-10-20 10:00:00','2021-10-24 10:00:00',2010,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (9,6,5,'2021-12-12 10:00:00','2021-12-24 10:00:00',23,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (10,10,5,'2021-02-04 10:00:00','2021-02-20 10:00:00',2000,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (11,11,5,'2022-04-03 10:00:00','2022-04-17 10:00:00',453,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (12,10,5,'2022-12-20 10:00:00','2022-12-24 10:00:00',12000,false);


insert into quick_reservation_penalties(id,quick_reservation_id) values (1,1);

insert into reservation_penalties(id,reservation_id) values (1,1);

insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(1,1,1,2.2,'Pa ono,nista spec.',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(2,3,1,5,'Odusevljen sam.Sve po dogovoru,sve preporuke svima!!',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(3,1,1,3,'NISAM ODUSEVLJEN.',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(4,2,1,4,'Sve je bilo odlicno.',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(5,1,1,3,'Onako.Kapacitet nije toliki koliko su naveli',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(6,4,1,4,'Pa sta znam.Nije lose ali nisam odusevljen.',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(7,1,1,3,'Okej,moze bolje',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(8,6,1,4,'Super.Pozdrav za gazdu i doci cemo ponovo.',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(9,5,1,3,'Okej.',false);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(10,8,1,4,'Svaka cast!!Moja porodica i ja smo prezadovoljni i doci cemo opet.',false);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(11,7,1,5,'EXTRA!!!!!',false);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(13,9,1,4,'MA HAOSS',false);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(12,10,1,3,'Nista specijalno.Namestaj star,kreveti neudobni',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(14,11,1,4,'Prelep ambijent,odlican odmor sa porodicom!Doci cemo opet',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(15,11,1,3,'Tu i tamo.',true);
insert into revisions(id,renting_item_id,client_id,grade,description,approved) values(16,12,1,4,'Extra.',true);


insert into complaint(id,renting_item_id,sender_id,description) values (1,1,5,'Ovaj brod je bio uzasan i ako ste culi za zakon o zastiti potrosaca,bolje bi vam bilo da me kontaktirate i da se dogovorimo oko povrata novca!!!');

insert into delete_account_request(id,approved,client_id,description) values (1,false,5,'Ne svidja mi se apk i ne zelim vise da imam profil.');

insert into loyalty_program(id,points_per_reservation,silver_member_threshold,golden_member_threshold) values (1,3,10,20);