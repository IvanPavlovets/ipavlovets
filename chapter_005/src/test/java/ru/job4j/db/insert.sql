insert into role(role) values('Administrator');
insert into role(role) values('User');
insert into role(role) values('Guest');

insert into users(name, phone, role_id) values('Pavel', '8937395781', 1);
insert into users(name, phone, role_id) values('Petr', '8235987777', 2);
insert into users(name, phone, role_id) values('Ivan', '8323283333', 3);

insert into rules(rule) values('редактор');
insert into rules(rule) values('пользователь');
insert into rules(rule) values('наблюдатель');

insert into role_rules(role_id, rules_id) values(1, 1);
insert into role_rules(role_id, rules_id) values(2, 2);
insert into role_rules(role_id, rules_id) values(3, 3);

insert into item(name, users_id) values('test name1', 2);
insert into item(name, users_id) values('test name2', 3);
insert into item(name, users_id) values('test name3', 4);

insert into comments(description, item_id) values('test desc1', 2);
insert into comments(description, item_id) values('test desc2', 3);
insert into comments(description, item_id) values('test desc3', 4);

insert into attachs(fileName, path, item_id) values('file1', 'filePath_1', 2);
insert into attachs(fileName, path, item_id) values('file2', 'filePath_2', 3);
insert into attachs(fileName, path, item_id) values('file1', 'filePath_3', 4);

insert into state(state, item_id) values('state1', 2);
insert into state(state, item_id) values('state2', 3);
insert into state(state, item_id) values('state3', 4);

insert into categories(category, item_id) values('high', 2);
insert into categories(category, item_id) values('midlle', 3);
insert into categories(category, item_id) values('low', 4);