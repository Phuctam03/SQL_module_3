use a1222i1;
create table Employee(
    id int primary key auto_increment not null,
   last_name varchar(255) not null,
   first_name varchar(255),
   age int default 0 ,
   city varchar(255) default 'Da nang',
   check(age >= 18)
);
insert into persons(id,last_name,first_name,age) values ('1','ho','tam','20');
insert into persons(id,last_name,first_name,age) values ('4','nguyen','linh','20');
insert into employee(last_name,first_name,age, city) values ('ho','tam','20','Danang');	
insert into employee(last_name,first_name,age, city) values ('Nguyen','My','20','Danang');					
alter table Employee add column ngay_sinh date default '2023-07-08';
alter table Employee drop column ngay_sinh ;
update persons set last_name = 'Ton' where id = 3 and id = 4  ;





create database example;
use example;

create table users(
 user_id int auto_increment primary key,
 username varchar(40),
 password varchar(255),
 email varchar(255)
);
create table roles(
    role_id int auto_increment,
    role_name varchar(50),
    primary key(role_id)
);

create table userroles(
     user_id int not null,
     role_id int not null,
     primary key(user_id,role_id),
     foreign key(user_id) references users(user_id),
     foreign key(role_id) references  roles(role_id)
);






create database Customers;
use Customers;

create table customers(
  id int auto_increment primary key,
  name varchar(40),
  address varchar(255),
  email varchar(255)
);

create table orders(
   id int  auto_increment,
   staff varchar(50),
   primary key(id),
   customer_id int ,
   foreign key(customer_id) references customers(id)
);

-- bo sun them mot khoa chinh cho bang 
-- alter table table_name add primary key (primary_key_columns)
