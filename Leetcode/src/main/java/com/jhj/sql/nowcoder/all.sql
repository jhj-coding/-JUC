#SQL195 查找最晚入职员工的所有信息
select * from employees order by hire_date desc limit 1;
#SQL196 查找入职员工时间排名倒数第三的员工所有信息 distinct去重
select * from employees where hire_date =(select distinct hire_date from employees order by hire_date desc limit 2,1);
#SQL197 查找当前薪水详情以及部门编号dept_no
select salaries.emp_no, salaries.salary, salaries.from_date, salaries.to_date, dept_manager.dept_no from salaries right join dept_manager on salaries.emp_no=dept_manager.emp_no order by salaries.emp_no;