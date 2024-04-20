with recursive gen_data as(
    select id, PARENT_ID, 1 as GENERATION
    from ECOLI_DATA 
    where PARENT_ID is null
    union all
    select e.id, e.parent_id, (g.GENERATION+1) as GENERATION
    from ECOLI_DATA as e
    inner join gen_data as g on e.parent_id= g.id
)
select count(*) as COUNT,GENERATION
from gen_data as g where id not in (select distinct parent_id from gen_Data where parent_id is not null )
group by g.GENERATION order by g.GENERATION
