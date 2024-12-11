drop table if exists pet;

create table pet (
    id      serial primary key,
    user_id int,
    name    varchar(50),
    breed   varchar(50),
    foreign key (user_id) references "user" (id)
);