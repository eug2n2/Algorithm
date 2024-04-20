select distinct ID, EMAIL, FIRST_NAME,LAST_NAME
from DEVELOPERS as d , SKILLCODES as s
where (SKILL_CODE & CODE)>0 AND CATEGORY = 'Front End'
order by id