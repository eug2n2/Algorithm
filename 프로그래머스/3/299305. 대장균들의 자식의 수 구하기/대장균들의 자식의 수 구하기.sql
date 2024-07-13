select distinct id, (select count(*) from ECOLI_DATA where parent_id = e.id) as CHILD_COUNT
from ECOLI_DATA  as e
order by id;