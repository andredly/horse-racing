INSERT INTO "user" (first_name, last_name,gender,date,address) VALUES ('Fedor','Gvin','m','10.12.2016','les');
INSERT INTO "user" (first_name, last_name,gender,date,address) VALUES ('Mihal','Uro','m','11.02.2015','hom');
INSERT INTO "user" (first_name, last_name,gender,date,address) VALUES ('Olga','Ehova','f','01.05.2014','saray');
INSERT INTO "user" (first_name, last_name,gender,date,address) VALUES ('Бобик','Шариков','m','12.03.2012','будка');
INSERT INTO "user" (first_name, last_name,gender,date,address) VALUES ('Female','Masha','f','11.02.2015','usa');
INSERT INTO "user" (first_name, last_name,gender,date,address) VALUES ('Male','Her','m','02.05.2011','ger');
-- DELETE FROM "user";
SELECT * FROM "user";
INSERT INTO security_level (level,user_status) VALUES (1,'admin');
INSERT INTO security_level (level,user_status) VALUES (2,'user');
SELECT * FROM security_level;
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (1,'log','pas',1,100.0,'a@r.ru');
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (2,'log1','pas2',2,200.0,'f@r.ru');
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (3,'log2','pas3',2,10.0,'w@r.ru');
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (4,'log3','pas4',2,20.0,'j@r.ru');
INSERT INTO account (id,login,password,security_level_id,balance,email) VALUES (5,'log4','pas5',2,55.0,'l@r.ru');
SELECT * FROM account;

INSERT INTO horse (nick_name,age,equiptement_weight,form,racing,discription,owner)
VALUES ('faster1',3,60,'1245',104,'discript1','henk1');
INSERT INTO horse (nick_name,age,equiptement_weight,form,racing,discription,owner)
VALUES ('faster2',2,61,'245',112,'discript2','henk2');
INSERT INTO horse (nick_name,age,equiptement_weight,form,racing,discription,owner)
VALUES ('faster3',2,62,'45',121,'discript3','henk3');
INSERT INTO horse (nick_name,age,equiptement_weight,form,racing,discription,owner)
VALUES ('faster4',4,59,NULL ,112,'discript4','henk4');
INSERT INTO horse (nick_name,age,equiptement_weight,form,racing,discription,owner)
VALUES ('faster5',3,64,'1',121,'discript5','henk5');
INSERT INTO horse (nick_name,age,equiptement_weight,form,racing,discription,owner)
VALUES ('faster6',2,58,'12',101,'discript6','henk6');
INSERT INTO horse (nick_name,age,equiptement_weight,form,racing,discription,owner)
VALUES ('faster7',4,65,'34',110,'discript7','henk7');
INSERT INTO horse (nick_name,age,equiptement_weight,form,racing,discription,owner)
VALUES ('faster8',2,64,'567',110,'discript8','henk8');

INSERT INTO command (id,treiner,jockey,url_image_color) VALUES (1,'jon','uri','http1');
INSERT INTO command (id,treiner,jockey,url_image_color) VALUES (2,'igi','mor','http2');
INSERT INTO command (id,treiner,jockey,url_image_color) VALUES (3,'петя','коля','http3');
INSERT INTO command (id,treiner,jockey,url_image_color) VALUES (4,'roa','per','http4');
INSERT INTO command (id,treiner,jockey,url_image_color) VALUES (5,'dor','jus','http5');
INSERT INTO command (id,treiner,jockey,url_image_color) VALUES (6,'ver','vuy','http6');
INSERT INTO command (id,treiner,jockey,url_image_color) VALUES (7,'low','qer','http7');
INSERT INTO command (id,treiner,jockey,url_image_color) VALUES (8,'петя1','коля1','http8');

INSERT INTO race_card (date,race_type,racecource,count_horce,country) VALUES ('17.10.16','1000','denv',6,'rus');
INSERT INTO race_card (date,race_type,racecource,count_horce,country) VALUES ('17.10.16','1500','hits',6,'ger');
INSERT INTO race_card (date,race_type,racecource,count_horce,country) VALUES ('17.10.16','1600','colo',6,'usa');

INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (1,1,1,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (1,2,2,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (1,3,3,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (1,4,4,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (1,5,5,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (1,6,6,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (1,7,7,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (1,8,8,NULL ,NULL );


INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (2,1,1,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (2,2,2,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (2,3,3,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (2,4,4,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (2,5,5,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (2,6,6,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (2,7,7,NULL ,NULL );

INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (3,1,1,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (3,2,2,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (3,3,3,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (3,4,4,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (3,5,5,NULL ,NULL );
INSERT INTO race_detail (race_card_id,horse_id,number_start_box,date_finish,result) VALUES (3,6,6,NULL ,NULL );

INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,1,'win','17.10.2016',2.6,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,2,'win','17.10.2016',1.6,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,3,'win','17.10.2016',1.5,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,4,'win','17.10.2016',0.6,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,5,'win','17.10.2016',1.0,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,6,'win','17.10.2016',2.9,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,7,'win','17.10.2016',3.6,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,8,'win','17.10.2016',0.7,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (2,1,'win','17.10.2016',2.8,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (2,3,'win','17.10.2016',1.7,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (2,4,'win','17.10.2016',2.6,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (2,5,'win','17.10.2016',2.6,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (2,6,'win','17.10.2016',2.6,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (2,7,'win','17.10.2016',2.6,'dred');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (2,7,'place','17.10.2016',1.6,'dred1');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (2,6,'place','17.10.2016',2.6,'dred1');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (2,4,'place','17.10.2016',2.0,'dred1');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,8,'place','17.10.2016',3.6,'dred1');
INSERT INTO event (race_card_id,horse_id,event_type,data_register,coefficient,bookmaker)
VALUES (1,1,'place','17.10.2016',2.1,'dred1');




INSERT INTO bet (date,event_id,user_id,bet_type,sum,is_win,calculate) VALUES ('17.10.2016',1,1,'winer',10,NULL ,NULL );
INSERT INTO bet (date,event_id,user_id,bet_type,sum,is_win,calculate) VALUES ('17.10.2016',2,1,'winer',20,NULL ,NULL );
INSERT INTO bet (date,event_id,user_id,bet_type,sum,is_win,calculate) VALUES ('17.10.2016',2,2,'place',50,NULL ,NULL );
INSERT INTO bet (date,event_id,user_id,bet_type,sum,is_win,calculate) VALUES ('17.10.2016',2,3,'winer',10,NULL ,NULL );
INSERT INTO bet (date,event_id,user_id,bet_type,sum,is_win,calculate) VALUES ('17.10.2016',5,1,'winer',100,NULL ,NULL );
INSERT INTO bet (date,event_id,user_id,bet_type,sum,is_win,calculate) VALUES ('17.10.2016',6,3,'winer',30,NULL ,NULL );
INSERT INTO bet (date,event_id,user_id,bet_type,sum,is_win,calculate) VALUES ('17.10.2016',6,2,'winer',15,NULL ,NULL );
INSERT INTO bet (date,event_id,user_id,bet_type,sum,is_win,calculate) VALUES ('17.10.2016',10,1,'winer',60,NULL ,NULL );

