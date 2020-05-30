create database talkroom;

create table lottery(
    id int primary key auto_increment,
	opendate varchar(16),
	num varchar(10),
	redone varchar(2),
	redtwo varchar(2),
	redthree varchar(2),
	redfour varchar(2),
	redfive varchar(2),
	redsix varchar(2),
	blue varchar(2),
	sale varchar(20),
	firstprize varchar(4),
	secondeprize varchar(4)
);

insert into lottery values('2017-10-19','2017123','04','05','06','11','21','31','10','327,467,830','16','237');

select * from lottery;


select * from lottery order by opendate limit 0,10;

select count(*) from lottery;
delete from lottery;

drop table lottery;
