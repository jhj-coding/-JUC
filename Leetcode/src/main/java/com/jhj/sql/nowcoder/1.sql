#SQL1 查询所有列
select * from user_profile;

#SQL2 查询多列
select device_id,gender,age,university from user_profile

#SQL3 查询结果去重
select university from user_profile group by university;