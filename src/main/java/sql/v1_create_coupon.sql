create table coupon_details(id serial primary key,
shopping_site varchar(50),
coupon_code varchar(20),	
created_date timestamp not null,
discount int not null,
purchasing_amount int not null,
start_date date not null,
expiry_date date not null, 
status varchar(10),CHECK( status in ('OPEN','CLOSED')));
insert into coupon_details(shopping_site,coupon_code,created_date,discount,purchasing_amount,start_date,expiry_date,status)
values('meesho','MEEZ671','2021-06-02 12:00',25,6000,'2021-08-05','2021-08-16','OPEN');
insert into coupon_details(shopping_site,coupon_code,created_date,discount,purchasing_amount,start_date,expiry_date,status)
values('flipkart','FLIP1020','2021-06-02 01:00',15,5000,'2021-07-12','2021-07-18','OPEN');
insert into coupon_details(shopping_site,coupon_code,created_date,discount,purchasing_amount,start_date,expiry_date,status)
values('myntra','MYNT1120','2021-05-03 12:05',10,2000,'2021-05-05','2021-05-10','CLOSED');
insert into coupon_details(shopping_site,coupon_code,created_date,discount,purchasing_amount,start_date,expiry_date,status)
values('amazon','AMZOG32','2021-06-10 04:00',20,4000,'2021-08-01','2021-08-05','OPEN');
select*from coupon_details;
