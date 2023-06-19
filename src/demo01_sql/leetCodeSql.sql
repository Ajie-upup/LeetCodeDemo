-- 1. 查找既是低脂又是可回收的产品编号
select product_id
from Products
where low_fats = 'Y'
  and recyclable = 'Y';

-- 2. 返回一个客户列表，列表中客户的推荐人的编号都 不是 2
-- MySQL 使用三值逻辑 —— TRUE, FALSE 和 UNKNOWN。
-- 任何与 NULL 值进行的比较都会与第三种值 UNKNOWN 做比较。
-- 这个“任何值”包括 NULL 本身！这就是为什么 MySQL 提供 IS NULL 和 IS NOT NULL 两种操作来对 NULL 特殊判断。
select `name`
from customer
where referee_id != 2 or referee_id is null;

-- 3. 报告 大国 的国家名称、人口和面积 union 合并两个查询
select `name`, population, area
from World
where area >= 3000000
   or population >= 25000000;

-- 4.




