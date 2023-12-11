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

#SQL67 返回固定价格的产品
select prod_id,prod_name from Products where prod_price=9.49

#SQL68 返回更高价格的产品
select prod_id,prod_name from Products  where prod_price>=9

#SQL69 返回产品并且按照价格排序
select prod_name,prod_price from Products where prod_price between 3 and 6 order by prod_price

#SQL70 返回更多的产品
select distinct order_num from OrderItems where quantity>=100

#SQL71 检索供应商名称
select vend_name from Vendors where vend_country='USA' and vend_state='CA'

#SQL72 检索并列出已订购产品的清单
select order_num, prod_id, quantity from OrderItems where quantity>=100 and prod_id in ('BR01','BR02','BR03')

#SQL73 返回所有价格在 3美元到 6美元之间的产品的名称和价格
select prod_name, prod_price from Products where prod_price between 3 and 6 order by prod_price

#SQL74 纠错2
SELECT vend_name
FROM Vendors
WHERE vend_country = 'USA' AND vend_state = 'CA' ORDER BY vend_name;

#SQL75 检索产品名称和描述(一)
select * from  Products where prod_desc like "%toy%";

#SQL76 检索产品名称和描述(二)
select * from Products where prod_desc not like '%toy%'

#SQL77 检索产品名称和描述(三)
select * from Products  where prod_desc like '%toy%' and prod_desc like '%carrots%';

#SQL78 检索产品名称和描述(四)
select * from Products where prod_desc like "%toy%carrots%";

#SQL79 别名
select vend_id,vend_name as vname,vend_address as vaddress,vend_city as vcity from Vendors  order by vname

#SQL80 打折
select prod_id,prod_price,0.9*prod_price as sale_price from Products

#SQL81 顾客登录名
select cust_id,cust_name, upper(concat(substring(cust_contact,1,2),substring(cust_city,1,3))) as user_login from Customers

#SQL82 返回 2020 年 1 月的所有订单的订单号和订单日期
select * from Orders where year(order_date)=2020 and month(order_date)=1 order by order_date