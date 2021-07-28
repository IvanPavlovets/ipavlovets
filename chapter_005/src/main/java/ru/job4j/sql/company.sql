create table company(
  id integer NOT NULL,
  name character varying,
  CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
  id integer NOT NULL,
  name character varying,
  company_id integer references company(id),
  CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company values(1, 'alfa');
insert into company values(2, 'beta');
insert into company values(3, 'gamma');
insert into company values(4, 'delta');
insert into company values(5, 'epsilon');

insert into person values(1, 'Ivan', 1);
insert into person values(2, 'Petr', 1);
insert into person values(3, 'Ilia', 1);

insert into person values(4, 'Lev', 2);
insert into person values(5, 'Michail', 2);
insert into person values(6, 'Lida', 2);

insert into person values(7, 'Masha', 3);
insert into person values(8, 'Alex', 3);
insert into person values(9, 'Sveta', 3);

insert into person values(10, 'Ekaterina', 4);
insert into person values(11, 'Anton', 4);
insert into person values(12, 'Fedor', 4);

insert into person values(13, 'Ivan', 5);
insert into person values(14, 'Petr', 5);
insert into person values(15, 'Ilia', 5);
insert into person values(16, 'Ilia', 5);

select * from company;
select * from person;

--1. В одном запросе получить
-- имена всех person, которые не состоят в компании с id = 5;
-- название компании для каждого человека.
select p.name, c.name from (select * from person where company_id <> 5) p left outer join company c on p.company_id = c.id;
-- 2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании.
select c.name, count(*) as amount
from company c join
person p on c.id = p.company_id
group by c.id, c.name
order by count(*) desc
limit 1;
