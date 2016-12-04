
INSERT INTO account (login,password, data_register_account,status,balance,email,first_name,last_name,date_birth,address,is_delete)
VALUES ('log','pas','10.12.2016','ROLE_ADMIN',100.0,'a@r.ru','first1','last1','10.12.2016','address1',false);
INSERT INTO account (login,password, data_register_account,status,balance,email,first_name,last_name,date_birth,address,is_delete)
VALUES ('log2','pas2','10.03.2016','ROLE_USER',50.0,'a@r1.ru','first2','last2','10.12.2016','address2',false);
INSERT INTO account (login,password, data_register_account,status,balance,email,first_name,last_name,date_birth,address,is_delete)
VALUES ('log3','pas3','10.02.2016','ROLE_USER',30.0,'a@r2.ru','first3','last3','10.12.2016','address2',false);

-- INSERT INTO "client" (id,first_name, last_name,date_birth,address) VALUES (1,'Fedor','Gvin','10.12.2016','les');

INSERT INTO command (trainer,jockey,url_image_color) VALUES ('jon','uri','http1');
INSERT INTO command (trainer,jockey,url_image_color) VALUES ('igi','mor','http2');
INSERT INTO command (trainer,jockey,url_image_color) VALUES ('петя','коля','http3');
INSERT INTO command (trainer,jockey,url_image_color) VALUES ('петя1','коля1','http4');

INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster1',3,60,'1245','henk1');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster2',2,61,'245','henk2');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster3',2,62,'45','henk3');
INSERT INTO horse (nick_name,age,equipment_weight,form,owner)
VALUES ('faster4',2,62,'45','henk4');

INSERT INTO racecourse (name, country) VALUES ('germ','g');
INSERT INTO racecourse (name, country) VALUES ('germ1','g');

INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.12.05 11:00',NULL ,'1000',1);
INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.12.05 11:10',NULL ,'1500',1);
INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.12.05 11:10',NULL ,'1500',1);
INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.11.06 23:10',NULL ,'1500',1);
INSERT INTO race_card (date_start,date_finish,race_type,racecourse_id) VALUES ('2016.11.30 12:10',NULL ,'1500',2);

INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,1,1,1,NULL );
INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (2,2,2,2,NULL);
-- INSERT INTO race_detail (race_card_id,horse_id, command_id,number_start_box,horse_result) VALUES (1,3,3,3,NULL);

INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event, result_event,bookmaker)
VALUES (1,'WIN','2016.11.25 04:12',2.6,'UNKNOWN','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (2,'PLACE2','2016.11.25 04:12',1.6,'UNKNOWN','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (2,'WIN','2016.11.25 04:04',1.5,'UNKNOWN','dred');
INSERT INTO event (race_detail_id,event_type,date_register,coefficient_event,result_event,bookmaker)
VALUES (1,'PLACE2','2016.11.16 04:50',0.6,'UNKNOWN','dred');

INSERT INTO bet (date_bet,event_id,account_id,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.11.25 20:12',1,1,10,1,'ACTIVE',0);
INSERT INTO bet (date_bet,event_id,account_id,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.11.25 20:12',2,1,20,1,'ACTIVE',0);
INSERT INTO bet (date_bet,event_id,account_id,sum,coefficient_bet,status_bet,calculate) VALUES ('2016.11.08 10:12',3,2,5,2.0,'CLOSED',10);
