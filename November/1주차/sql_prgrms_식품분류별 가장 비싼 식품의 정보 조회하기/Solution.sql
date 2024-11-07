SELECT F.CATEGORY, F.MAX_PRICE, PRODUCT_NAME 
FROM FOOD_PRODUCT, (SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE 
                    FROM FOOD_PRODUCT 
                    GROUP BY CATEGORY HAVING CATEGORY IN ('과자', '국', '김치', '식용유')
                    ORDER BY PRICE) F
WHERE FOOD_PRODUCT.CATEGORY = F.CATEGORY AND FOOD_PRODUCT.PRICE = F.MAX_PRICE
ORDER BY MAX_PRICE DESC