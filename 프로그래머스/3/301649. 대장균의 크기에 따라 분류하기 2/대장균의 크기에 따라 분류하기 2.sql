with A AS ( select ID , Percent_rank() over(order by SIZE_OF_COLONY DEsc) as size from ECOLI_DATA 
)
select ID, case when size <0.25 then 'CRITICAL' when size <0.5 then 'HIGH' when size <0.75 then 'MEDIUM' else 'LOW' End as COLONY_NAME
from A 
order by Id;