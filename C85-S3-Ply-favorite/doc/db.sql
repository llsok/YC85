create table tag(
   tid int primary key auto_increment,
   tname varchar(50),
   tcount int
);

create table favorite(
   fid int primary key auto_increment,
   flabel  varchar(500),
   furl varchar(500),
   fdesc varchar(500),
   ftags varchar(500)
 );
--联合主键
create table tagfavorite(
	tid int,
    fid int,
    primary key (tid,fid)
);

alter table tagfavorite
	add constraint fk_tagfavorite_tid
	  foreign key(tid) references tag(tid);
	  
alter table tagfavorite
	add constraint fk_tagfavorite_fid
	  foreign key(fid) references favorite(fid);
	  
	  
select tag.tid,tname,tcount,favorite.fid,flabel,furl,flabel,fdesc,ftags 
from favorite 
left join tagfavorite on tagfavorite.fid=favorite.fid 
left join tag on tagfavorite.tid=tag.tid 

select
		favorite.fid,flabel,furl,fdesc,ftags
		from favorite
		left join tagfavorite
		on tagfavorite.fid=favorite.fid
		left join tag
		on tagfavorite.tid=tag.tid
		
drop table  tagfavorite;
drop table tag;
drop table  favorite;

delete from   tagfavorite;
delete from  tag;
delete from   favorite;

select * from tag;
select * from favorite;
select * from tagfavorite;



  