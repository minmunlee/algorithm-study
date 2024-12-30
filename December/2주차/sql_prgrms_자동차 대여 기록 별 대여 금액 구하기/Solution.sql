SELECT HISTORY_ID, SUM(F) AS FEE
FROM 
(
    SELECT HISTORY_ID, FLOOR(DAILY_FEE * (1 - DISCOUNT_RATE / 100) * (DATEDIFF(END_DATE, START_DATE) + 1)
    ) F
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CR
    LEFT JOIN CAR_RENTAL_COMPANY_CAR S ON CR.CAR_ID = S.CAR_ID 
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN T ON S.CAR_TYPE = T.CAR_TYPE
        AND (
            (DATEDIFF(END_DATE, START_DATE) + 1 >= 90 AND DURATION_TYPE = '90일 이상') 
            OR
            (DATEDIFF(END_DATE, START_DATE) + 1 >= 30 AND DATEDIFF(END_DATE, START_DATE) + 1 < 90 AND DURATION_TYPE = '30일 이상') 
            OR
            (DATEDIFF(END_DATE, START_DATE) + 1 >= 7 AND DATEDIFF(END_DATE, START_DATE) + 1 < 30 AND DURATION_TYPE = '7일 이상')
        )
    WHERE S.CAR_TYPE = '트럭'
    
    UNION ALL # 할인 안되는거 합치기
    
    SELECT HISTORY_ID, FLOOR(DAILY_FEE * (DATEDIFF(END_DATE, START_DATE) + 1)) F
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CR
    LEFT JOIN CAR_RENTAL_COMPANY_CAR S ON CR.CAR_ID = S.CAR_ID 
    WHERE S.CAR_TYPE = '트럭' AND DATEDIFF(END_DATE, START_DATE) + 1 < 7
) TEMP
GROUP BY HISTORY_ID
ORDER BY FEE DESC, HISTORY_ID DESC;