create database food_shop_db;

create table type(id serial primary key,
 name varchar(100)
);

create table product(
  id serial primary key,
  name varchar(100),
  type_id int references type(id),
  expired_date date,
  price dec(7,2)
);

insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('МОРОЖЕНОЕ');
insert into type(name) values ('МАСЛО');
insert into type(name) values ('МЯСО');

insert into product(name, type_id, expired_date, price) VALUES ('российский', 1, '2021-03-20', 500.45);
insert into product(name, type_id, expired_date, price) VALUES ('литовский', 1, '2021-03-30', 552.00);
insert into product(name, type_id, expired_date, price) VALUES ('голандский', 1, '2021-03-28', 600.00);
insert into product(name, type_id, expired_date, price) VALUES ('любимое мороженое', 3, '2021-04-15', 35.00);
insert into product(name, type_id, expired_date, price) VALUES ('клубничное', 3, '2021-04-12', 50.00);
insert into product(name, type_id, expired_date, price) VALUES ('мясо свежемороженое', 5, '2023-04-12', 400.00);
insert into product(name, type_id, expired_date, price) VALUES ('луговое', 2, '2021-04-30', 85.00);
insert into product(name, type_id, expired_date, price) VALUES ('парное', 2, '2021-04-30', 59.00);
insert into product(name, type_id, expired_date, price) VALUES ('три коровы', 4, '2021-05-18', 112.00);

--1) Написать запрос получение всех продуктов с типом "СЫР"
select * from product left join type on product.type_id = type.id where type.name = 'СЫР';
select * from product, type where product.type_id = type.id AND type.name = 'СЫР';
select * from product where type_id = (select id from type where name = 'СЫР');

--2) Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product where name like '%мороженое%';

--3) Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product where EXTRACT(MONTH FROM expired_date) = EXTRACT(MONTH from now()) + 1;3
select * from product where expired_date < current_date + interval '30 day';

--4) Написать запрос, который выводит самый дорогой продукт.
select * from product where price = (SELECT max(price) from product);
select * from product order by price desc limit 1;

--5) Написать запрос, который выводит количество всех продуктов определенного типа. (например СЫР)
select count(*) from type, product where product.type_id = type.id AND type.name = 'СЫР'; 5

--6) Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product where type_id in ((select id from type where name = 'СЫР'), (select id from type where name = 'МОЛОКО')); 6

--7) Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select * from type where (select count(product.id) from product where product.type_id = type.id) < 2 ; 7

--8) Вывести все продукты и их тип.
select product.name, type.name from product left join type on product.type_id = type.id; 8