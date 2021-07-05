
-----------users coupon table----------

create table user_coupons(
id serial,
coupon_id int ,
mobile_number bigint,
email_id varchar(50),
coupon_code varchar(20),	
purchasing_amount int,
discounted_amount int default 0,
created_date timestamp,
status varchar(10),
CHECK( status in ('SUCCESS','FAILURE')));

select*from user_coupons;
------------admin add coupon---------------
create sequence coupon_id_sequence
start with 101
increment by 1;
create table coupon_detail(id int primary key,
coupon_code varchar(20),
created_date timestamp not null,
discount int not null,
start_date date not null,
expiry_date date not null);
insert into coupon_detail(id,coupon_code,created_date,discount,start_date,expiry_date)
values(nextval('coupon_id_sequence'),'FLIP2020','2021-06-30 16:06:00',24,'2021-07-12','2021-07-18');
insert into coupon_detail(id,coupon_code,created_date,discount,start_date,expiry_date)
values(nextval('coupon_id_sequence'),'AMZOG32','2021-06-30 16:13:00',15,'2021-08-10','2021-08-15');
insert into coupon_detail(id,coupon_code,created_date,discount,start_date,expiry_date)
values(nextval('coupon_id_sequence'),'MYNT1120','2021-06-30 16:14:00',30,'2021-06-10','2021-06-15');
insert into coupon_detail(id,coupon_code,created_date,discount,start_date,expiry_date)
values(nextval('coupon_id_sequence'),'CLUB078','2021-06-30 16:15:00',42,'2021-07-05','2021-07-15');
insert into coupon_detail(id,coupon_code,created_date,discount,start_date,expiry_date)
values(nextval('coupon_id_sequence'),'JIO0980','2021-06-02 04:00:00',50,'2021-05-25','2021-05-30');
insert into coupon_detail(id,coupon_code,created_date,discount,start_date,expiry_date)
values(nextval('coupon_id_sequence'),'1MGKH56','2021-07-01 00:00:00',10,'2021-06-01','2021-06-10');
select*from coupon_detail;