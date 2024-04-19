set @hour =-1;
SELECT (@hour:=@hour+1) as HOUR , (select count(*) from ANIMAL_OUTS where hour(Datetime) =@hour) as COUNT
FROM ANIMAL_OUTS 
where @hour < 23
group by  HOUR
order by hour
