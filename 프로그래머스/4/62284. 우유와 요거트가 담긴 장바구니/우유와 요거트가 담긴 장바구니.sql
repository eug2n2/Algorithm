SELECT CART_ID 
from CART_PRODUCTS as main
group by CART_ID
having (SELECT count(CART_ID )
from CART_PRODUCTS as c where c.CART_ID = main.cart_id and c.name ="Milk")>0 and 
(SELECT count(CART_ID )
from CART_PRODUCTS as p where p.CART_ID = main.cart_id and p.name ="Yogurt")>0
order by CART_ID;