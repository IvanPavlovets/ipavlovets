create database drinks;

create table easy_drinks(id serial primary key, drink_name varchar(30), main varchar(30), amount1 dec(4,2), second varchar(30), amount2 dec(4,2), directions text);

select * from easy_drinks;

insert into easy_drinks values(1, 'Терновник', 'тоник', 1.5, 'ананасовый сок', 1, 'зболтать со льдом, разлить по бакалам, украсить лемоной цедрой');

update easy_drinks set directions = 'взболтать со льдом, разлить по бакалам, украсить лимонной цедрой';
update easy_drinks set second = 'черничный сок' where main = 'содовая';

insert into easy_drinks values(2, 'Голубая луна', 'содовая', 1.5, 'Черничный сок', 0.75, 'Взболтать со льдом, разлить по бакалам, украсить лимонной цедрой');
insert into easy_drinks values(3, 'Вот тебе на', 'персиковый нектар', 1, 'ананасовый сок', 1, 'Взболтать со льдом, разлить по стаканам');
insert into easy_drinks values(4, 'Лаймовый физз', 'Спрайт', 1.5, 'сок лайма', 0.75, 'Взболтать со льдом, разлить по стаканам');
insert into easy_drinks values(5, 'Поцелуй', 'вишневый сок', 2, 'абрикосовый нектар', 7, 'Подовать со льдом и соломинкой');
insert into easy_drinks values(6, 'Горячее золото', 'персиковый нектар', 3, 'апельсиновый сок', 6, 'влить в кружку горячий апельсиновый сок, добавить персиковый нектар');
insert into easy_drinks values(7, 'Одинокое дерево', 'содовая', 1.5, 'вишневый сок', 0.75, 'взболтать со льдом, разлить по бокалам');
insert into easy_drinks values(8, 'Борзая', 'содовая', 1.5, 'грейпфрутовый сок сок', 5, 'подовать со льдом, тщательно взболтать');
insert into easy_drinks values(9, 'Бабье лето', 'яблочный сок', 2, 'горячий чай', 6, 'налить сок в кружку, добавить горячий чай');
insert into easy_drinks values(10, 'Лягушка', 'холодный чай', 1.5, 'лимонад', 5, 'подовать на льду с ломтиком лайма');
insert into easy_drinks values(11, 'Сода плюс', 'содовая', 2, 'виноградный сок', 1, 'взболтать в бокале, подовать без льда');

select * from easy_drinks where main = 'Спрайт';
select * from easy_drinks where main = 'содовая';
select * from easy_drinks where amount2 = 6;
select * from easy_drinks where second = 'апельсиновый сок';
select * from easy_drinks where amount1 < 1.5;
select * from easy_drinks where amount2 < '1';
select * from easy_drinks where main > 'содовая';
select * from easy_drinks where amount1 > '1.5';

select drink_name, main, second from easy_drinks where main = 'содовая';
select drink_name from easy_drinks where main = 'вишневый сок';
select drink_name from easy_drinks where second = 'абрикосовый нектар';

select drink_name from easy_drinks where main = 'содовая' AND amount1 > 1;

select * from easy_drinks where amount1 >= 1.5 AND amount2 < 6;

select * from easy_drinks where drink_name >= 'Б' AND drink_name < 'Л';

select * from easy_drinks where main = 'вишневый сок' OR second = 'вишневый сок';
select * from easy_drinks where main = 'апельсиновый сок' OR main = 'яблочный сок';

update easy_drinks set second = 'грейпфрутовый сок' where second = 'грейпфрутовый сок сок';
select drink_name from easy_drinks where main LIKE '%ая';

select * from easy_drinks where amount1 >= 1.5 and amount1 <= 5
                            and amount2 >= 1.5 and amount2 <= 6;

select * from easy_drinks where amount2 < 2 or amount2 > 5;
select * from easy_drinks where drink_name between 'Д' and 'Я';

select * from easy_drinks where not main in ('тоник', 'Спрайт');

select * from easy_drinks where not drink_name <> 'Терновник';
select * from easy_drinks where drink_name = 'Терновник';

select * from easy_drinks where NOT main = 'содовая' and not main = 'холодный чай';

create table universities(
  id serial primary key,
  name varchar(255)
);

create table students(
  id serial primary key,
  name varchar(255),
  course int,
  budget bool,
  speciality varchar(255),
  enroll_date timestamp,
  university_id int references universities(id)
);

create table dates(
  id serial primary key,
  date_of_birth date
);

select * from dates;
insert into dates(date_of_birth) values('2000-10-02');
insert into dates(date_of_birth) values('2001/11/12');

select name, course, speciality from students;

select * from students where course = 2;
select * from students where course != 2;

select * from students where name is null;
select * from students where name is not null;

select * from students where enroll_date > '01.09.2018';
select * from students where course > 2;

select * from students where name like 'D%';

select * from students where name like 'D%' and course > 2;
select * from students where name like 'D%' or course > 2;

select current_date;
select current_date + interval '1 month';

select * from students order by speciality asc;
select * from students order by speciality desc;

select * from students where enroll_date < current_date - interval '2 year';

select * from students, universities;

select distinct course from students;

select * from students limit 4;

select * from students inner join universities
                  on university_id = students.university_id
where universities.name = 'U2';

select * from students, universities where universities.name = 'U3';
select * from students where name like '%D%';
select * from students where enroll_date >= current_date + interval '1 month';
select * from students where course = (SELECT max(course) from students);
select * from students order by course desc limit 1;
select count(*) from students, universities where universities.name = 'U2';
select * from students, universities where universities.name = 'U3' OR universities.name = 'U2';
select * from universities, students where university_id < 3 ;
select distinct universities.name from universities, students where (select count(university_id) from students) < 5 ;

select * from students;

create database work_db;
create table owners(
  id serial primary key,
  name varchar(255)
);

create table devices(
  id serial primary key,
  name varchar(255),
  owner_id int references owners(id)
);

insert into owners(name) values ('Owner 1');
insert into owners(name) values ('Owner 2');
insert into owners(name) values ('Owner 3');

insert into devices(name, owner_id) values ('Device 1', 1);
insert into devices(name, owner_id) values ('Device 2', 2);
insert into devices(name, owner_id) values ('Device 3', 3);
insert into devices(name, owner_id) values ('Device 4', null);
insert into devices(name, owner_id) values ('Device 5', null);
insert into devices(name, owner_id) values ('Device 6', 1);

select * from devices;

select * from devices d left join owners o on d.owner_id = o.id;
select * from devices d full join owners o on d.owner_id = o.id;
select * from owners o right join devices d on d.owner_id = o.id;
select * from devices d left join owners o on d.owner_id = o.id where o.id is null;
select * from owners o left join devices d on o.id = d.owner_id;

select * from cars;

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

select * from role;
select * from users;
select * from rules;
select * from role_rules;
select * from item;
select * from comments;
select * from attachs;
select * from state;
select * from categories;

create database tracker;

create table items(
  id serial primary key,
  name varchar(50),
  description varchar(255)
);
select * from items;

select * from demo_table;

select * from table1;

create table cities(
  id serial primary key,
  name text,
  population int
);
select * from cities;

create database spammer;
create table users(
  id serial primary key,
  name varchar(255),
  email varchar(255)
);
select * from users;
drop table users;