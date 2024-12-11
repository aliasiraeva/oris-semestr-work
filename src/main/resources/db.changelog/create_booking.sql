drop table if exists booking;

create table booking (
    id      serial primary key,
    pet_id  int,
    room_id int,
    start   timestamp,
    "end"   timestamp,
    foreign key (pet_id) references pet (id),
    foreign key (room_id) references room (id)
);