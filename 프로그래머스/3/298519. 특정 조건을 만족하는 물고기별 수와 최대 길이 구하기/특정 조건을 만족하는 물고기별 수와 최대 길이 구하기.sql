select count(*) as FISH_COUNT, MAX(length) as MAX_LENGTH, FISH_TYPE
from FISH_INFO 
group by FISH_TYPE
having avg(ifnull(length,10))>=33
order by FISH_TYPE;