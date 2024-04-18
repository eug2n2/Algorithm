select i.ITEM_ID,ITEM_NAME,RARITY
from ITEM_INFO as i inner join ITEM_TREE as t on i.ITEM_ID=t.ITEM_ID
where (select count(*) from ITEM_INFO as ii inner join ITEM_TREE as tt on ii.ITEM_ID=tt.ITEM_ID where PARENT_ITEM_ID is not null and i.Item_id=PARENT_ITEM_ID )=0
order by i.ITEM_ID desc;