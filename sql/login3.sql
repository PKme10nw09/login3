drop database if exists login3;
create database login3;
use login3;
create table users(
	username varchar(255),
	password varchar(255)
);
insert into users values("taro","123");
insert into users values("jiro","456");
insert into users values("hanako","789");