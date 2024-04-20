with recursive gen_data as(
    select id, PARENT_ID, 1 as GENERATION
    from ECOLI_DATA 
    where PARENT_ID is null
    union all
    select e.id, e.parent_id, (g.GENERATION+1) as GENERATION
    from ECOLI_DATA as e
    inner join gen_data as g on e.parent_id= g.id
)
select (select count(*) from ECOLI_DATA as e right outer join gen_data as g on e.PARENT_ID =g.id where gg.GENERATION= g.GENERATION and e.id is null )as COUNT,gg.GENERATION
from gen_data as gg group by gg.GENERATION order by gg.GENERATION


