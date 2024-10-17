-- 코드를 작성해주세요
SELECT a.ID, (
    CASE
        WHEN b.PARENT_ID is null
        THEN 0
        ELSE COUNT(*)
    END
) as CHILD_COUNT
    FROM ECOLI_DATA a LEFT JOIN ECOLI_DATA b
    ON a.ID = b.PARENT_ID
    GROUP BY a.ID