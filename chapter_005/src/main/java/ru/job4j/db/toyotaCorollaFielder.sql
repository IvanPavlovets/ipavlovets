create table car_body(
  id serial primary key,
  name varchar(80)
);
create table engine(
  id serial primary key,
  name varchar(80)
);
create table transmission(
  id serial primary key,
  name varchar(80)
);
create table cars(
  id serial primary key,
  name varchar(80),
  car_body_id int references car_body(id),
  engine_id int references engine(id),
  transmission_id int references transmission(id)
);

insert into car_body(name) values ('NZE121G');
insert into car_body(name) values ('ZZE122G');
insert into car_body(name) values ('NZE141G');
insert into car_body(name) values ('ZRE144G');
insert into car_body(name) values ('ВАЗ 2181');

insert into engine(name) values ('1NZ-FE 110 л.с. бензин');
insert into engine(name) values ('1ZZ-FE 132 л.с. бензин');
insert into engine(name) values ('2ZZ-GE 190 л.с. бензин');
insert into engine(name) values ('2ZR-FE 125 л.с. бензин');
insert into engine(name) values ('3C-E 79 л.с. дизель');

insert into transmission(name) values ('МКПП');
insert into transmission(name) values ('АКПП');
insert into transmission(name) values ('Вариатор(CVT)');
insert into transmission(name) values ('Робот');

insert into cars(name, car_body_id, engine_id, transmission_id) values ('E120 1.5 X', 1, 1, 1);
insert into cars(name, car_body_id, engine_id, transmission_id) values ('E120 1.5 X', 1, 1, 2);
insert into cars(name, car_body_id, engine_id, transmission_id) values ('E120 1.8 S', 2, 2, 2);
insert into cars(name, car_body_id, engine_id, transmission_id) values ('E140 1.5 X', 3, 1, 1);
insert into cars(name, car_body_id, engine_id, transmission_id) values ('E140 1.8 S', 4, 4, 3);

--1. Вывести список всех машин и все привязанные к ним детали.
select c.name, c_b.name, e.name, t.name from cars c left outer join car_body c_b on c.car_body_id = c_b.id
                                                    left outer join engine e on c.engine_id = e.id
                                                    left outer join transmission t on c.transmission_id = t.id;

--2. Вывести отдельно детали (1 деталь - 1 запрос), которые не используются в машине, кузова, двигатели, коробки передач.
select c_b.name from car_body c_b left outer join cars c on c.car_body_id = c_b.id where c.id is null;
select e.name from engine e left outer join cars c on c.engine_id = e.id where c.id is null;
select t.name from transmission t left outer join cars c on c.transmission_id = t.id where c.id is null;