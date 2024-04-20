-- 코드를 입력하세요
SELECT  c.CAR_ID
from CAR_RENTAL_COMPANY_CAR as c inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY  as h 
on c.CAR_ID=h.CAR_ID and CAR_TYPE='세단'
group by   c.CAR_ID
having c.CAR_ID in( select distinct CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY as r  where r.START_DATE BETWEEN "2022=10-01" AND "2022-10-31")
order by c.CAR_ID desc
# -- 코드를 입력하세요
# SELECT  *
# from CAR_RENTAL_COMPANY_CAR as c inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY  as h 
# on c.CAR_ID=h.CAR_ID and CAR_TYPE='세단'
# order by c.CAR_ID desc