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

-- 10. 计算每台机器各自完成一个进程任务的平均耗时
select a.machine_id, round(avg(b.timestamp - a.timestamp), 3) as processing_time
from Activity as a
         left join Activity as b
                   on a.machine_id = b.machine_id
                       and a.process_id = b.process_id
where a.activity_type = "start"
  and b.activity_type = "end"
group by a.machine_id;

-- 11. 选出所有 bonus < 1000 的员工的 name 及其 bonus
select e.name, b.bonus
from Employee e
         left join Bonus b on e.empId = b.empId
where b.bonus < 1000
   or b.bonus is null;

-- 12. 查询出每个学生参加每一门科目测试的次数，结果按 student_id 和 subject_name 排序
select stu.student_id           as student_id,
       stu.student_name         as student_name,
       sub.subject_name         as subject_name,
       count(exam.subject_name) as attended_exams
from Students as stu
         cross join Subjects as sub
         left join Examinations as exam
                   on stu.student_id = exam.student_id and exam.subject_name = sub.subject_name
group by stu.student_id, sub.subject_name
order by stu.student_id;

-- 13. 查询至少有5名直接下属的经理
select name
from Employee
where id in
      (select managerId from Employee group by managerId having count(1) >= 5);

-- 14. 查找每个用户的 确认率
select s.user_id, round(sum(if(action='confirmed',1, 0)) / count(s.user_id), 2) as confirmation_rate
from Signups s
         left join Confirmations con on s.user_id = con.user_id
group by s.user_id;

-- 15. 找出所有影片描述为非 boring (不无聊) 的并且 id 为奇数 的影片，结果请按等级 rating 排列
select *
from cinema
where description != "boring" and  mod(id , 2) =1
order by rating desc;

-- 16. 查找每种产品的平均售价
select p.product_id,
       round(sum(p.price * u.units) / sum(u.units), 2) as average_price
from Prices p
         left join UnitsSold u on p.product_id = u.product_id
where u.purchase_date between p.start_date and p.end_date
group by p.product_id;

-- 17. 查询每一个项目中员工的 平均 工作年限，精确到小数点后两位
select p.project_id, round(avg(e.experience_years), 2) as average_years
from Project p
         left join Employee e on p.employee_id = e.employee_id
group by p.project_id;
