-- 코드를 입력하세요
SELECT FIRST_HALF.FLAVOR
FROM ICECREAM_INFO
JOIN FIRST_HALF
ON ICECREAM_INFO.FLAVOR = FIRST_HALF.FLAVOR
WHERE FIRST_HALF.TOTAL_ORDER > 3000 AND ICECREAM_INFO.INGREDIENT_TYPE = 'fruit_based'
ORDER BY FIRST_HALF.TOTAL_ORDER DESC;