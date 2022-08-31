https://blog.csdn.net/chelseajcole/article/details/81938584



https://zhuanlan.zhihu.com/p/341458772


# Write your MySQL query statement below
select a.id,
    case
        when a.p_id is null then 'Root'
        when a.id in (select p_id from tree) then 'Inner'
        else 'Leaf'
    end as 'Type'
from tree a

##############
select a.id,    
    case
        when a.p_id is null then 'Root'
        when count(b.id) = 0 then 'Leaf'
        else 'Inner'
    end as 'Type'
from tree a
left join tree b
on a.id = b.p_id
group by a.id