-- 코드를 작성해주세요
/*
SELECT a.ID, b.FISH_NAME, MAX(LENGTH) LENGTH
FROM FISH_INFO a, FISH_NAME_INFO b
GROUP BY a.FISH_TYPE
WHERE a.FISH_TYPE = b.FISH_TYPE
*/


SELECT a.ID, c.FISH_NAME, a.LENGTH
FROM FISH_INFO a
JOIN (
    SELECT FISH_TYPE, MAX(LENGTH) AS MAX_LENGTH
    FROM FISH_INFO
    GROUP BY FISH_TYPE
) b
ON a.FISH_TYPE = b.FISH_TYPE AND a.LENGTH = b.MAX_LENGTH
JOIN FISH_NAME_INFO c ON a.FISH_TYPE = c.FISH_TYPE;