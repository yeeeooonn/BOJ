-- 코드를 작성해주세요

SELECT a.ID, a.GENOTYPE, b.GENOTYPE as PARENT_GENOTYPE
FROM ECOLI_DATA a, (
    SELECT ID, GENOTYPE
    FROM ECOLI_DATA    
) b
WHERE a.PARENT_ID = b.ID AND (a.GENOTYPE & b.GENOTYPE = b.GENOTYPE) 
ORDER BY a.ID