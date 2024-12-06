(
    SELECT DATE_FORMAT(OS.SALES_DATE, "%Y-%m-%d") AS SALES_DATE, OS.PRODUCT_ID, OS.USER_ID, OS.SALES_AMOUNT
    FROM ONLINE_SALE OS
    WHERE OS.SALES_DATE LIKE "2022-03-%"
) UNION
(
    SELECT DATE_FORMAT(OFS.SALES_DATE, "%Y-%m-%d") AS SALES_DATE, OFS.PRODUCT_ID, NULL, OFS.SALES_AMOUNT
    FROM OFFLINE_SALE OFS
    WHERE OFS.SALES_DATE LIKE "2022-03-%"
)
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID
