-- 코드를 입력하세요
SELECT USER_ID, NICKNAME,(select sum(price) from USED_GOODS_BOARD as gb inner join USED_GOODS_USER as gu on gb.WRITER_ID= gu.USER_ID where gb.STATUS = 'DONE' and gu.user_id = u.user_id) as PRICE
from USED_GOODS_BOARD as b inner join USED_GOODS_USER as u on b.WRITER_ID= u.USER_ID

group by user_id
having  PRICE>=700000
order by price;