
select e.EMP_NO,EMP_NAME, (case when avg(score)>=96 then 'S' when avg(score)>=90 then 'A' when avg(score)>=80 then 'B' else 'C' end) as grade,  SAL*(case when avg(score)>=96 then 0.2 when avg(score)>=90 then 0.15 when avg(score)>=80 then 0.1 else 0 end)as BONUS
from HR_DEPARTMENT  as d inner join HR_EMPLOYEES as e on d.DEPT_ID= e.DEPT_ID 
inner join HR_GRADE as g on e.EMP_NO= g.EMP_NO
group by e.emp_no
order by e.emp_no