SELECT F.CAR_ID,
CASE 
    WHEN S.ID IS NOT NULL THEN '대여중'
    ELSE '대여 가능'
END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS F 
LEFT JOIN
(SELECT CAR_ID AS ID 
 FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
 WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16') AS S
ON F.CAR_ID = S.ID
GROUP BY CAR_ID
ORDER BY CAR_ID DESC