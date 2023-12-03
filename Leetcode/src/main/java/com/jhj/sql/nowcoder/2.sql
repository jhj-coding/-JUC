#SQL60 从 Customers 表中检索所有的 ID
select cust_id from Customers

#SQL61 检索并列出已订购产品的清单
select distinct prod_id from OrderItems

#SQL62 检索所有列
select * from Customers

#SQL63 检索顾客名称并且排序
select cust_name from Customers order by cust_name desc

#SQL64 对顾客ID和日期排序
select cust_id,order_num from Orders order by cust_id asc, order_date desc

#SQL65 按照数量和价格排序
select * from OrderItems order by quantity desc,item_price desc

#SQL66 检查SQL语句
SELECT vend_name FROM Vendors ORDER by vend_name DESC;