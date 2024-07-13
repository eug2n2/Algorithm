-- 코드를 입력하세요
SELECT CATEGORY , sum(SALES) as TOTAL_SALES
from BOOK as b inner join BOOK_SALES as s on b.BOOK_ID= s.BOOK_ID
where DAte_format(SALES_DATE,"%y-%m") = "22-01"
group by CATEGORY
order by CATEGORY