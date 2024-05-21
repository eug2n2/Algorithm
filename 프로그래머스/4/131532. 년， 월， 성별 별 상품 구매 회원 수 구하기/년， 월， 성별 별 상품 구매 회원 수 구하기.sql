



SELECT year(SALES_DATE) as YEAR , Month(SALES_DATE) as MONTH, u.GENDER ,count(distinct(u.USER_ID)) as USERS
from ONLINE_SALE as o inner join user_info as u on o.USER_ID= u.USER_ID 


group by 1,2,3
having u.gender is not null
order by 1,2,3