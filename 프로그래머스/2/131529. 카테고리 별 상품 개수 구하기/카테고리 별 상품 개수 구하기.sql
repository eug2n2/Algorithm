SELECT left(PRODUCT_CODE,2) as category , count(*) as products
from PRODUCT 
group by category
order by category