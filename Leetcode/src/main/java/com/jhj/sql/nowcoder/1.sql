#SQL1 查询所有列
select * from user_profile;

#SQL2 查询多列
select device_id,gender,age,university from user_profile

#SQL3 查询结果去重
select university from user_profile group by university;

#SQL4 查询结果限制返回行数
select device_id from user_profile limit 2;

#SQL5 将查询后的列重新命名
select device_id as user_infos_example from user_profile limit 2;

#SQL36 查找后排序
select user_profile.device_id,user_profile.age from user_profile order by age