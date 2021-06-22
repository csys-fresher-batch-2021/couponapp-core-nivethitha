select (purchasing_amount-(purchasing_amount*discount)/100) as bill_amount,coupon_code,id from coupondetails;
select expiry_date from coupondetails where coupon_code=?;
select no_of_times_used from coupondetails where id= ?;
update coupondetails set no_of_times_used=? where id= ?;
select no_of_times_used as count from coupondetails where id=? and coupon_code=?;