-- 코드를 입력하세요
SELECT CATEGORY,PRICE as max_price,PRODUCT_NAME
from FOOD_PRODUCT  as f 
having f.price = (select Max(price) from FOOD_PRODUCT  as fd
where fd.category = f.category) and f.category in( "과자", "국","김치","식용유")
order by PRICE desc;