SELECT c.CAR_ID, c.CAR_TYPE, round(30*DAILY_FEE*(1- DISCOUNT_RATE/100),0) as FEE 
FROM CAR_RENTAL_COMPANY_CAR as c inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h on c.CAR_ID =h.CAR_ID
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p on c.CAR_TYPE = p.CAR_TYPE 
where c.CAR_TYPE in ('세단','SUV') and DURATION_TYPE='30일 이상' and c.CAR_ID not in (select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where ("2022-11-01" between START_DATE and END_DATE)
        or ("2022-11-31" between START_DATE and END_DATE)) 
group by c.CAR_ID
having FEE between '500000' and '2000000'
order by FEE desc, c.car_type , c.car_id desc;

