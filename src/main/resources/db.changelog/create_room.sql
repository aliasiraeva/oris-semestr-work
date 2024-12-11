drop table if exists room;

create table room (
    id       serial primary key,
    name     varchar(20),
    building varchar(20),
    terms    text
);