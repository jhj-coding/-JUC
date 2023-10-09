#SQL195 查找最晚入职员工的所有信息
select * from employees order by hire_date desc limit 1;