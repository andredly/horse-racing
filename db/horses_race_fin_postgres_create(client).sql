CREATE TABLE "race_card" (
  "id" serial NOT NULL,
  "date_start" timestamptz NOT NULL,
  "date_finish" timestamptz,
  "race_type" character varying(128) NOT NULL,
  "racecourse_id" bigint NOT NULL,
  CONSTRAINT race_card_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "horse" (
  "id" serial NOT NULL,
  "nick_name" character varying(18) NOT NULL,
  "age" int NOT NULL,
  "equipment_weight" int NOT NULL,
  "form" character varying(256),
  "owner" character varying(256) NOT NULL,
  CONSTRAINT horse_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "command" (
  "id" serial NOT NULL,
  "name_command" character varying(256) NOT NULL,
  "trainer" character varying(256) NOT NULL,
  "jockey" character varying(256) NOT NULL,
  "url_image_color" character varying(1024) NOT NULL,
  CONSTRAINT command_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "race_detail" (
  "id" serial NOT NULL,
  "race_card_id" bigint NOT NULL,
  "horse_id" bigint NOT NULL,
  "command_id" bigint NOT NULL,
  "number_start_box" int NOT NULL,
  "horse_result" int,
  CONSTRAINT race_detail_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "event" (
  "id" serial NOT NULL,
  "race_detail_id" bigint NOT NULL,
  "event_type" character varying(256) NOT NULL,
  "date_register" timestamptz NOT NULL,
  "coefficient_event" double PRECISION NOT NULL DEFAULT '0',
  "bookmaker" character varying(256) NOT NULL,
  "result_event" character varying(64),
  CONSTRAINT event_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "bet" (
  "id" serial NOT NULL,
  "date" timestamptz NOT NULL,
  "event_id" bigint NOT NULL,
  "account_id" bigint NOT NULL,
  "bet_type" character varying(256) NOT NULL,
  "sum" double PRECISION NOT NULL,
  "coefficient_bet" double PRECISION NOT NULL,
  "status_bet" character varying(64) NOT NULL,
  "calculate" double PRECISION,
  CONSTRAINT bet_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "client" (
  "id" BIGINT NOT NULL,
  "first_name" character varying(256) NOT NULL,
  "last_name" character varying(256) NOT NULL,
  "date" DATE NOT NULL,
  "address" character varying(512) NOT NULL,
  CONSTRAINT client_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "account" (
  "id" SERIAL NOT NULL,
  "login" character varying NOT NULL,
  "password" character varying NOT NULL,
  "status" VARCHAR(16) NOT NULL,
  "balance" double PRECISION NOT NULL,
  "email" character varying(256) NOT NULL,
  CONSTRAINT account_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);

--
-- CREATE TABLE "account" (
--   "id" SERIAL NOT NULL,
--   "login" character varying NOT NULL,
--   "password" character varying NOT NULL,
--   "security_level_id" int NOT NULL,
--   "balance" double PRECISION NOT NULL,
--   "email" character varying(256) NOT NULL,
--   CONSTRAINT account_pk PRIMARY KEY ("id")
-- ) WITH (
-- OIDS=FALSE
-- );


--
-- CREATE TABLE "security_level" (
--   "id" serial NOT NULL,
--   "status" character varying(64) NOT NULL,
--   CONSTRAINT security_level_pk PRIMARY KEY ("id")
-- ) WITH (
-- OIDS=FALSE
-- );



CREATE TABLE "racecourse" (
  "id" serial NOT NULL,
  "name" character varying(256) NOT NULL,
  "country" character varying(256) NOT NULL,
  CONSTRAINT racecourse_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



ALTER TABLE "race_card" ADD CONSTRAINT "race_card_fk0" FOREIGN KEY ("racecourse_id") REFERENCES "racecourse"("id");

-- ALTER TABLE "horse" ADD CONSTRAINT "horse_fk0" FOREIGN KEY ("command_id") REFERENCES "command"("id");
-- ALTER TABLE "command" ADD CONSTRAINT "command_fk0" FOREIGN KEY ("id") REFERENCES "horse"("id");

ALTER TABLE "race_detail" ADD CONSTRAINT "race_detail_fk0" FOREIGN KEY ("race_card_id") REFERENCES "race_card"("id");
ALTER TABLE "race_detail" ADD CONSTRAINT "race_detail_fk1" FOREIGN KEY ("horse_id") REFERENCES "horse"("id");
ALTER TABLE "race_detail" ADD CONSTRAINT "race_detail_fk2" FOREIGN KEY ("command_id") REFERENCES "command"("id");

ALTER TABLE "event" ADD CONSTRAINT "event_fk0" FOREIGN KEY ("race_detail_id") REFERENCES "race_detail"("id");

ALTER TABLE "bet" ADD CONSTRAINT "bet_fk0" FOREIGN KEY ("event_id") REFERENCES "event"("id");
ALTER TABLE "bet" ADD CONSTRAINT "bet_fk1" FOREIGN KEY ("account_id") REFERENCES "account"("id");


ALTER TABLE "client" ADD CONSTRAINT "client_fk0" FOREIGN KEY ("id") REFERENCES "account"("id");
-- ALTER TABLE "account" ADD CONSTRAINT "account_fk1" FOREIGN KEY ("security_level_id") REFERENCES "security_level"("id");

ALTER TABLE "bet" ADD UNIQUE ( event_id , account_id );
ALTER TABLE "command" ADD UNIQUE ( name_command );
ALTER TABLE "race_detail" ADD UNIQUE ( race_card_id , horse_id );
ALTER TABLE "race_detail" ADD UNIQUE ( race_card_id , number_start_box );
ALTER TABLE "event" ADD UNIQUE ( race_detail_id , event_type );

CREATE UNIQUE INDEX account_login_uindex ON account (login);
-- CREATE UNIQUE INDEX security_level_status_uindex ON security_level (status);
CREATE UNIQUE INDEX horse_nick_name_uindex ON public.horse (nick_name);
CREATE UNIQUE INDEX racecourse_name_uindex ON public.racecourse (name);