-- 코드를 입력하세요
SELECT  m.MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE,"%Y-%m-%d") as REVIEW_DATE
from MEMBER_PROFILE as m inner join REST_REVIEW as r on m.MEMBER_ID= r.MEMBER_ID

where m.MEMBER_ID = (select m.MEMBER_ID
from MEMBER_PROFILE as m inner join REST_REVIEW as r on m.MEMBER_ID= r.MEMBER_ID
group by m.MEMBER_ID
order by  count(*) desc
limit 1)
order by REVIEW_DATE, REVIEW_TEXT


