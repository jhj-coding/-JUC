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

#SQL83 确定已售出产品的总数
select sum(quantity) as items_ordered from OrderItems

#SQL84 确定已售出产品项 BR01 的总数
select sum(quantity) as items_ordered from OrderItems where prod_id="BR01"

#SQL85 确定 Products 表中价格不超过 10 美元的最贵产品的价格
select max(prod_price) as max_price from Products where prod_price<=10;

#SQL86 返回每个订单号各有多少行数
select order_num, count(order_num) as order_lines from OrderItems group by order_num order by order_lines

#SQL87 每个供应商成本最低的产品
select vend_id,min(prod_price) as cheapest_item from Products group by vend_id order by cheapest_item

#SQL88 返回订单数量总和不小于100的所有订单的订单号
select order_num from OrderItems group by order_num having sum(quantity) >=100 order by order_num

#SQL89 计算总和
select order_num,sum(item_price*quantity) from OrderItems group by order_num having sum(item_price*quantity)>=1000 order by order_num

#SQL90 纠错3
SELECT order_num, COUNT(*) AS items
FROM OrderItems
GROUP BY order_num
HAVING COUNT(*) >= 3
ORDER BY items, order_num;