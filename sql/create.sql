create table coupondetails(id serial primary key,
shopping_site varchar(50),
discount int not null,
purchasing_amount int not null,
start_date date not null,
expiry_date date not null, 
status varchar(10));
insert into coupondetails(shopping_site,discount,purchasing_amount,start_date,expiry_date,status)
values('myntra','15','1500','2021-05-01','2021-01-05','closed');
select*from coupondetails;
