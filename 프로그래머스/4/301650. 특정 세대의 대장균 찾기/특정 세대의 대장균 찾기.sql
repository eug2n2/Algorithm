# WITH RECURSIVE ECOLI_TREE AS (
#     SELECT 
#         ID, PARENT_ID , 1 GENERATION
#     FROM ECOLI_DATA
#     WHERE  PARENT_ID IS NULL
#     UNION ALL

#     -- Recursive
#     SELECT 
#         A.ID
#         , A.PARENT_ID
#         , B.GENERATION + 1
#     FROM 
#         ECOLI_DATA A
#         INNER JOIN ECOLI_TREE B 
#             ON A.PARENT_ID = B.ID
# )

# SELECT
#     ID
# FROM
#     ECOLI_TREE
# WHERE
#     GENERATION = 3
# ORDER BY 
#     ID

with recursive gen_data as (
    select ID, PARENT_ID, 1 as gen
    from ECOLI_DATA 
    where PARENT_ID is null 
    union all
    select e.ID, e.PARENT_ID, 1 + gen as gen
    from ECOLI_DATA as e
    inner join gen_data as g on e.PARENT_ID=g.id
)
select id from gen_data WHERE
    GEN = 3
ORDER BY 
    ID