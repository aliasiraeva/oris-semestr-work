drop table if exists "order";

create table "order" (
    id         serial primary key,
    date       timestamp,
    user_id    int,
    booking_id int,
    foreign key (user_id) references "user" (id),
    foreign key (booking_id) references booking (id)
);