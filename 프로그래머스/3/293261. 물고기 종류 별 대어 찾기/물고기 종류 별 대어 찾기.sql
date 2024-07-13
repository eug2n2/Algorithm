-- 코드를 작성해주세요 ,LENGTH
select ID, FISH_NAME, length 
from FISH_INFO as f inner join FISH_NAME_INFO as n on f.FISH_TYPE= n.FISH_TYPE  
where (select max(length) from fish_info where FISH_TYPE = f.FISH_TYPE ) = length
order by ID