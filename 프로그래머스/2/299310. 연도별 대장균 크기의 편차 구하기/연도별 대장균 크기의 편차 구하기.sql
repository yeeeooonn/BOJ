-- 코드를 작성해주세요

select
b.YEAR, MAXYEAR - a.size_of_colony as YEAR_DEV,ID
from ECOLI_DATA a,
    (select YEAR(DIFFERENTIATION_DATE) YEAR, max(size_of_colony) MAXYEAR
        from ECOLI_DATA
        group by YEAR) b
where YEAR(a.DIFFERENTIATION_DATE) = b.YEAR
order by b.YEAR, YEAR_DEV