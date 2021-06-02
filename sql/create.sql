create table coupondetails(id serial primary key,
ShoppingSite varchar(50),
Discount int not null,
PurchasingAmount int not null,
Validity varchar(50),
Status varchar(10));
insert into coupondetails(ShoppingSite,Discount,PurchasingAmount,Validity,Status)
values('Meesho','18','2000','21st-25th July 2021','active');
select*from coupondetails;
