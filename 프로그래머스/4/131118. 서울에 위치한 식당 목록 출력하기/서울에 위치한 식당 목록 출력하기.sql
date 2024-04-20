-- 코드를 입력하세요
SELECT i.REST_ID,i.REST_NAME,i.FOOD_TYPE,i.FAVORITES,i.ADDRESS,ROUND(AVG(REVIEW_SCORE),2) as SCORE
from REST_INFO as i inner join REST_REVIEW  as r on i.REST_ID=r.REST_ID and i.ADDRESS like"서울%"
group by i.REST_ID 
order by AVG(REVIEW_SCORE) desc, FAVORITES desc

# SELECT i.REST_ID,i.REST_NAME,i.FOOD_TYPE,i.FAVORITES,i.ADDRESS, REVIEW_SCORE
# from REST_INFO as i inner join REST_REVIEW  as r on i.REST_ID=r.REST_ID and ADDRESS like"%서울%"
# # group by i.REST_ID 
# order by  i.REST_ID 