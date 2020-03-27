select * from porduct;
delete  from porduct where pname='苹果' or pname='火龙果';
commit;
insert into porduct
values(1,'苹果',15);
insert into porduct
values(7,'苹果',10);
insert into porduct
values(2,'龙眼',15);
insert into porduct
values(5,'枣子',15);
insert into porduct
values(8,'蛇果',15);
insert into porduct
values(9,'荔枝',15);
insert into porduct
values(10,'栗子',15);

COMMIT;


select * from(
select rownum as rn,productcode,pname,quantity
from (select * from porduct)
where rownum<=5)
where rn>=1;
