create table coupondetails(id serial primary key,
shopping_site varchar(50),
discount int not null,
purchasing_amount int not null,
start_date date not null,
expiry_date date not null, 
status varchar(10),CHECK( status in ('OPEN','CLOSED')));
insert into coupondetails(shopping_site,discount,purchasing_amount,start_date,expiry_date,status)
values('flipkart','25','4500','2021-06-12','2021-06-20','OPEN');
select*from coupondetails;