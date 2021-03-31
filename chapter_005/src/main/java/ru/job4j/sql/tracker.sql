create database tracker;

create table items(
  id serial primary key,
  name varchar(50),
  description varchar(255)
);

select * from items;