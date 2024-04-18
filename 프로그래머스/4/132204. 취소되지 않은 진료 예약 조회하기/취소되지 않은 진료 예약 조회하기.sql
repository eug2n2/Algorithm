# -- 코드를 입력하세요
SELECT APNT_NO,p.PT_NAME,p.PT_NO,d.MCDP_CD,DR_NAME,APNT_YMD
from PATIENT as p inner join APPOINTMENT as a on p.PT_NO =a.PT_NO	
inner join DOCTOR as d on d.DR_ID =a.MDDR_ID
where d.MCDP_CD='CS' and APNT_CNCL_YN='N' and  Date_format(APNT_YMD,'%Y-%m-%d')='2022-04-13'
order by APNT_YMD
