-- 코드를 입력하세요
SELECT FOOD_TYPE,  REST_ID,REST_NAME,FAVORITES
from rest_info as r 

having FAVORITES = (select Max(FAVORITES) from rest_info where food_type = r.food_type)
order by FOOD_TYPE desc

# SELECT FOOD_TYPE, REST_NAME,FAVORITES
# from rest_info as r 