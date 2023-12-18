#SQL195 查找最晚入职员工的所有信息
select * from employees order by hire_date desc limit 1;
#SQL196 查找入职员工时间排名倒数第三的员工所有信息 distinct去重
select * from employees where hire_date =(select distinct hire_date from employees order by hire_date desc limit 2,1);
#SQL197 查找当前薪水详情以及部门编号dept_no
select salaries.emp_no, salaries.salary, salaries.from_date, salaries.to_date, dept_manager.dept_no from salaries right join dept_manager on salaries.emp_no=dept_manager.emp_no order by salaries.emp_no;
#SQL198 查找所有已经分配部门的员工的last_name和first_name以及dept_no
select employees.last_name,employees.first_name,dept_emp.dept_no   from employees,dept_emp where employees.emp_no = dept_emp.emp_no;
#SQL199 查找所有员工的last_name和first_name以及对应部门编号dept_no
select employees.last_name,employees.first_name,dept_emp.dept_no  from employees left join dept_emp on employees.emp_no =dept_emp.emp_no
#SQL201 查找薪水记录超过15条的员工号emp_no以及其对应的记录次数t
select salaries.emp_no,count(salaries.emp_no) from salaries group by salaries.emp_no having count(salaries.emp_no)>15
#SQL202 找出所有员工当前薪水salary情况
select distinct salaries.salary from salaries order by salaries.salary desc;
#SQL204 获取所有非manager的员工emp_no
select employees.emp_no from employees where employees.emp_no not in (select dept_manager.emp_no from dept_manager);
#SQL205 获取所有员工当前的manager
select dept_emp.emp_no,dept_manager.emp_no as manager from dept_emp,dept_manager where dept_emp.dept_no =dept_manager.dept_no and dept_emp.emp_no not in (select dept_manager.emp_no from dept_manager);
#SQL206 获取每个部门中当前员工薪水最高的相关信息
select t2.dept_no, t2.emp_no,t2.salary from (select dept_emp.dept_no, max(salaries.salary) as maxSalary from dept_emp,salaries where dept_emp.emp_no=salaries.emp_no group by dept_emp.dept_no) t1,(select dept_emp.dept_no, dept_emp.emp_no,salaries.salary from dept_emp,salaries where dept_emp.emp_no=salaries.emp_no) t2 where t1.dept_no=t2.dept_no and t1.maxSalary=t2.salary order by t2.dept_no;
#SQL209 查找employees表emp_no与last_name的员工信息
select * from employees where employees.emp_no%2=1 && last_name !="Mary" order by hire_date desc;
#SQL210 统计出当前各个title类型对应的员工当前薪水对应的平均工资
select title, avg(salary) from titles,salaries where titles.emp_no =salaries.emp_no group by title;
#SQL211 获取当前薪水第二多的员工的emp_no以及其对应的薪水salary
select emp_no,salary from salaries where salary = (select distinct salary from salaries order by salary desc limit 1,1) order by salaries.emp_no asc;
#SQL212 获取当前薪水第二多的员工的emp_no以及其对应的薪水salary
select employees.emp_no,salaries.salary,employees.last_name,employees.first_name from employees,salaries where employees.emp_no =salaries.emp_no and salaries.salary=(select max(salaries.salary) from salaries where salaries.salary!=(select max(salaries.salary) from salaries));
#SQL213 查找所有员工的last_name和first_name以及对应的dept_name
select employees.last_name, employees.first_name, s.dept_name from employees left join (select departments.dept_name, dept_emp.emp_no, dept_emp.dept_no from departments, dept_emp where departments.dept_no = dept_emp.dept_no) as s on employees.emp_no = s.emp_no;
#SQL215 查找在职员工自入职以来的薪水涨幅情况
select a.emp_no, (b.salary-a.salary) as growth from (select employees.emp_no ,salaries.salary from employees,salaries where employees.emp_no =salaries.emp_no and employees.hire_date =salaries.from_date )as a,(select employees.emp_no ,salaries.salary from employees,salaries where employees.emp_no =salaries.emp_no and salaries.to_date="9999-01-01
" )as b where a.emp_no= b.emp_no order by growth
#SQL216 统计各个部门的工资记录数
select dept_emp.dept_no,departments.dept_name, count(*) as sum from dept_emp,departments,salaries where dept_emp.dept_no=departments.dept_no and dept_emp.emp_no=salaries.emp_no group by dept_emp.dept_no order by dept_emp.dept_no;
#SQL217 对所有员工的薪水按照salary降序进行1-N的排名
SELECT
    s1.emp_no,
    s1.salary,
    (SELECT
         COUNT(DISTINCT s2.salary)
     FROM
         salaries s2
     WHERE s2.salary >= s1.salary) AS `t_rank`  -- 去重：计算并列排名
FROM
    salaries s1
ORDER BY s1.salary DESC;

#SQL218 获取所有非manager员工当前的薪水情况
select dept_emp.dept_no,dept_emp.emp_no,salaries.salary  from dept_emp,employees,salaries where dept_emp.emp_no=employees.emp_no and salaries.emp_no=employees.emp_no and salaries.emp_no not in (select emp_no from dept_manager);

#SQL219 获取员工其当前的薪水比其manager当前薪水还高的相关信息
select dept_emp.emp_no, dept_manager.emp_no,a.salary,b.salary from dept_emp,dept_manager,salaries a,salaries b where dept_manager.dept_no=dept_emp.dept_no and dept_manager.emp_no=b.emp_no and dept_emp.emp_no=a.emp_no and a.salary>b.salary;

#SQL220 汇总各个部门当前员工的title类型的分配数目
select dept_emp.dept_no,departments.dept_name,titles.title,count(titles.title) from departments,dept_emp,titles where dept_emp.emp_no=titles.emp_no and departments.dept_no=dept_emp.dept_no group by departments.dept_no,titles.title order by departments.dept_no;

#SQL223 使用join查询方式找出没有分类的电影id以及名称
select film.film_id,film.title from film left join film_category on film.film_id=film_category.film_id where film_category.category_id is Null

#SQL224 使用子查询的方式找出属于Action分类的所有电影对应的title,description
select film.title,film.description from film where film.film_id in (select film_category.film_id from category,film_category where category.category_id=film_category.category_id and category.name="Action")

#SQL226将employees表的所有员工的last_name和first_name拼接起来作为Name
select concat(last_name," ",first_name) as Name from employees

#SQL227 创建一个actor表,包含如下列信息
create table `actor`(
                        `actor_id` smallint(5) not null primary key comment "主键id",
                        `first_name` varchar(45) not null comment "名字",
                        `last_name` varchar(45)	not null comment "姓氏",
                        `last_update` date not null comment "日期"
);

#SQL228 批量插入数据
insert into actor values(1,"PENELOPE","GUINESS",'2006-02-15 12:34:33'),(2,"NICK","WAHLBERG",'2006-02-15 12:34:33')

#SQL229 批量插入数据,不使用replace操作 
# mysql中常用的三种插入数据的语句:
# insert into表示插入数据,数据库会检查主键,如果出现重复会报错
# replace into表示插入替换数据,需求表中有PrimaryKey,
#             或者unique索引,如果数据库已经存在数据,则用新数据替换,如果没有数据效果则和insert into一样
# insert ignore表示,如果中已经存在相同的记录,则忽略当前新数据
insert ignore into actor values("3","ED","CHASE","2006-02-15 12:34:33");

#SQL230 创建一个actor_name表
CREATE TABLE  actor_name  (
                              first_name  varchar(45) NOT NULL,
                              last_name  varchar(45) NOT NULL);
insert into actor_name select first_name ,last_name from actor;

#SQL231 对first_name创建唯一索引uniq_idx_firstname
ALTER TABLE actor ADD UNIQUE uniq_idx_firstname (first_name);
ALTER TABLE actor ADD index idx_lastname (last_name);

#SQL232 针对actor表创建视图actor_name_view
create view actor_name_view (first_name_v,last_name_v) as select first_name,last_name from actor

#SQL233 针对上面的salaries表emp_no字段创建索引idx_emp_no
#强制使用索引 force index (idx_emp_no)
select
    *
from
    salaries force index (idx_emp_no)
where
    emp_no = 10005

#SQL234 在last_update后面新增加一列名字为create_date
alter table actor add column create_date datetime not null default '2020-10-01 00:00:00'

#SQL235 构造一个触发器audit_log
create trigger audit_log after insert on employees_test for each row begin
    insert into
        audit
    values
        (new.id, new.name);
end

#SQL236 删除emp_no重复的记录,只保留最小的id对应的记录.
DELETE from
    titles_test
where
        id not in (select * from (
                                     select
                                         MIN(id)
                                     from
                                         titles_test
                                     group by
                                         emp_no
                                 )a);

#SQL237 将所有to_date为9999-01-01的全部更新为NULL
update titles_test set to_date =null,from_date='2001-01-01' where to_date='9999-01-01'

#SQL238 将id=5以及emp_no=10001的行数据替换成id=5以及emp_no=10005
update titles_test set emp_no =replace(emp_no,10001,10005) where id=5

#SQL239 将titles_test表名修改为titles_2017
alter table titles_test RENAME to titles_2017

#SQL240 在audit表上创建外键约束,其emp_no对应employees_test表的主键id
ALTER TABLE audit
    ADD CONSTRAINT FOREIGN KEY (emp_no)
        REFERENCES employees_test(id);

#SQL242 将所有获取奖金的员工当前的薪水增加10%
update salaries set salary=salary*1.1 where salaries.to_date='9999-01-01' and emp_no in (select emp_no from emp_bonus)

#SQL244 将employees表中的所有员工的last_name和first_name通过引号连接起来
select concat(last_name,"\'",first_name) from employees

#SQL245 查找字符串中逗号出现的次数
select id, length(string)-length(replace(string,',','')) from strings

#SQL246 获取employees中的first_name
select first_name from employees order by substring(first_name,length(first_name)-1,2);

#SQL247 按照dept_no进行汇总
select dept_no,group_concat(emp_no) from dept_emp group by dept_no

#SQL248 平均工资
select (sum(salary)-max(salary)-min(salary))/(count(*)-2) from salaries where to_date = '9999-01-01'

#SQL249 分页查询employees表,每5行一页,返回第2页的数据
select * from employees limit 5 offset 5;

#SQL251 使用含有关键字exists查找未分配具体部门的员工的所有信息.
select * from employees where not exists (select emp_no from dept_emp where employees.emp_no=dept_emp.emp_no)

#SQL253 获取有奖金的员工相关信息.
select
    employees.emp_no,
    employees.first_name,
    employees.last_name,
    emp_bonus.btype,
    salaries.salary,
    salaries.salary * if (
                emp_bonus.btype = 1,
                0.1,
                if (emp_bonus.btype = 2, 0.2, 0.3)
        )
from
    employees,
    emp_bonus,
    salaries
where
        employees.emp_no = emp_bonus.emp_no
  and emp_bonus.emp_no = salaries.emp_no
  and salaries.to_date = '9999-01-01'

#SQL254 统计salary的累计和running_total
select emp_no,salary,sum(salary)over(order by emp_no) as running_total from salaries where to_date = '9999-01-01'

#SQL255 给出employees表中排名为奇数行的first_name
select first_name from (select *,rank() over (order by first_name) as rankNum from employees order by emp_no) as c where c.rankNum %2=1 ;

#SQL256 出现三次以上相同积分的情况
select number from grade group by number having count(number)>=3;

#SQL257 刷题通过的题目排名
select id
     ,number
     ,dense_rank()over(order by number desc) as t_rank
from passing_number;

#SQL258 找到每个人的任务
select person.id,name,content from person left join task on task.person_id=person.id

#SQL259 异常的邮件概率
select b.date,round(sum(if(b.type='no_completed',1,0))/count(*),3)  from (select * from email where send_id in (select id from user where is_blacklist =0) and receive_id in (select id from user where is_blacklist =0)) as b group by b.date order by b.date;

#SQL260 牛客每个人最近的登录日期(一)
select user_id, max(date) as id from login group by user_id order by user_id

#SQL261 牛客每个人最近的登录日期(二)
SELECT
    u.name AS u_n,
    c.name AS c_n,
    l.date
FROM
    login l
        JOIN user u ON l.user_id = u.id
        JOIN client c ON l.client_id = c.id
WHERE
        (l.user_id, l.date) IN (
        SELECT
            user_id,
            MAX(date)
        FROM
            login
        GROUP BY
            user_id
    )
ORDER BY
    u_n;

#SQL262 牛客每个人最近的登录日期(三)
SELECT
    ROUND(COUNT(DISTINCT user_id)*1.0 / (SELECT COUNT(DISTINCT user_id) FROM login), 3)
FROM login
WHERE (user_id, date)
          IN
      (SELECT user_id, DATE_ADD(MIN(date),INTERVAL 1 DAY) FROM login GROUP BY user_id);

#SQL263 牛客每个人最近的登录日期(四)
select a.date,count(b.user_id) from (select distinct login.date as date from login) as a left join (select user_id,min(date) as d from login group by user_id) as b on a.date=b.d group by a.date order by a.date