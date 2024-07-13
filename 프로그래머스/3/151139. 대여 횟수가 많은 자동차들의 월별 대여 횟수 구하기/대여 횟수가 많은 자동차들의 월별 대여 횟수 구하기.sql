-- 코드를 입력하세요
SELECT Month(START_DATE) as MONTH , CAR_ID ,count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where '2022-07-31' <START_DATE and START_DATE<'2022-11-01' and car_id in
(select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where '2022-07-31' <START_DATE and START_DATE<'2022-11-01' group by car_id having count(car_id)>=5)
group by car_id, Month(START_DATE)
having RECORDS>=1
order by MONTH, CAR_ID desc;