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

#SQL13 Where in 和Not in
select device_id,gender,age,university,gpa from user_profile where university in ("北京大学","山东大学","复旦大学");

#SQL14 操作符混合运用
select
    device_id,
    gender,
    age,
    university,
    gpa
from
    user_profile
where
    (
                gpa > 3.5
            and university = "山东大学"
        )
   or (
            gpa > 3.8
        and university = "复旦大学"
    );

#SQL15 查看学校名称中含北京的用户
select device_id,age,university from user_profile where university like '%北京%'

#SQL16 查找GPA最高值
select max(gpa) from user_profile where university="复旦大学"

#SQL17 计算男生人数以及平均GPA
select count(*),avg(gpa) from user_profile where gender="male"

#SQL18 分组计算练习题
select gender,university, count(*),avg(active_days_within_30),avg(question_cnt) from user_profile group by university,gender

#SQL19 分组过滤练习题
select university,avg(question_cnt) as avg_question_cnt,avg(answer_cnt) as avg_answer_cnt from user_profile group by university having avg(question_cnt)<5 or avg(answer_cnt)<20

#SQL20 分组排序练习题
select university,avg(question_cnt) as avg_question_cnt from user_profile group by university order by avg_question_cnt

#SQL21 浙江大学用户题目回答情况
select question_practice_detail.device_id,question_practice_detail.question_id,question_practice_detail.result from question_practice_detail,user_profile where user_profile.university="浙江大学" and question_practice_detail.device_id=user_profile.device_id;

#SQL22 统计每个学校的答过题的用户的平均答题数
select user_profile.university,count(question_practice_detail.question_id)/count(distinct user_profile.device_id) from user_profile right join question_practice_detail on user_profile.device_id=question_practice_detail.device_id group by user_profile.university

#SQL23 统计每个学校各难度的用户平均刷题数
select
    user_profile.university,
    question_detail.difficult_level,
    count(question_practice_detail.question_id) / count(distinct user_profile.device_id)
from
    user_profile,
    question_practice_detail,
    question_detail
where
        question_practice_detail.question_id = question_detail.question_id
  and user_profile.device_id = question_practice_detail.device_id
group by
    user_profile.university,
    question_detail.difficult_level;

#SQL24 统计每个用户的平均刷题数
select
    user_profile.university,
    question_detail.difficult_level,
    count(question_practice_detail.question_id) / count(distinct user_profile.device_id)
from
    user_profile,
    question_practice_detail,
    question_detail
where
        question_practice_detail.question_id = question_detail.question_id
  and user_profile.device_id = question_practice_detail.device_id
  and user_profile.university="山东大学"
group by
    user_profile.university,
    question_detail.difficult_level;

#SQL25 查找山东大学或者性别为男生的信息
select
    device_id,
    gender,
    age,
    gpa
from
    user_profile
where
        user_profile.university = "山东大学"
union all
select
    device_id,
    gender,
    age,
    gpa
from
    user_profile
where
        user_profile.gender = "male"

#CASE函数
#是一种多分支的函数,可以根据条件列表的值返回多个可能的结果表达式中的一个.
#可用在任何允许使用表达式的地方,但不能单独作为一个语句执行.
#SQL26 计算25岁以上和以下的用户数量
SELECT
    CASE
        WHEN age < 25
            OR age IS NULL THEN '25岁以下'
        WHEN age >= 25 THEN '25岁及以上'
        END age_cut,
    COUNT(*) number
FROM
    user_profile
GROUP BY
    age_cut

#SQL27 查看不同年龄段的用户明细
select
    device_id,
    gender,
    case
        when age < 20 then '20岁以下'
        when 20 <= age
            and age <= 24 then '20-24岁'
        when 25 <= age then '25岁及以上'
        when age is null then '其他'
        end age_cut
from
    user_profile

#SQL28 计算用户8月每天的练题数量
select
    day (date) as day,
    count(question_id) as question_cnt
from
    question_practice_detail
where
    month (date) = 8
  and year (date) = 2021
group by
    date

#SQL29 计算用户的平均次日留存率
select
        COUNT(t2.device_id) / COUNT(t1.device_id)
from
    (
        select DISTINCT
            device_id,
            date
        from
            question_practice_detail
    ) as t1
        left join (
        select DISTINCT
            device_id,
            date
        from
            question_practice_detail
    ) as t2 on t1.device_id = t2.device_id
        and t2.date = DATE_ADD (t1.date, interval 1 day);

#SQL30 统计每种性别的人数
select substring_index(profile,',',-1), count(*) from user_submit group by substring_index(profile,',',-1)

#SQL31 提取博客URL中的用户名
select
    device_id,substring_index (blog_url, '/', -1)
from
    user_submit

#SQL32 截取出年龄
select
    substring_index(substring_index (profile, ',', -2),',', 1) as age,
    count(*) as number
from
    user_submit
group by age
