--
-- INSERT INTO security_level (status) VALUES ('ADMIN');
-- INSERT INTO security_level (status) VALUES ('CLIENT');


INSERT INTO account (id,login,password,status,balance,email) VALUES (1,'log','pas','ADMIN',100.0,'a@r.ru');
INSERT INTO account (id,login,password,status,balance,email) VALUES (2,'log1','pas2','CLIENT',200.0,'2f@r.ru');
INSERT INTO account (id,login,password,status,balance,email) VALUES (3,'log2','pas3','BOOKMAKER',10.0,'w@r.ru');
INSERT INTO account (id,login,password,status,balance,email) VALUES (4,'log3','pas4','CLIENT',20.0,'j@r.ru');
INSERT INTO account (id,login,password,status,balance,email) VALUES (5,'log4','pas5','CLIENT',55.0,'l@r.ru');
INSERT INTO account (id,login,password,status,balance,email) VALUES (6,'log5','pas6','CLIENT',45.0,'1@r.ru');


INSERT INTO "client" (id,first_name, last_name,date,address) VALUES (1,'Fedor','Gvin','10.12.2016','les');
INSERT INTO "client" (id,first_name, last_name,date,address) VALUES (2,'Mihal','Uro','11.02.2015','hom');
INSERT INTO "client" (id,first_name, last_name,date,address) VALUES (3,'Olga','Ehova','01.05.2014','saray');
INSERT INTO "client" (id,first_name, last_name,date,address) VALUES (4,'Бобик','Шариков','12.03.2012','будка');
INSERT INTO "client" (id,first_name, last_name,date,address) VALUES (5,'Female','Masha','11.02.2015','usa');
INSERT INTO "client" (id,first_name, last_name,date,address) VALUES (6,'Male','Her','02.05.2011','ger');
-- DELETE FROM "client";


INSERT INTO command (name_command,trainer,jockey,url_image_color) VALUES ('1','jon','uri','http1');
INSERT INTO command (name_command,trainer,jockey,url_image_color) VALUES ('2','igi','mor','http2');
INSERT INTO command (name_command,trainer,jockey,url_image_color) VALUES ('3','петя','коля','http3');
INSERT INTO command (name_command,trainer,jockey,url_image_color) VALUES ('4','roa','per','http4');
INSERT INTO command (name_command,trainer,jockey,url_image_color) VALUES ('5','dor','jus','http5');
INSERT INTO command (name_command,trainer,jockey,url_image_color) VALUES ('6','ver','vuy','http6');
INSERT INTO command (name_command,trainer,jockey,url_image_color) VALUES ('7','low','qer','http7');
INSERT INTO command (name_command,trainer,jockey,url_image_color) VALUES ('8','петя1','коля1','http8');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster1',3,60,'1245','henk1');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster2',2,61,'245','henk2');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster3',2,62,'45','henk3');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster4',4,59,NULL ,'henk4');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster5',3,64,'1','henk5');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster6',2,58,'12','henk6');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster7',4,65,'34','henk7');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster8',2,64,'567','henk8');


INSERT INTO racecourse (id, name, country) VALUES (1,'germ','g');
INSERT INTO racecourse (id, name, country) VALUES (2,'usa','us');
INSERT INTO racecourse (id, name, country) VALUES (3,'angl','an');

INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.11.03','2016.10.17','1000',1);
INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.11.02','2016.10.17','1500',1);
INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.11.04','2016.10.17','1600',1);
INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.11.05','2016.10.17','1600',1);
INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.11.01','2016.10.17','1600',1);

INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,1,1,1,NULL );
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,2,2,2,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,3,3,3,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,4,4,4,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,5,5,5,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,6,6,6,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,7,7,7,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,8,8,8,NULL);

INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (2,1,1,1,NULL );
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (2,2,2,2,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (2,3,3,3,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (2,4,4,4,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (2,5,5,5,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (2,6,6,6,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (2,7,7,7,NULL);

INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (3,1,1,8,NULL );
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (3,2,2,9,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (3,3,3,10,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (3,4,4,11,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (3,5,5,12,NULL);
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (3,6,6,13,NULL);


INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event, result_event,bookmaker)
VALUES (1,'win','2016.10.17 20:12',2.6,'qqq','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (2,'win','2016.10.17 20:12',1.6,'qqq','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (3,'win','2016.10.17 20:12',1.5,'qqq','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (4,'win','2016.10.17 20:22',0.6,'qqq','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (5,'win','2016.10.17 20:12',1.0,'qqq','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (6,'win','2016.10.17 20:12',2.9,'qqq','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (7,'win','2016.10.17 20:12',3.6,NULL ,'dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (8,'win','2016.10.17 20:12',0.7,'qqq','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (9,'win','2016.10.17 20:12',2.8,NULL ,'dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (10,'win','2016.10.17 20:12',1.7,'qqq','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (11,'win','2016.10.17 20:12',2.6,'qqq','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (12,'win','2016.10.17 20:12',2.6,NULL ,'dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (13,'win','2016.10.17 20:12',2.6,NULL ,'dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (14,'win','2016.10.17 20:12',2.6,NULL ,'dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (3,'place','2016.10.17 20:12',1.6,NULL, 'dred1');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (4,'place','2016.10.17 20:12',2.6,NULL ,'dred1');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (5,'place','2016.10.17 20:12',2.0,'qqq','dred1');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (6,'place','2016.10.17 20:12',3.6,NULL, 'dred1');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (7,'place','2016.10.17 20:12',2.1,'qqq','dred1');




INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',1,1,'winer',10,2.6,'win',13.1);
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',2,1,'winer',20,2.6,'win',0);
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',2,2,'place',50,2.6,'win',0);
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',2,3,'winer',10,2.6,'win',11);
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',5,1,'winer',100,2.6,'win',NULL );
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',6,3,'winer',30,2.6,'win',NULL );
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',6,2,'winer',15,2.6,'win',NULL );
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',10,1,'winer',60,2.6,'win',NULL );

