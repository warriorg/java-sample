drop table user_entity if exists;
create table user_entity (
   uid varchar(255) not null,
    age integer not null,
    name varchar(255),
    primary key (uid)
)