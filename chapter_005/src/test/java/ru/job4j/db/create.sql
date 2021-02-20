create table role(
  id serial primary key,
  role varchar(30)
);

create table users(
  id serial primary key,
  name varchar(100),
  phone char(10),
  role_id int references role(id)
);

create table rules(
  id serial primary key,
  rule varchar(30)
);

create table role_rules(
  id serial primary key,
  role_id int references role(id),
  rules_id int references rules(id)
);

create table item(
  id serial primary key,
  name varchar(50),
  users_id int references users(id)
);

create table comments(
  id serial primary key,
  description text,
  item_id int references item(id)
);

create table attachs(
  id serial primary key,
  fileName varchar(40),
  path varchar(100),
  item_id int references item(id)
);

create table state(
  id serial primary key,
  state varchar(50),
  item_id int references item(id)
);

create table categories(
  id serial primary key,
  category varchar(50),
  item_id int references item(id)
);
