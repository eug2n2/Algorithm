select ID, 
case 
when size_of_colony>1000 then 'HIGH' 
when size_of_colony>100 then 'MEDIUM' 
else 'LOW' end as SIZE
FROM ECOLI_DATA
ORDER BY ID;