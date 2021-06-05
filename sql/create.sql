create table coupondetails(id serial primary key,
shopping_site varchar(50),
discount int not null,
purchasing_amount int not null,
start_date date not null,
expiry_date date not null, 
status varchar(10),CHECK( status in ('OPEN','CLOSED')));
insert into coupondetails(shopping_site,discount,purchasing_amount,start_date,expiry_date,status)
values('myntra',15,4000,'2021-05-12','2021-05-18','CLOSED');
select*from coupondetails;
