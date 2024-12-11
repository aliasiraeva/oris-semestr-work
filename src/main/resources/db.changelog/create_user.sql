drop table if exists "user";

create table "user" (
    id       serial primary key,
    username varchar(50),
    password varchar(50)
);