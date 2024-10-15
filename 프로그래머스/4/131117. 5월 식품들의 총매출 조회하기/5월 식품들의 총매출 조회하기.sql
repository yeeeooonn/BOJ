-- 코드를 입력하세요
 SELECT a.PRODUCT_ID, a.PRODUCT_NAME, b.TOTAL*a.PRICE as TOTAL_SALES
 FROM FOOD_PRODUCT a,
    (SELECT PRODUCT_ID, SUM(AMOUNT) as TOTAL
    FROM FOOD_ORDER
    WHERE YEAR(PRODUCE_DATE) = 2022 AND MONTH(PRODUCE_DATE) = 5
    GROUP BY PRODUCT_ID) b
WHERE a.PRODUCT_ID = b.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC