SELECT B.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(SALES * PRICE) TOTAL_SALES
FROM BOOK B, AUTHOR A, BOOK_SALES BS
WHERE B.BOOK_ID = BS.BOOK_ID AND B.AUTHOR_ID = A.AUTHOR_ID
AND SALES_DATE LIKE '2022-01%'
GROUP BY B.AUTHOR_ID, CATEGORY
ORDER BY B.AUTHOR_ID, CATEGORY DESC