select d.DEPT_ID,DEPT_NAME_EN, round(avg(SAL)) as AVG_SAL
from HR_DEPARTMENT as d inner join HR_EMPLOYEES as e
on d.DEPT_ID = e.DEPT_ID
group by d.DEPT_ID
order by AVG_SAL desc;
                                