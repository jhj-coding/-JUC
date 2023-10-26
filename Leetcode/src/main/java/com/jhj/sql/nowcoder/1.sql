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

#SQL37 查找后多列排序
select user_profile.device_id,user_profile.gpa,user_profile.age from user_profile order by user_profile.gpa,user_profile.age;

#SQL38 查找后降序排列
select user_profile.device_id,user_profile.gpa,user_profile.age from user_profile order by user_profile.gpa desc, user_profile.age desc;

#SQL6 查找学校是北大的学生信息
select user_profile.device_id,user_profile.university from user_profile where user_profile.university="北京大学";

SQL7 查找年龄大于24岁的用户信息
select user_profile.device_id, user_profile.gender, user_profile.age, user_profile.university from user_profile where user_profile.age>24;

#SQL8 查找某个年龄段的用户信息
select device_id,gender,age from user_profile where user_profile.age>=20 and user_profile.age<=23;

#SQL9 查找除复旦大学的用户信息
select device_id,gender,age,university from user_profile where university !="复旦大学"

#SQL10 用where过滤空值练习
select device_id,gender,age,university from user_profile where age is not null;

#SQL11 高级操作符练习(1)
select device_id,gender,age,university,gpa from user_profile where gpa>3.5 and gender="male"

#SQL12 高级操作符练习(2)
select device_id,gender,age,university,gpa from user_profile where gpa>3.7 or university="北京大学";