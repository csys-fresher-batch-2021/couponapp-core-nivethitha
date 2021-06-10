create table coupondetails(id serial primary key,
shopping_site varchar(50),
coupon_code varchar(20),						   
discount int not null,
purchasing_amount int not null,
start_date date not null,
expiry_date date not null, 
status varchar(10),CHECK( status in ('OPEN','CLOSED')));
insert into coupondetails(shopping_site,coupon_code,discount,purchasing_amount,start_date,expiry_date,status)
values('meesho','MEEZ671',25,6000,'2021-08-05','2021-08-16','OPEN');
select * from coupondetails;
