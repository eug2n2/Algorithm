-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME
from ANIMAL_INS as i inner join  ANIMAL_OUTS as o on i.ANIMAL_ID=o.ANIMAL_ID
where o.datetime>=i.datetime
order by datediff(o.DATETIME,i.DATETIME) desc
limit 2;