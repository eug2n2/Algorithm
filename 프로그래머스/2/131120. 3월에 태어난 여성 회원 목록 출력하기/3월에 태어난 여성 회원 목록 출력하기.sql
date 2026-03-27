SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d')
from member_profile
where month(date_of_birth) = 3 and TLNO is not null and GENDER='W'
order by  MEMBER_ID;