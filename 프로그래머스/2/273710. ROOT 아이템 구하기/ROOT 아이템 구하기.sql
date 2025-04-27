select i.ITEM_ID,ITEM_NAME
from item_info as i inner join item_tree as t 
on i.ITEM_ID = t.ITEM_ID
where ISNULL(PARENT_ITEM_ID)
order by i.ITEM_ID;