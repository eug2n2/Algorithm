with FRONT AS (
    SELECT SUM(CODE)
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
),
A as ( select case when (SKILL_CODE&(SELECT CODE FROM SKILLCODES WHERE NAME = 'python'))>0  AND SKILL_CODE & (SELECT * FROM FRONT) >0 then "A"

when  (SKILL_CODE&(SELECT CODE FROM SKILLCODES WHERE NAME = 'C#'))>0 then "B"
when SKILL_CODE & (SELECT * FROM FRONT) then "C"

END AS GRADE ,ID, EMAIL
from DEVELOPERS 


)
Select GRADE, ID, EMAIL
from A 
where grade is not null
order by Grade , ID;