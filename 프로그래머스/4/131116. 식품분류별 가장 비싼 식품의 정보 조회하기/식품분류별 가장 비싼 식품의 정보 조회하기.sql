SELECT CATEGORY, PRICE as max_price, PRODUCT_NAME
FROM FOOD_PRODUCT as f
WHERE f.price = (
    SELECT MAX(price)
    FROM FOOD_PRODUCT as fd
    WHERE fd.category = f.category
) 
AND f.category IN ("과자", "국", "김치", "식용유")
ORDER BY PRICE DESC;