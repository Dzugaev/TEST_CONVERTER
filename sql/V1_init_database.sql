-- DROP SCHEMA dzugaev CASCADE;
CREATE SCHEMA dzugaev;

CREATE TABLE dzugaev.logs
(
    id          bigserial                                      NOT NULL PRIMARY KEY,
    type        character varying COLLATE pg_catalog."default" NOT NULL,
    inner_value character varying COLLATE pg_catalog."default" NOT NULL,
    outer_value character varying COLLATE pg_catalog."default" NOT NULL,
    created     timestamp without time zone                    NOT NULL,
    user_id     bigint                                         NOT NULL

);

CREATE TABLE dzugaev.num_data
(
    name   character varying NOT NULL,
    number bigint            NOT NULL PRIMARY KEY
);

insert into dzugaev.num_data
values ('zero', '0');
insert into dzugaev.num_data
values ('one', '1');
insert into dzugaev.num_data
values ('two', '2');
insert into dzugaev.num_data
values ('three', '3');
insert into dzugaev.num_data
values ('four', '4');
insert into dzugaev.num_data
values ('five', '5');
insert into dzugaev.num_data
values ('six', '6');
insert into dzugaev.num_data
values ('seven', '7');
insert into dzugaev.num_data
values ('eight', '8');
insert into dzugaev.num_data
values ('nine', '9');
insert into dzugaev.num_data
values ('ten', '10');
insert into dzugaev.num_data
values ('eleven', '11');
insert into dzugaev.num_data
values ('twelve', '12');
insert into dzugaev.num_data
values ('thirdteen', '13');
insert into dzugaev.num_data
values ('fourteen', '14');
insert into dzugaev.num_data
values ('fiveteen', '15');
insert into dzugaev.num_data
values ('sixteen', '16');
insert into dzugaev.num_data
values ('seventeen', '17');
insert into dzugaev.num_data
values ('eightteen', '18');
insert into dzugaev.num_data
values ('nineteen', '19');
insert into dzugaev.num_data
values ('twenty', '20');
insert into dzugaev.num_data
values ('thirdty', '30');
insert into dzugaev.num_data
values ('fourty', '40');
insert into dzugaev.num_data
values ('fifty', '50');
insert into dzugaev.num_data
values ('sixty', '60');
insert into dzugaev.num_data
values ('seventy', '70');
insert into dzugaev.num_data
values ('eighty', '80');
insert into dzugaev.num_data
values ('ninety', '90');
insert into dzugaev.num_data
values ('hundred', '100');
insert into dzugaev.num_data
values ('thousand', '1000');
insert into dzugaev.num_data
values ('million', '1000000');
insert into dzugaev.num_data
values ('billion', '1000000000');

CREATE TABLE dzugaev.t_user
(
    id       bigserial NOT NULL PRIMARY KEY,
    username varchar   NOT NULL UNIQUE,
    password varchar   NOT NULL,
    active   boolean   NOT NULL
);


create table dzugaev.user_role
(
    user_id int8 not null,
    roles   varchar(255)
);
