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