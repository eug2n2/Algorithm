# (select sum(bb.PRICE*ss.SALES) from BOOK as bb inner join author as aa on bb.AUTHOR_ID= aa.AUTHOR_ID
# inner join BOOK_SALES as ss on bb.BOOK_ID=ss.BOOK_ID where b.AUTHOR_ID=bb.AUTHOR_ID and b.CATEGORY=bb.CATEGORY) as TOTAL_SALES


# SELECT*
# from BOOK as b inner join  author as a on b.AUTHOR_ID= a.AUTHOR_ID
# inner join BOOK_SALES  as s on b.BOOK_ID=s.BOOK_ID and s.SALES_DATE between "2022-01-01" and "2022-01-31"
# order by b.AUTHOR_ID, CATEGORY desc;

SELECT b.AUTHOR_ID as AUTHOR_ID ,AUTHOR_NAME, CATEGORY , sum( price* sales) as TOTAL_SALES
from BOOK as b inner join author as a on b.AUTHOR_ID= a.AUTHOR_ID
inner join BOOK_SALES  as s on b.BOOK_ID=s.BOOK_ID and s.SALES_DATE between "2022-01-01" and "2022-01-31"
group by b.AUTHOR_ID , b.CATEGORY
order by b.AUTHOR_ID, CATEGORY desc;