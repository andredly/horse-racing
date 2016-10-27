INSERT INTO "client" (first_name, last_name,gender,date,address) VALUES ('Fedor','Gvin','m','10.12.2016','les');
INSERT INTO "client" (first_name, last_name,gender,date,address) VALUES ('Mihal','Uro','m','11.02.2015','hom');
INSERT INTO "client" (first_name, last_name,gender,date,address) VALUES ('Olga','Ehova','f','01.05.2014','saray');
INSERT INTO "client" (first_name, last_name,gender,date,address) VALUES ('Бобик','Шариков','m','12.03.2012','будка');
INSERT INTO "client" (first_name, last_name,gender,date,address) VALUES ('Female','Masha','f','11.02.2015','usa');
INSERT INTO "client" (first_name, last_name,gender,date,address) VALUES ('Male','Her','m','02.05.2011','ger');
-- DELETE FROM "client";
SELECT * FROM "client";
INSERT INTO security_level (client_status) VALUES ('admin');
INSERT INTO security_level (client_status) VALUES ('client');
SELECT * FROM security_level;
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (1,'log','pas',1,100.0,'a@r.ru');
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (2,'log1','pas2',2,200.0,'f@r.ru');
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (3,'log2','pas3',2,10.0,'w@r.ru');
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (4,'log3','pas4',2,20.0,'j@r.ru');
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (5,'log4','pas5',2,55.0,'l@r.ru');
SELECT * FROM account;



INSERT INTO command (id,trainer,jockey,url_image_color) VALUES (1,'jon','uri','http1');
INSERT INTO command (id,trainer,jockey,url_image_color) VALUES (2,'igi','mor','http2');
INSERT INTO command (id,trainer,jockey,url_image_color) VALUES (3,'петя','коля','http3');
INSERT INTO command (id,trainer,jockey,url_image_color) VALUES (4,'roa','per','http4');
INSERT INTO command (id,trainer,jockey,url_image_color) VALUES (5,'dor','jus','http5');
INSERT INTO command (id,trainer,jockey,url_image_color) VALUES (6,'ver','vuy','http6');
INSERT INTO command (id,trainer,jockey,url_image_color) VALUES (7,'low','qer','http7');
INSERT INTO command (id,trainer,jockey,url_image_color) VALUES (8,'петя1','коля1','http8');
INSERT INTO horse (nick_name,age,equiptement_weight,form,command_id,owner)
VALUES ('faster1',3,60,'1245',1,'henk1');
INSERT INTO horse (nick_name,age,equiptement_weight,form,command_id,owner)
VALUES ('faster2',2,61,'245',2,'henk2');
INSERT INTO horse (nick_name,age,equiptement_weight,form,command_id,owner)
VALUES ('faster3',2,62,'45',3,'henk3');
INSERT INTO horse (nick_name,age,equiptement_weight,form,command_id,owner)
VALUES ('faster4',4,59,NULL ,4,'henk4');
INSERT INTO horse (nick_name,age,equiptement_weight,form,command_id,owner)
VALUES ('faster5',3,64,'1',5,'henk5');
INSERT INTO horse (nick_name,age,equiptement_weight,form,command_id,owner)
VALUES ('faster6',2,58,'12',6,'henk6');
INSERT INTO horse (nick_name,age,equiptement_weight,form,command_id,owner)
VALUES ('faster7',4,65,'34',7,'henk7');
INSERT INTO horse (nick_name,age,equiptement_weight,form,command_id,owner)
VALUES ('faster8',2,64,'567',8,'henk8');


INSERT INTO racecourse (id, name, country) VALUES (1,'germ','g');
INSERT INTO racecourse (id, name, country) VALUES (2,'usa','us');
INSERT INTO racecourse (id, name, country) VALUES (3,'angl','an');

INSERT INTO race_card (date_start,data_finish,race_type,racecourse_id) VALUES ('2016.10.17','2016.10.17','1000',1);
INSERT INTO race_card (date_start,data_finish,race_type,racecourse_id) VALUES ('2016.10.17','2016.10.17','1500',1);
INSERT INTO race_card (date_start,data_finish,race_type,racecourse_id) VALUES ('2016.10.17','2016.10.17','1600',1);

INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (1,1,1,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (1,2,2,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (1,3,3,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (1,4,4,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (1,5,5,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (1,6,6,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (1,7,7,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (1,8,8,NULL);

INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (2,1,1,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (2,2,2,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (2,3,3,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (2,4,4,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (2,5,5,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (2,6,6,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (2,7,7,NULL);

INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (3,1,1,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (3,2,2,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (3,3,3,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (3,4,4,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (3,5,5,NULL);
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,horse_result) VALUES (3,6,6,NULL);


INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event, result_event,bookmaker)
VALUES (1,1,'win','2016.10.17 20:12',2.6,'qqq','dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (1,2,'win','2016.10.17 20:12',1.6,'qqq','dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (1,3,'win','2016.10.17 20:12',1.5,'qqq','dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (1,4,'win','2016.10.17 20:122',0.6,'qqq','dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (1,5,'win','2016.10.17 20:12',1.0,'qqq','dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (1,6,'win','2016.10.17 20:12',2.9,'qqq','dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (1,7,'win','2016.10.17 20:12',3.6,NULL ,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (1,8,'win','2016.10.17 20:12',0.7,'qqq','dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (2,1,'win','2016.10.17 20:12',2.8,NULL ,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (2,3,'win','2016.10.17 20:12',1.7,'qqq','dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (2,4,'win','2016.10.17 20:12',2.6,'qqq','dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (2,5,'win','2016.10.17 20:12',2.6,NULL ,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (2,6,'win','2016.10.17 20:12',2.6,NULL ,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (2,7,'win','2016.10.17 20:12',2.6,NULL ,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (2,7,'place','2016.10.17 20:12',1.6,NULL, 'dred1');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (2,6,'place','2016.10.17 20:12',2.6,NULL ,'dred1');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (2,4,'place','2016.10.17 20:12',2.0,'qqq','dred1');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (1,8,'place','2016.10.17 20:12',3.6,NULL, 'dred1');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient_event,result_event,bookmaker)
VALUES (1,1,'place','2016.10.17 20:12',2.1,'qqq','dred1');




INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',1,1,'winer',10,2.6,'win',13.1);
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',2,1,'winer',20,2.6,'win',0);
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',2,2,'place',50,2.6,'win',0);
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',2,3,'winer',10,2.6,'win',11);
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',5,1,'winer',100,2.6,'win',NULL );
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',6,3,'winer',30,2.6,'win',NULL );
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',6,2,'winer',15,2.6,'win',NULL );
INSERT INTO bet (date,event_id,account_id,bet_type,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.10.17 20:12',10,1,'winer',60,2.6,'win',NULL );

