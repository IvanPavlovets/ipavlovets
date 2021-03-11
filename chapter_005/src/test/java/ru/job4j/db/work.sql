create database work_db;
--1. Создать таблицы и заполнить их начальными данными
create table departments(
  id serial primary key,
  name varchar(255)
);

create table emploees(
  id serial primary key,
  name varchar(255),
  departments_id int references departments(id)
);
insert into departments(name) values ('Department 1');
insert into departments(name) values ('Department 2');
insert into departments(name) values ('Department 3');
insert into departments(name) values ('Department 4');

insert into emploees(name, departments_id) values ('Employee 1', 1);
insert into emploees(name, departments_id) values ('Employee 2', 2);
insert into emploees(name, departments_id) values ('Employee 3', 3);
insert into emploees(name, departments_id) values ('Employee 4', 2);
insert into emploees(name, departments_id) values ('Employee 5', null);
insert into emploees(name, departments_id) values ('Employee 6', 1);

select * from emploees;
select * from departments;

--2. Выполнить запросы с left, rigth, full, cross соединениями
select * from emploees e left join departments d on e.departments_id = d.id;
select * from departments d left join emploees e on d.id = e.departments_id;

select * from departments d right join emploees e on d.id = e.departments_id;

select * from emploees e full join departments d on e.departments_id = d.id;

select * from emploees e cross join departments d;

--3. Используя left join найти департаменты, у которых нет работников
select d.name from departments d left join emploees e on d.id = e.departments_id where e.departments_id is null;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат.
select d.name, e.name from emploees e right join departments d on e.departments_id = d.id;
select d.name, e.name from departments d left join emploees e on e.departments_id = d.id;

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
create table teens(
  id serial primary key,
  name varchar(255),
  gender char
);

insert into teens(name, gender) values ('Mike', 'M');
insert into teens(name, gender) values ('Sally', 'F');
insert into teens(name, gender) values ('John', 'M');
insert into teens(name, gender) values ('Olga', 'F');
insert into teens(name, gender) values ('Oleg', 'M');
insert into teens(name, gender) values ('Sam', 'M');
select * from teens;

select t1.name as boy, t2.name as girl from teens t1 cross join teens t2
where t1.gender = 'M' and t2.gender = 'F';

