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