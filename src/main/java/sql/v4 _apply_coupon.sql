select (purchasing_amount-(purchasing_amount*discount)/100) as bill_amount,coupon_code,id from coupon_details;
select expiry_date from coupon_details where coupon_code=?;
select no_of_times_used from coupon_details where id=?;
update coupon_details set no_of_times_used=? where id=?;
select no_of_times_used as count from coupon_details where id=? and coupon_code=?;