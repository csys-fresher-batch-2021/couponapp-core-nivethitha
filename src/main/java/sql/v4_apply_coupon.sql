select (purchasing_amount-(purchasing_amount*discount)/100) as bill_amount,coupon_code,id from coupondetails;
select expiry_date from coupondetails where coupon_code=" + "'" + couponCode + "'";