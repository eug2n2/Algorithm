select Year(YM)as Year, Round(AVG(PM_VAL1),2) as PM10 , Round(AVG(PM_VAL2),2) as 'PM2.5' 
from AIR_POLLUTION as a
where LOCATION2 ='수원'
group by Year(YM) 
order by Year