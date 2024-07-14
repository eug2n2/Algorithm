-- 코드를 입력하세요
SELECT b.WRITER_ID ,NICKNAME, concat(CITY, " ", STREET_ADDRESS1 ," ", STREET_ADDRESS2)as 전체주소, concat(substring(TLNO,1,3),"-",substring(TLNO,4,4) , "-",substring(TLNO,8,4)) as 전화번호
from USED_GOODS_BOARD as b left outer join USED_GOODS_USER as u on b.WRITER_ID=u.USER_ID
group by b.WRITER_ID
having count(*) >=3
order by b.WRITER_ID desc