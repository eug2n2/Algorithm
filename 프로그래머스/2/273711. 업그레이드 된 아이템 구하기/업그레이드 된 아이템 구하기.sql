with cte as (select it.ITEM_ID, ITEM_NAME, RARITY from item_info as ii inner join item_tree as it on ii.ITEM_ID =it.ITEM_ID  )

select t.ITEM_ID, cte.ITEM_NAME, cte.RARITY
from item_info as i inner join item_tree as t on i.item_id =t.PARENT_ITEM_ID 
inner join cte on t.item_id = cte.item_id
where i.rarity ='RARE' and t.parent_item_id is not null 
order by t.ITEM_ID desc;