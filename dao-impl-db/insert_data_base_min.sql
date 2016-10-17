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