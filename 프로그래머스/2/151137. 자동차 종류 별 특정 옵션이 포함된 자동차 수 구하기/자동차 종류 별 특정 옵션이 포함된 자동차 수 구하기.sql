SELECT car_type , count(*) as cars
from CAR_RENTAL_COMPANY_CAR
WHERE options LIKE '%통풍시트%'
   OR options LIKE '%열선시트%'
   OR options LIKE '%가죽시트%'
group by car_type
order by car_type