-- 1. 查找既是低脂又是可回收的产品编号
select product_id
from Products
where low_fats = 'Y'
  and recyclable = 'Y';

-- 2. 返回一个客户列表，列表中客户的推荐人的编号都 不是 2
select `name`
from customer
where referee_id != 2 or referee_id is null;

-- 3. 报告 大国 的国家名称、人口和面积 union 合并两个查询
select `name`, population, area
from World
where area >= 3000000
   or population >= 25000000;

-- 4. 查询以找出所有浏览过自己文章的作者，结果按照 id 升序排列。
-- 还可以使用 group by 进行过滤，效率比 distinct 要高
select distinct author_id as id
from Views
where author_id = viewer_id
order by id asc;

-- 5. 查询所有无效推文的编号（ID）。当推文内容中的字符数严格大于 15 时，该推文是无效的。
select tweet_id
from Tweets
where char_length(content) > 15;

-- 6. 查询来展示每位用户的 唯一标识码（unique ID ）；如果某位员工没有唯一标识码，使用 null 填充即可。
select ifnull(euni.unique_id, null) as unique_id, e.name
from Employees e
         left join EmployeeUNI euni on euni.id = e.id;

-- 7. 获取 Sales 表中所有产品对应的 产品名称 product_name 以及该产品的所有 售卖年份 year 和 价格 price
select p.product_name, s.year, s.price
from Sales s
         left join Product p on s.product_id = p.product_id;

-- 8. 查找这些顾客的 ID ，以及他们只光顾不交易的次数。
select v.customer_id, count(v.customer_id) as count_no_trans
from Visits v
         left join Transactions t on v.visit_id = t.visit_id
where t.transaction_id is null
group by v.customer_id

-- 9. 查找与之前（昨天的）日期相比温度更高的所有日期的 id
select wa.id
from Weather wa
         left join Weather wb on datediff(wa.recordDate, wb.recordDate) = 1
where wa.Temperature > wb.Temperature;

-- 10.






