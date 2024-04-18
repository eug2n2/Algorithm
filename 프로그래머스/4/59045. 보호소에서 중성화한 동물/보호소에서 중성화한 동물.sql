-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
from ANIMAL_INS as i inner join ANIMAL_OUTS as o on i.ANIMAL_ID =o.ANIMAL_ID 
where SEX_UPON_INTAKE not like '%Spayed%'and SEX_UPON_INTAKE not like '%Neutered%'and (SEX_UPON_OUTCOME  like '%Spayed%' or SEX_UPON_OUTCOME like '%Neutered%')and i.DATETIME<=o.DATETIME
order by  ANIMAL_ID