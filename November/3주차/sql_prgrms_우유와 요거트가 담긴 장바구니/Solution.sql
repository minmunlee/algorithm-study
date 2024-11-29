SELECT a.CART_ID
FROM (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME = 'Milk') a 
JOIN (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME = 'Yogurt') b 
ON a.CART_ID = b.CART_ID
ORDER BY a.CART_ID