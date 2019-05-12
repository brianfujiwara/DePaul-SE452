alter table flights add origination_airport  long;
alter table flights add destination_airport  long;

create table airports (
    id int primary key auto_increment,
    code varchar(5),
    name varchar(20),
    city varchar(50),
    st_prov varchar(10)
);

insert into airports(code, name, city, st_prov) values ('ORD', 'OHare', 'Chicago', 'IL');
insert into airports(code, name, city, st_prov) values ('DEN', 'Denver International','Denver', 'CO');


update flights set origination_airport = (select id from airports where code = 'ORD');
update flights set destination_airport = (select id from airports where code = 'DEN');

